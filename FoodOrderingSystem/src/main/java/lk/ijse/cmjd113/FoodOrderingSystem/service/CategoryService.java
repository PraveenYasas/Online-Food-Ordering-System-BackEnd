package lk.ijse.cmjd113.FoodOrderingSystem.service;

import java.util.List;

import lk.ijse.cmjd113.FoodOrderingSystem.dto.CategoryDTO;

public interface CategoryService {
    // Aluth category ekak save karanna.
    CategoryDTO saveCategory(CategoryDTO categoryDTO);

    // Thiyena category okkoma list ekak widihata ganna.
    List<CategoryDTO> getAllCategories();
}
