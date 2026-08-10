package lk.ijse.cmjd113.FoodOrderingSystem.dao;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import lk.ijse.cmjd113.FoodOrderingSystem.entities.OrderEntity;

// meken thami pradhana bill eka (Order eka) Data bse ekata save karanne.

public interface OrderDAO extends JpaRepository<OrderEntity, Long> {
    // User kenek daapu order4s okkoma hoyagana meka pawichchi karanna puluwan.
    // Ex: User ge "My Orders" page ekata data yawaddi meka patta watinawa.
    List<OrderEntity> findByUserId(Long userId);

    List<OrderEntity> findByOrderDateBetween(LocalDateTime start, LocalDateTime end);

    List<OrderEntity> findByRestaurantId(Long restaurantId);
    
    List<OrderEntity> findByRestaurantIdAndOrderDateBetween(Long restaurantId, LocalDateTime start, LocalDateTime end);
}
