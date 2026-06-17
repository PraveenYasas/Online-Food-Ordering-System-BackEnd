package lk.ijse.cmjd113.FoodOrderingSystem.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import jakarta.transaction.Transactional;
import lk.ijse.cmjd113.FoodOrderingSystem.dao.CategoryDAO;
import lk.ijse.cmjd113.FoodOrderingSystem.dto.CategoryDTO;
import lk.ijse.cmjd113.FoodOrderingSystem.entities.CategoryEntity;
import lk.ijse.cmjd113.FoodOrderingSystem.service.CategoryService;
import lombok.RequiredArgsConstructor;

@Service
@Transactional
@RequiredArgsConstructor

public class CategoryServiceIMPL implements CategoryService {

    private final CategoryDAO categoryDAO;

    private final ModelMapper modelMapper;

    @Override
    public CategoryDTO saveCategory(CategoryDTO categoryDTO) {
        if (categoryDAO.existsByName(categoryDTO.getName())) {
            throw new RuntimeException("Category Allready Exists");
        }

        CategoryEntity categoryEntity = modelMapper.map(categoryDTO, CategoryEntity.class);

        CategoryEntity savedCategory = categoryDAO.save(categoryEntity);

        return modelMapper.map(savedCategory, CategoryDTO.class);
    }

    @Override
    public List<CategoryDTO> getAllCategories() {
        List<CategoryEntity> categoryEntities = categoryDAO.findAll();

        List<CategoryDTO> categoryDTOList = new ArrayList<>();

        for (CategoryEntity categoryEntity : categoryEntities) {
            CategoryDTO categoryDTO = modelMapper.map(categoryEntity, CategoryDTO.class);
            categoryDTOList.add(categoryDTO);
        }

        return categoryDTOList;
    }
}