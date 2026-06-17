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
        List<CategoryEntity> categoryEntities = categoryDAO.findAll();  // meken karanne database eke thiyena categories serama aragena categoryEntities kiyana llist ekata daganna ekai.
                                                                        // mewa thiyenne entity widihata.

        List<CategoryDTO> categoryDTOList = new ArrayList<>();  // Aluth DTO list ekak hadanawa (Convert karana ewwa ekathu karaganna).

        // For loop ekak dala ara apu entity List eke thiyana ewwa ekin eka gannawa.
        for (CategoryEntity categoryEntity : categoryEntities) {
            // Ekin eka aragena ModelMapper eken DTO ekata convert karanawa.
            CategoryDTO categoryDTO = modelMapper.map(categoryEntity, CategoryDTO.class);

            // Convert karapu DTO eka ara aluth list ekata danawa.
            categoryDTOList.add(categoryDTO);
        }

        // anthimata ara okoma ekathukaragaththa DTO list eka return karanawa.
        return categoryDTOList;
    }
}