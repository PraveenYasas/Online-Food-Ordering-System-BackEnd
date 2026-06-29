package lk.ijse.cmjd113.FoodOrderingSystem.service.impl;

import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import lk.ijse.cmjd113.FoodOrderingSystem.dao.CategoryDAO;
import lk.ijse.cmjd113.FoodOrderingSystem.dao.FoodItemDAO;
import lk.ijse.cmjd113.FoodOrderingSystem.dto.FoodItemDTO;
import lk.ijse.cmjd113.FoodOrderingSystem.entities.CategoryEntity;
import lk.ijse.cmjd113.FoodOrderingSystem.entities.FoodItemEntity;
import lk.ijse.cmjd113.FoodOrderingSystem.service.FoodItemService;
import lombok.RequiredArgsConstructor;

@Service
@Transactional
@RequiredArgsConstructor
public class FoodItemServiceImpl implements FoodItemService {

    private final FoodItemDAO foodItemDAO;
    private final CategoryDAO categoryDAO; // Category එක හොයන්න මේකත් අනිවාර්යයෙන් ඕනේ
    private final ModelMapper modelMapper;

    @Override
    public FoodItemDTO saveFoodItem(FoodItemDTO foodItemDTO) {
        
        // 1. Frontend එකෙන් එවපු Category ID එක Database එකේ ඇත්තටම තියෙනවද කියලා හොයනවා
        CategoryEntity category = categoryDAO.findById(foodItemDTO.getCategoryId())
                .orElseThrow(() -> new RuntimeException("Category not found!"));

        // 2. DTO එක Entity එකකට කන්වර්ට් කරනවා
        FoodItemEntity foodItemEntity = modelMapper.map(foodItemDTO, FoodItemEntity.class);
        
        // 3. අර හොයාගත්ත Category එක මේ කෑම එකට සෙට් කරනවා (මේක පට්ට වැදගත්!)
        foodItemEntity.setCategory(category);

        // 4. Database එකට සේව් කරනවා
        FoodItemEntity savedFoodItem = foodItemDAO.save(foodItemEntity);

        // 5. සේව් වෙච්ච එක ආයෙත් DTO එකකට හරවලා රිටර්න් කරනවා
        return modelMapper.map(savedFoodItem, FoodItemDTO.class);
    }

    @Override
    @Transactional(readOnly = true)
    public List<FoodItemDTO> getAllFoodItems() {
        return foodItemDAO.findAll().stream()
                .map(entity -> modelMapper.map(entity, FoodItemDTO.class))
                .collect(Collectors.toList());
    }

    @Override
    @Transactional(readOnly = true)
    public List<FoodItemDTO> getFoodItemsByCategory(Long categoryId) {
        // අර අපි DAO එකේ අලුතින් ගහපු මෙතඩ් එක පාවිච්චි කරලා අදාළ Category එකට අයිති කෑම විතරක් ගන්නවා
        return foodItemDAO.findByCategoryId(categoryId).stream()
                .map(entity -> modelMapper.map(entity, FoodItemDTO.class))
                .collect(Collectors.toList());
    }
}