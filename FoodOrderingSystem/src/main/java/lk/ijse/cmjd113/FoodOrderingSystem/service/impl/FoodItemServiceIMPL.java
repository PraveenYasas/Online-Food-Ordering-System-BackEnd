package lk.ijse.cmjd113.FoodOrderingSystem.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import lk.ijse.cmjd113.FoodOrderingSystem.dao.CategoryDAO;
import lk.ijse.cmjd113.FoodOrderingSystem.dao.FoodItemDAO;
import lk.ijse.cmjd113.FoodOrderingSystem.dto.FoodItemDTO;
import lk.ijse.cmjd113.FoodOrderingSystem.entities.CategoryEntity;
import lk.ijse.cmjd113.FoodOrderingSystem.entities.FoodItemEntity;
import lk.ijse.cmjd113.FoodOrderingSystem.service.FoodItemService;
import lk.ijse.cmjd113.FoodOrderingSystem.util.Mapper;
import lombok.RequiredArgsConstructor;

@Service
@Transactional
@RequiredArgsConstructor
public class FoodItemServiceIMPL implements FoodItemService {

    private final FoodItemDAO foodItemDAO;
    private final CategoryDAO categoryDAO; 
    private final Mapper mapper; 

    @Override
    public FoodItemDTO saveFoodItem(FoodItemDTO foodItemDTO) {
        
        // 1. Frontend eken ewapu Category ID eka Database eke thiyanawada balanawa.
        Optional<CategoryEntity> categoryOptional = categoryDAO.findById(foodItemDTO.getCategoryId());
        
        // ee ID eata adala Category ekak nath nam error ekak denawa.
        if (!categoryOptional.isPresent()) {
            throw new RuntimeException("Category not found!");
        }

        // Category eka thiyanawa nam eka Optional eka thulen eliyata annawa
        CategoryEntity category = categoryOptional.get();

        // DTO eka Entity ekakata convert karanawa
        FoodItemEntity foodItemEntity = mapper.toFoodItemEntity(foodItemDTO);   // ape mapper eken entity ekata harawanawa.
        
        // Ara hoyagaththa Category eka me kaama ekata set karanawa.
        foodItemEntity.setCategory(category);

        // Database ekata save karanawa.
        FoodItemEntity savedFoodItem = foodItemDAO.save(foodItemEntity);

        // Save wechcha eka aayeth DTO ekakata harawala return karanawa.
        return mapper.toFoodItemDTO(savedFoodItem); 
    }

    @Override
    @Transactional(readOnly = true)
    public List<FoodItemDTO> getAllFoodItems() {
        
        // Okkoma Food Items tika gannawa
        List<FoodItemEntity> foodItemEntities = foodItemDAO.findAll();
        
        // ara mapper class eka hadapu nisa dan methana for loop eka danna one naha.

        // // His DTO list ekak hadanawa
        // List<FoodItemDTO> foodItemDTOList = new ArrayList<>();

        // // For Loop eken ekin eka convertt karala list ekakata add karanawa.
        // for (FoodItemEntity entity : foodItemEntities) {
        //     FoodItemDTO dto = modelMapper.map(entity, FoodItemDTO.class);
        //     foodItemDTOList.add(dto);
        // }

        return mapper.toFoodItemDTOList(foodItemEntities);
    }

    @Override
    @Transactional(readOnly = true)
    public List<FoodItemDTO> getFoodItemsByCategory(Long categoryId) {
        
        // adala Category ekata aithi kama tika witharak gannawa
        List<FoodItemEntity> foodItemEntities = foodItemDAO.findByCategoryId(categoryId);
        
        // methanath ara kalin wagema aaith for loop liaya liya inna one naha.

        return mapper.toFoodItemDTOList(foodItemEntities);
    }

    @Override
    public List<FoodItemDTO> getFoodItemsByRestaurant(Long restaurantId) {
        List<FoodItemEntity> entities = foodItemDAO.findByRestaurantId(restaurantId);
        return mapper.toFoodItemDTOList(entities);
    }
}