package lk.ijse.cmjd113.FoodOrderingSystem.dao;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import lk.ijse.cmjd113.FoodOrderingSystem.entities.RestaurantEntity;

public interface RestaurantDAO extends JpaRepository<RestaurantEntity, Long> {
    
    // User Entity eke thiyana email eka hoyagannawa
    Optional<RestaurantEntity> findByOwnerEmail(String email);
    
}