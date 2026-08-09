package lk.ijse.cmjd113.FoodOrderingSystem.controller;

import java.util.List;
import java.util.Map;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import lk.ijse.cmjd113.FoodOrderingSystem.dto.OrderDTO;
import lk.ijse.cmjd113.FoodOrderingSystem.service.OrderService;
import lombok.RequiredArgsConstructor;


@RestController
@RequestMapping("/orders")
@CrossOrigin
@RequiredArgsConstructor

public class OrderController {

    private final OrderService orderService;

    @PostMapping
    public OrderDTO placeOrder(@RequestBody OrderDTO orderDTO) {
        return orderService.placeOrder(orderDTO);
    }

    @GetMapping("/user/{userId}")
    public List<OrderDTO> getOrdersByUserId(@PathVariable Long userId) {
        return orderService.getOrdersByUserId(userId);
    }

    @PostMapping("/{orderId}/status")
    public OrderDTO updateOrderStatus(@PathVariable Long orderId, @RequestParam String status) {
        return orderService.updateOrderStatus(orderId, status);
    }

    @GetMapping("/all")
    public List<OrderDTO> getAllOrders() {
        return orderService.getAllOrders();
    }

    @GetMapping("/stats/today")
    public Map<String, Object> getTodayShopStats() {
        return orderService.getTodayShopStats();
    }
    
}