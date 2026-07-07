package lk.ijse.cmjd113.FoodOrderingSystem.service.impl;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import jakarta.transaction.Transactional;
import lk.ijse.cmjd113.FoodOrderingSystem.dao.FoodItemDAO;
import lk.ijse.cmjd113.FoodOrderingSystem.dao.OrderDAO;
import lk.ijse.cmjd113.FoodOrderingSystem.dao.OrderDetailDAO;
import lk.ijse.cmjd113.FoodOrderingSystem.dto.OrderDTO;
import lk.ijse.cmjd113.FoodOrderingSystem.dto.OrderDetailDTO;
import lk.ijse.cmjd113.FoodOrderingSystem.entities.FoodItemEntity;
import lk.ijse.cmjd113.FoodOrderingSystem.entities.OrderDetailEntity;
import lk.ijse.cmjd113.FoodOrderingSystem.entities.OrderEntity;
import lk.ijse.cmjd113.FoodOrderingSystem.service.OrderService;
import lk.ijse.cmjd113.FoodOrderingSystem.util.Mapper;
import lombok.RequiredArgsConstructor;

@Service
@Transactional
@RequiredArgsConstructor
public class OrderServiceImpl implements OrderService {
    // me class eka athule thiyenne placeOrder() method eka implement karana eka.
    
    private final OrderDAO orderDAO; // meken database ekata order eka save karanna puluwan wenawa.
    private final OrderDetailDAO orderDetailDAO; // meken database ekata order details save karanna puluwan wenawa.
    private final FoodItemDAO foodItemDAO; // meken database ekata food item eka update karanna puluwan wenawa.
    private final Mapper mapper; // meken DTO eka Entity ekata harawanna puluwan wenawa.

    @Override
    public OrderDTO placeOrder(OrderDTO orderDTO) {
        // 1. Mulin OrderEntity eka hadanawa
        OrderEntity orderEntity = mapper.toOrderEntity(orderDTO);
        orderEntity.setOrderDate(LocalDateTime.now());

        // 2. Main Order eka save karanawa (ethakota apita ID eka labenawa)
        OrderEntity savedOrder = orderDAO.save(orderEntity);

        // 3. OrderDetails tika save karanawa (ethakota apita OrderDetailEntity list ekak labenawa)
        List<OrderDetailEntity> detailEntities = new ArrayList<>();
        
        for (OrderDetailDTO detailDTO : orderDTO.getOrderDetails()) {
            OrderDetailEntity detailEntity = new OrderDetailEntity();
            
            // Food Item eka Database eke hoyagannawa.
            FoodItemEntity foodItem = foodItemDAO.findById(detailDTO.getFoodItemId())
                    .orElseThrow(() -> new RuntimeException("Food Item not found!"));

            detailEntity.setOrder(savedOrder); // meka aithi order ekata link karanawa
            detailEntity.setFoodItem(foodItem);
            detailEntity.setQuantity(detailDTO.getQuantity());
            detailEntity.setPrice(foodItem.getPrice()); // ee welawe thibba price eka set karanawa
            
            detailEntities.add(orderDetailDAO.save(detailEntity));
        }

        // 4. save wechcha dewal tika aaii DTO ekata harawala yawanawa
        savedOrder.setOrderDetails(detailEntities);
        return mapper.toOrderDTO(savedOrder);
    }

}
