package lk.ijse.cmjd113.FoodOrderingSystem.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor

public class OrderDetailDTO {
    private Long id;

    private Long foodItemId;  // ID of the food item being ordered

    private String foodItemName;  // Name of the food item being ordered

    private int quantity;  // Quantity of the food item being ordered

    private double price;  // Price of the food item at the time of order
}
