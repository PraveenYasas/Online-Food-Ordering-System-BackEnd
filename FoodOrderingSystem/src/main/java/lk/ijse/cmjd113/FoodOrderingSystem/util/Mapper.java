package lk.ijse.cmjd113.FoodOrderingSystem.util;

import java.util.ArrayList;
import java.util.List;

import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

import lk.ijse.cmjd113.FoodOrderingSystem.dto.CategoryDTO;
import lk.ijse.cmjd113.FoodOrderingSystem.dto.FoodItemDTO;
import lk.ijse.cmjd113.FoodOrderingSystem.entities.CategoryEntity;
import lk.ijse.cmjd113.FoodOrderingSystem.entities.FoodItemEntity;
import lombok.RequiredArgsConstructor;

// Me class eka thiyenne thikak loku "Translator" kenek widihata.
// Api danata hadapu FoodOrderingSystem eke api DTO eka Entity ekata harawana wada (mapping) kare kelinma ServiceImpl eka athulene (modelMapper.map(...) kiyala gahala).
// Habai me Mapper.java eke karala thiyenne, e map karana wada okkoma eka thanakata (meka athulata) genath dapu eka.
// Me wage wenama Mapper class ekak hadana eka loku Enterprise Projects wala aniwaryayenma karana hoda puruddak (Best Practice ekak).

// Separation of Concerns (Kariyan wen karana eka): 
//          Service layer eke wada wenna one Business logic eka witharai (Uda: Me kema jathiya kalin thiyenawada kiyala check karana eka).
//          DTO eka Entity ekata harawana eka Service eke wadayak newei.
//          Eka wenama class ekakata dunnama Service eke code eka patta clean wenawa.

// Complex Mapping (Sankeerna wada lesi weema):
//          anith tables wala thiyena data wala athulata gihin DTO ekata data set karala thiyenawa.
//          me wage complex mapping ekak thiyenawanam, me Mapper class eka athule thiyena methods walin karanna puluwan.
//          E wage amaru custom mapping loku projects wala enawa.
//          Ewa Service eka athule liwwoth code eka katha wenawa.

// Reusability (Nawatha pawichchiya):
//          Dan ara List ekak map karaddi TypeToken kiyana jathiya danna onane.
//          Me class eke eka eka parak lassanata liyala thiyenawa toUserDtoList wage methods athule.
//          Eka nisa wena ona tharam Services waladi thawa dura hitha hitha inne nathuwa kelinma mapper.toUserDtoList(list) kiyala call karanna puluwan.

@Component
@RequiredArgsConstructor

public class Mapper {
    private final ModelMapper modelMapper;

    // category mappings
    
    public CategoryDTO toCategoryDTO(CategoryEntity categoryEntity) {
        return modelMapper.map(categoryEntity, CategoryDTO.class);
    }
    
    public CategoryEntity toCategoryEntity(CategoryDTO categoryDTO) {
        return modelMapper.map(categoryDTO, CategoryEntity.class);
    }

    public List<CategoryDTO> toCategoryDTOList(List<CategoryEntity> categoryEntityList) {
        List<CategoryDTO> categoryDTOList = new ArrayList<>();
        for (CategoryEntity entity : categoryEntityList) {
            categoryDTOList.add(toCategoryDTO(entity));
        }
        return categoryDTOList;
    }

    // Food Item mapping

    public FoodItemDTO toFoodItemDTO(FoodItemEntity foodItemEntity) {
        FoodItemDTO dto = modelMapper.map(foodItemEntity, FoodItemDTO.class);

        if (foodItemEntity.getCategory() != null) {
            dto.setCategoryId(foodItemEntity.getCategory().getId());
        }
        return dto;
    }

    public FoodItemEntity toFoodItemEntity(FoodItemDTO foodItemDTO) {
        return modelMapper.map(foodItemDTO, FoodItemEntity.class);
    } 

    public List<FoodItemDTO> toFoodItemDTOList (List<FoodItemEntity> foodItemEntityList) {
        List<FoodItemDTO> dtoList = new ArrayList<>();
        for (FoodItemEntity entity : foodItemEntityList) {
            dtoList.add(toFoodItemDTO(entity));
        }
        return dtoList;
    }
}
