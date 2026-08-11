package lk.ijse.cmjd113.FoodOrderingSystem.controller;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import lk.ijse.cmjd113.FoodOrderingSystem.entities.FoodFavoriteEntity;
import lk.ijse.cmjd113.FoodOrderingSystem.entities.RestaurantFavoriteEntity;
import lk.ijse.cmjd113.FoodOrderingSystem.service.FavoriteService;
import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/favorites")
@CrossOrigin
@RequiredArgsConstructor
public class FavoriteController {

    private final FavoriteService favoriteService;

    @PostMapping("/restaurant/{userId}/{restaurantId}")
    public ResponseEntity<String> toggleRestaurantFavorite(@PathVariable Long userId, @PathVariable Long restaurantId) {
        favoriteService.toggleRestaurantFavorite(userId, restaurantId);
        return ResponseEntity.ok("Restaurant favorite status updated successfully");
    }

    @GetMapping("/restaurant/{userId}")
    public ResponseEntity<List<RestaurantFavoriteEntity>> getFavoriteRestaurants(@PathVariable Long userId) {
        List<RestaurantFavoriteEntity> favorites = favoriteService.getFavoriteRestaurants(userId);
        return ResponseEntity.ok(favorites);
    }

    @PostMapping("/food/{userId}/{foodItemId}")
    public ResponseEntity<String> toggleFoodFavorite(@PathVariable Long userId, @PathVariable Long foodItemId) {
        favoriteService.toggleFoodFavorite(userId, foodItemId);
        return ResponseEntity.ok("Food favorite status updated successfully");
    }

    @GetMapping("/food/{userId}")
    public ResponseEntity<List<FoodFavoriteEntity>> getFavoriteFoods(@PathVariable Long userId) {
        List<FoodFavoriteEntity> favorites = favoriteService.getFavoriteFoods(userId);
        return ResponseEntity.ok(favorites);
    }
}