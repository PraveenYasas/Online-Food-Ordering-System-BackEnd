package lk.ijse.cmjd113.FoodOrderingSystem.service.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

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
    private final CategoryDAO categoryDAO; 
    private final ModelMapper modelMapper;

    @Override
    public FoodItemDTO saveFoodItem(FoodItemDTO foodItemDTO) {
        
        // 1. Frontend එකෙන් එවපු Category ID එක Database එකේ තියෙනවද බලනවා
        Optional<CategoryEntity> categoryOptional = categoryDAO.findById(foodItemDTO.getCategoryId());
        
        // ඒ ID එකට අදාළ Category එකක් නැත්නම් එරර් එකක් දෙනවා
        if (!categoryOptional.isPresent()) {
            throw new RuntimeException("Category not found!");
        }

        // Category එක තියෙනවා නම් ඒක Optional එක ඇතුළෙන් එළියට ගන්නවා
        CategoryEntity category = categoryOptional.get();

        // 2. DTO එක Entity එකකට කන්වර්ට් කරනවා
        FoodItemEntity foodItemEntity = modelMapper.map(foodItemDTO, FoodItemEntity.class);
        
        // 3. අර හොයාගත්ත Category එක මේ කෑම එකට සෙට් කරනවා
        foodItemEntity.setCategory(category);

        // 4. Database එකට සේව් කරනවා
        FoodItemEntity savedFoodItem = foodItemDAO.save(foodItemEntity);

        // 5. සේව් වෙච්ච එක ආයෙත් DTO එකකට හරවලා රිටර්න් කරනවා
        return modelMapper.map(savedFoodItem, FoodItemDTO.class);
    }

    @Override
    @Transactional(readOnly = true)
    public List<FoodItemDTO> getAllFoodItems() {
        
        // 1. ඔක්කොම Food Items ටික ගන්නවා
        List<FoodItemEntity> foodItemEntities = foodItemDAO.findAll();
        
        // 2. හිස් DTO ලිස්ට් එකක් හදනවා
        List<FoodItemDTO> foodItemDTOList = new ArrayList<>();

        // 3. For Loop එකෙන් එකින් එක කන්වර්ට් කරලා ලිස්ට් එකට දානවා
        for (FoodItemEntity entity : foodItemEntities) {
            FoodItemDTO dto = modelMapper.map(entity, FoodItemDTO.class);
            foodItemDTOList.add(dto);
        }

        return foodItemDTOList;
    }

    @Override
    @Transactional(readOnly = true)
    public List<FoodItemDTO> getFoodItemsByCategory(Long categoryId) {
        
        // 1. අදාළ Category එකට අයිති කෑම ටික විතරක් ගන්නවා
        List<FoodItemEntity> foodItemEntities = foodItemDAO.findByCategoryId(categoryId);
        
        // 2. හිස් DTO ලිස්ට් එකක් හදනවා
        List<FoodItemDTO> foodItemDTOList = new ArrayList<>();

        // 3. For Loop එකෙන් එකින් එක කන්වර්ට් කරලා ලිස්ට් එකට දානවා
        for (FoodItemEntity entity : foodItemEntities) {
            FoodItemDTO dto = modelMapper.map(entity, FoodItemDTO.class);
            foodItemDTOList.add(dto);
        }

        return foodItemDTOList;
    }
}