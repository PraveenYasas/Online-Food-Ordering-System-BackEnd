package lk.ijse.cmjd113.FoodOrderingSystem.service.impl;

import java.util.List;

import org.springframework.stereotype.Service;

import jakarta.transaction.Transactional;
import lk.ijse.cmjd113.FoodOrderingSystem.dao.FoodFavoriteDAO;
import lk.ijse.cmjd113.FoodOrderingSystem.dao.FoodItemDAO;
import lk.ijse.cmjd113.FoodOrderingSystem.dao.RestaurantDAO;
import lk.ijse.cmjd113.FoodOrderingSystem.dao.RestaurantFavoriteDAO;
import lk.ijse.cmjd113.FoodOrderingSystem.entities.FoodFavoriteEntity;
import lk.ijse.cmjd113.FoodOrderingSystem.entities.FoodItemEntity;
import lk.ijse.cmjd113.FoodOrderingSystem.entities.RestaurantEntity;
import lk.ijse.cmjd113.FoodOrderingSystem.entities.RestaurantFavoriteEntity;
import lk.ijse.cmjd113.FoodOrderingSystem.service.FavoriteService;
import lombok.RequiredArgsConstructor;

@Service
@Transactional
@RequiredArgsConstructor
public class FavoriteServiceImpl implements FavoriteService {

    private final RestaurantFavoriteDAO restaurantFavoriteDAO;
    private final FoodFavoriteDAO foodFavoriteDAO;
    private final RestaurantDAO restaurantDAO;
    private final FoodItemDAO foodItemDAO;

    @Override
    public void toggleRestaurantFavorite(Long userId, Long restaurantId) {
        if (restaurantFavoriteDAO.existsByUserIdAndRestaurantId(userId, restaurantId)) {
            restaurantFavoriteDAO.deleteByUserIdAndRestaurantId(userId, restaurantId);
        } else {
            RestaurantEntity restaurant = restaurantDAO.findById(restaurantId)
                    .orElseThrow(() -> new RuntimeException("Restaurant not found"));
            RestaurantFavoriteEntity favorite = new RestaurantFavoriteEntity();
            favorite.setUserId(userId);
            favorite.setRestaurant(restaurant);
            restaurantFavoriteDAO.save(favorite);
        }
    }

    @Override
    public List<RestaurantFavoriteEntity> getFavoriteRestaurants(Long userId) {
        return restaurantFavoriteDAO.findByUserId(userId);
    }

    @Override
    public void toggleFoodFavorite(Long userId, Long foodItemId) {
        if (foodFavoriteDAO.existsByUserIdAndFoodItemId(userId, foodItemId)) {
            foodFavoriteDAO.deleteByUserIdAndFoodItemId(userId, foodItemId);
        } else {
            FoodItemEntity foodItem = foodItemDAO.findById(foodItemId)
                    .orElseThrow(() -> new RuntimeException("Food item not found"));
            FoodFavoriteEntity favorite = new FoodFavoriteEntity();
            favorite.setUserId(userId);
            favorite.setFoodItem(foodItem);
            foodFavoriteDAO.save(favorite);
        }
    }

    @Override
    public List<FoodFavoriteEntity> getFavoriteFoods(Long userId) {
        return foodFavoriteDAO.findByUserId(userId);
    }
}