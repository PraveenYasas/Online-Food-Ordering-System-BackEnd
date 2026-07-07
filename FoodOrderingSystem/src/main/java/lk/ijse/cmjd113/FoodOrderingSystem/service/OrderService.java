package lk.ijse.cmjd113.FoodOrderingSystem.service;

import lk.ijse.cmjd113.FoodOrderingSystem.dto.OrderDTO;

public interface OrderService {
    // Order ekak danakota DTO eka athule okkoma thiyanawa (User ID, Order Details, Total Amount, etc.)
    OrderDTO placeOrder(OrderDTO orderDTO);
}
