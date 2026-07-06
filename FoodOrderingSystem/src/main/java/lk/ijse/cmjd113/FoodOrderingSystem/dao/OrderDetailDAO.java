package lk.ijse.cmjd113.FoodOrderingSystem.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import lk.ijse.cmjd113.FoodOrderingSystem.entities.OrderDetailEntity;

// mekenmkartanne pradhan bill eka athule thiyana kama jathi tika (Order details) Data bse ekata dana ekai.

public interface OrderDetailDAO extends JpaRepository<OrderDetailEntity, Long> {
    // Order ekak athule thiyana okkoma kama jathi tika hoyagana meka pawichchi karanna puluwan.
    // Ex: Order ekak athule thiyana okkoma kama jathi tika "Order Details" page ekata yawaddi meka patta watinawa.
    List<OrderDetailEntity> findByOrderId(Long orderId);
}
