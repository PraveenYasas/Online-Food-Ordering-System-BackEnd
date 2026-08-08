package lk.ijse.cmjd113.FoodOrderingSystem.service;

import java.util.List;

import lk.ijse.cmjd113.FoodOrderingSystem.dto.OrderDTO;

public interface OrderService {
    // Order ekak danakota DTO eka athule okkoma thiyanawa (User ID, Order Details, Total Amount, etc.)
    OrderDTO placeOrder(OrderDTO orderDTO);
    // Status eka update karaganna method ekak damma.
    OrderDTO updateOrderStatus(Long orderId, String status);

    List<OrderDTO> getOrdersByUserId(Long userId);

    List<OrderDTO> getAllOrders();
}
