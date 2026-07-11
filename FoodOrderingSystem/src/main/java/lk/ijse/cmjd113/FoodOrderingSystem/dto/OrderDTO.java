package lk.ijse.cmjd113.FoodOrderingSystem.dto;

import java.time.LocalDateTime;
import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor

public class OrderDTO {
    private Long id;

    private Long userId;  // ID of the user who placed the order

    private LocalDateTime orderDate;  // Date and time when the order was placed

    private double totalAmount;  // Total amount for the order

    private String status;  // Status of the order (e.g., "Pending", "Completed", "Cancelled")

    // Bill ek athule thiyana kama jathi okkoma enne me List eka athule.
    private List<OrderDetailDTO> orderDetails;  // List of order details associated with the order

    private String restaurantName;    // UI eke pennana

    private String deliveryAddress;   // UI eke pennana

    private String driverName;        // Driver innawanam

    private String driverPhone;       // Driver ge No eka
    
    private String arrivalTime;       // "15 min" wage pennana eka. (UI eke pennana)
}
