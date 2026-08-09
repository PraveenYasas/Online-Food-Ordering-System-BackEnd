package lk.ijse.cmjd113.FoodOrderingSystem.entities;

import java.time.LocalDateTime;
import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "orders")  // me table eke name eka "orders" kiyana eka. (Database eke table name eka orders kiyana eka.
@Data
@AllArgsConstructor
@NoArgsConstructor

public class OrderEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "user_id", nullable = false)
    private UserEntity user;

    private LocalDateTime orderDate;

    private double totalAmount;

    private String status;  // Order status (e.g., "Pending", "Completed", "Cancelled")

    private String restaurantName;    // UI eke pennana

    private String deliveryAddress;   // UI eke pennana

    private String driverName;        // Driver innawanam

    private String driverPhone;       // Driver ge No eka

    private String arrivalTime;       // "15 min" wage pennana eka. (UI eke pennana)

    @OneToMany(mappedBy = "order", cascade = CascadeType.ALL)
    private List<OrderDetailEntity> orderDetails;

    // meken karanne customer kenek order ekak dammahama eeka kelinma adala kadeta yawanna puluwan wenna kadea link karanawa.
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "restaurant_id", nullable = false)
    private RestaurantEntity restaurant;
}
