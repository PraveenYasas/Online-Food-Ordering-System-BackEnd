package lk.ijse.cmjd113.FoodOrderingSystem.service;

import java.util.List;

import lk.ijse.cmjd113.FoodOrderingSystem.dto.FoodItemDTO;

public interface FoodItemService {
    // Aluth kamak save karaganna
    FoodItemDTO saveFoodItem(FoodItemDTO foodItemDTO);

    // Thiyena okkoma kama balanna
    List<FoodItemDTO> getAllFoodItems();

    // "Burgers" wage eka categorry ekakata adala kama filter karala ganna.
    List<FoodItemDTO> getFoodItemsByCategory(Long categoryId);
}
