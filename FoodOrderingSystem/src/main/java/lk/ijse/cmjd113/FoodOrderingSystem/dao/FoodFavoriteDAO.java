package lk.ijse.cmjd113.FoodOrderingSystem.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import lk.ijse.cmjd113.FoodOrderingSystem.entities.FoodFavoriteEntity;

public interface FoodFavoriteDAO extends JpaRepository<FoodFavoriteEntity, Long> {
    List<FoodFavoriteEntity> findByUserId(Long userId);
    void deleteByUserIdAndFoodItemId(Long userId, Long foodItemId);
    boolean existsByUserIdAndFoodItemId(Long userId, Long foodItemId);
}