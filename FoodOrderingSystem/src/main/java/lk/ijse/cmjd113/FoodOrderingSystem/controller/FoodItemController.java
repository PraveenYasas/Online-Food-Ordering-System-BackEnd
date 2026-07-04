package lk.ijse.cmjd113.FoodOrderingSystem.controller;

import java.util.List;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import lk.ijse.cmjd113.FoodOrderingSystem.dto.FoodItemDTO;
import lk.ijse.cmjd113.FoodOrderingSystem.service.FoodItemService;
import lombok.RequiredArgsConstructor;


@RestController
@RequestMapping("/food-items")   // me controller ekata enna ona prdhana URL eka.
@CrossOrigin
@RequiredArgsConstructor

public class FoodItemController {
    private final FoodItemService foodItemService;  // me controller ekata katha karanna eka methanata sambanda karagannawa.

    @PostMapping
    public FoodItemDTO saveFoodItem(@RequestBody FoodItemDTO foodItemDTO) {
        return foodItemService.saveFoodItem(foodItemDTO);
    }

    @GetMapping
    public List<FoodItemDTO> getAllFoodItems() {
        return foodItemService.getAllFoodItems();
    }

    @GetMapping("/category/{categoryId}")
    public List<FoodItemDTO> getFoodItemsByCategory(@PathVariable Long categoryId) {
        // me @PathVariable eken karanne URL eken ena ankya (ID eka) allaganna ekai.
        return foodItemService.getFoodItemsByCategory(categoryId);
    }
}
