package lk.ijse.cmjd113.FoodOrderingSystem.service.impl;

import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import lk.ijse.cmjd113.FoodOrderingSystem.dao.FoodItemDAO;
import lk.ijse.cmjd113.FoodOrderingSystem.dao.OrderDAO;
import lk.ijse.cmjd113.FoodOrderingSystem.dao.OrderDetailDAO;
import lk.ijse.cmjd113.FoodOrderingSystem.dto.OrderDTO;
import lk.ijse.cmjd113.FoodOrderingSystem.dto.OrderDetailDTO;
import lk.ijse.cmjd113.FoodOrderingSystem.entities.FoodItemEntity;
import lk.ijse.cmjd113.FoodOrderingSystem.entities.OrderDetailEntity;
import lk.ijse.cmjd113.FoodOrderingSystem.entities.OrderEntity;
import lk.ijse.cmjd113.FoodOrderingSystem.entities.RestaurantEntity;
import lk.ijse.cmjd113.FoodOrderingSystem.service.OrderService;
import lk.ijse.cmjd113.FoodOrderingSystem.service.RestaurantService;
import lk.ijse.cmjd113.FoodOrderingSystem.util.Mapper;
import lombok.RequiredArgsConstructor;

@Service
@Transactional
@RequiredArgsConstructor
public class OrderServiceImpl implements OrderService {
    
    private final OrderDAO orderDAO; 
    private final OrderDetailDAO orderDetailDAO; 
    private final FoodItemDAO foodItemDAO; 
    private final RestaurantService restaurantService;
    private final Mapper mapper; 

    @Override
    @Transactional
    public OrderDTO placeOrder(OrderDTO orderDTO) {
        // 1. Mulin OrderEntity eka hadanawa
        OrderEntity orderEntity = mapper.toOrderEntity(orderDTO);
        orderEntity.setOrderDate(LocalDateTime.now());
        orderEntity.setOrderDetails(new ArrayList<>()); 

        if (orderDTO.getOrderDetails() != null && !orderDTO.getOrderDetails().isEmpty()) {
            Long firstFoodId = orderDTO.getOrderDetails().get(0).getFoodItemId();
            FoodItemEntity firstFood = foodItemDAO.findById(firstFoodId)
                    .orElseThrow(() -> new RuntimeException("Food Item not found!"));
            
            orderEntity.setRestaurant(firstFood.getRestaurant());
        } else {
            throw new RuntimeException("Order must have at least one item!");
        }

        // 2. Main Order eka save karanawa 
        OrderEntity savedOrder = orderDAO.save(orderEntity);

        // 3. OrderDetails tika save karanawa
        List<OrderDetailEntity> detailEntities = new ArrayList<>();
        
        for (OrderDetailDTO detailDTO : orderDTO.getOrderDetails()) {
            OrderDetailEntity detailEntity = new OrderDetailEntity();
            
            FoodItemEntity foodItem = foodItemDAO.findById(detailDTO.getFoodItemId())
                    .orElseThrow(() -> new RuntimeException("Food Item not found!"));

            detailEntity.setOrder(savedOrder); 
            detailEntity.setFoodItem(foodItem);
            detailEntity.setQuantity(detailDTO.getQuantity());
            detailEntity.setPrice(foodItem.getPrice()); 
            
            detailEntities.add(orderDetailDAO.save(detailEntity));
        }

        // 4. save wechcha dewal tika aaii DTO ekata harawala yawanawa
        savedOrder.setOrderDetails(detailEntities);
        return mapper.toOrderDTO(savedOrder);
    }

    @Override
    @Transactional(readOnly = true)
    public List<OrderDTO> getOrdersByUserId(Long userId) {
        // 1. Database eken adala user ge details gannawa.
        List<OrderEntity> orderEntities = orderDAO.findByUserId(userId);
        
        // 2. His DTo list ekak hadanawa
        List<OrderDTO> dtoList = new ArrayList<>();
        
        // 3. ekin eka DTO ekakata harawala list ekata add karanawa
        for (OrderEntity entity : orderEntities) {
            dtoList.add(mapper.toOrderDTO(entity));
        }
        
        return dtoList;
    }

    @Override
    @Transactional
    public OrderDTO updateOrderStatus(Long orderId, String status) {
        // 1. Database eken adala order eka hoya gannawa.
        OrderEntity orderEntity = orderDAO.findById(orderId).orElseThrow(() -> new RuntimeException("Order not found!"));
        orderEntity.setStatus(status); 
        OrderEntity savedOrder = orderDAO.save(orderEntity); 
        return mapper.toOrderDTO(savedOrder); 
    }

    @Override
    @Transactional(readOnly = true)
    public List<OrderDTO> getAllOrders() {
        RestaurantEntity myShop = restaurantService.getCurrentUserRestaurant();
        List<OrderEntity> orderEntities = orderDAO.findByRestaurantId(myShop.getId());
        
        List<OrderDTO> dtoList = new ArrayList<>();
        for (OrderEntity entity : orderEntities) {
            dtoList.add(mapper.toOrderDTO(entity));
        }
        return dtoList;
    }

    @Override
    @Transactional(readOnly = true)
    public Map<String, Object> getTodayShopStats() {
        RestaurantEntity myShop = restaurantService.getCurrentUserRestaurant();
        
        LocalDateTime startOfDay = LocalDateTime.now().with(LocalTime.MIN);
        LocalDateTime endOfDay = LocalDateTime.now().with(LocalTime.MAX);
        
        List<OrderEntity> todaysOrders = orderDAO.findByRestaurantIdAndOrderDateBetween(myShop.getId(), startOfDay, endOfDay);
        
        long count = todaysOrders.size();
        double revenue = 0.0;
        
        for (OrderEntity order : todaysOrders) {
            if (!"Cancelled".equals(order.getStatus())) {
                revenue += order.getTotalAmount();
            }
        }
        
        Map<String, Object> stats = new HashMap<>();
        stats.put("ordersToday", count);
        stats.put("revenueToday", revenue);
        
        return stats;
    }
}