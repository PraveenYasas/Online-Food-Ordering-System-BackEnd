package lk.ijse.cmjd113.FoodOrderingSystem.service;

import java.util.List;

import lk.ijse.cmjd113.FoodOrderingSystem.dto.CategoryDTO;

public interface CategoryService {
    
    CategoryDTO saveCategory(CategoryDTO categoryDTO);

    List<CategoryDTO> getAllCategories();
}
