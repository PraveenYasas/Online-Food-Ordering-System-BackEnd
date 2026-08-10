package lk.ijse.cmjd113.FoodOrderingSystem.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import lk.ijse.cmjd113.FoodOrderingSystem.entities.RestaurantFavoriteEntity;

public interface RestaurantFavoriteDAO extends JpaRepository<RestaurantFavoriteEntity, Long> {
    List<RestaurantFavoriteEntity> findByUserId(Long userId);
    void deleteByUserIdAndRestaurantId(Long userId, Long restaurantId);
    boolean existsByUserIdAndRestaurantId(Long userId, Long restaurantId);
}