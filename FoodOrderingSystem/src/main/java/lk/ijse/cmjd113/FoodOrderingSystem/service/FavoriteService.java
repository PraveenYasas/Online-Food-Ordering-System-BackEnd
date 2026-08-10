package lk.ijse.cmjd113.FoodOrderingSystem.service;

import java.util.List;

import lk.ijse.cmjd113.FoodOrderingSystem.entities.FoodFavoriteEntity;
import lk.ijse.cmjd113.FoodOrderingSystem.entities.RestaurantFavoriteEntity;

public interface FavoriteService {
    // For Restaurants
    void toggleRestaurantFavorite(Long userId, Long restaurantId);
    List<RestaurantFavoriteEntity> getFavoriteRestaurants(Long userId);

    // For Food Items
    void toggleFoodFavorite(Long userId, Long foodItemId);
    List<FoodFavoriteEntity> getFavoriteFoods(Long userId);
}