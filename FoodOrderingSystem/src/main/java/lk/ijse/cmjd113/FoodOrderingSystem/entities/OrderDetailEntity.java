package lk.ijse.cmjd113.FoodOrderingSystem.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "order_details")  // me table eke name eka "order_details" kiyana eka. (Database eke table name eka order_details kiyana eka.
@Data
@AllArgsConstructor
@NoArgsConstructor

public class OrderDetailEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "order_id", nullable = false)
    private OrderEntity order;

    // order karapu kama item eka mokakda kiyana eka.
    @ManyToOne
    @JoinColumn(name = "food_item_id", nullable = false)
    private FoodItemEntity foodItem;

    private int quantity;

    private double price;  // Price of the food item at the time of order
}
