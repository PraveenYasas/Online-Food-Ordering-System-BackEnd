package lk.ijse.cmjd113.FoodOrderingSystem.service.impl;

import java.util.List;

import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import jakarta.transaction.Transactional;
import lk.ijse.cmjd113.FoodOrderingSystem.dao.CategoryDAO;
import lk.ijse.cmjd113.FoodOrderingSystem.dao.FoodItemDAO;
import lk.ijse.cmjd113.FoodOrderingSystem.dto.FoodItemDTO;
import lk.ijse.cmjd113.FoodOrderingSystem.service.FoodItemService;
import lombok.RequiredArgsConstructor;

@Service
@Transactional
@RequiredArgsConstructor

public class FoodItemServiceImpl implements FoodItemService {
    // Implement the methods defined in the FoodItemService interface here

    private final FoodItemDAO foodItemDAO;
    private final CategoryDAO categoryDAO;
    private final ModelMapper modelMapper;
    
    @Override
    public FoodItemDTO saveFoodItem(FoodItemDTO foodItemDTO) {
        // Implement the logic to save a food item
        // You can use the foodItemDAO to save the food item entity to the database
        return null; // Replace with actual implementation
    }

    @Override
    public List<FoodItemDTO> getAllFoodItems() {
        // Implement the logic to retrieve all food items
        // You can use the foodItemDAO to fetch the food item entities from the database
        return null; // Replace with actual implementation
    }

    @Override
    public List<FoodItemDTO> getFoodItemsByCategory(Long categoryId) {
        // Implement the logic to retrieve food items by category
        // You can use the foodItemDAO to fetch the food item entities based on the category
        return null; // Replace with actual implementation
    }
}
