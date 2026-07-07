package lk.ijse.cmjd113.FoodOrderingSystem.util;

import java.util.ArrayList;
import java.util.List;

import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

import lk.ijse.cmjd113.FoodOrderingSystem.dto.CategoryDTO;
import lk.ijse.cmjd113.FoodOrderingSystem.dto.FoodItemDTO;
import lk.ijse.cmjd113.FoodOrderingSystem.dto.OrderDTO;
import lk.ijse.cmjd113.FoodOrderingSystem.dto.OrderDetailDTO;
import lk.ijse.cmjd113.FoodOrderingSystem.entities.CategoryEntity;
import lk.ijse.cmjd113.FoodOrderingSystem.entities.FoodItemEntity;
import lk.ijse.cmjd113.FoodOrderingSystem.entities.OrderDetailEntity;
import lk.ijse.cmjd113.FoodOrderingSystem.entities.OrderEntity;
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

@Component              // meken springboot walata kiyanawa meken object ekak hadala oyage mathake thiyaganna kiyala (Aplication context ekata register karala thiyaganna kiyala)
                        // mata ona unahama mama illagannam kiyala.
                        // ethakota api hama thanama new Mapper() kiyala gahanna one naha.

@RequiredArgsConstructor// meken ara palleha thiyana private final ModelMapper modelMapper;
                        // ekata awshya Constructor eka ibema hadala denawa.

public class Mapper {
    // meka thama aththatama data convert karana matchine eka. (ModelMapper library eka)
    // meka api me class eka athulata inject karagannawa.
    private final ModelMapper modelMapper;

    // category mappings
    
    // Database eken ena category ekak (Entity), Frontend ekata yawanna puluwan widihata (DTO) eka convert karala dena eka thama karanne.
    // modelMapper.map() ekata api adala object ekai, harawenna ona class ekai dunahama eyaa eka lassanata harawala denawa. 
    public CategoryDTO toCategoryDTO(CategoryEntity categoryEntity) {
        return modelMapper.map(categoryEntity, CategoryDTO.class);
    }
    
    // meka arake anith paththa. Frontend eken ena data (DTO) database ekata save karaganna puluwan widihata (Entity) harawana ekai meken karanne.
    public CategoryEntity toCategoryEntity(CategoryDTO categoryDTO) {
        return modelMapper.map(categoryDTO, CategoryEntity.class);
    }

    // meka thamai list convert karana kalla. Database eken categories godak awahama meken karanne aluth his DTO list ekak hadanawa. (new ArrayList<>()).
    // ita pase for loop ekak dala ara apu llist eke thiyana ewwa ekin eka aragena ara uda hadapu toCategoryDTO() method ekata yawala convert karala aluth list ekakata ekathu karanawa.
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

    // ordering mappings

    // mekedi api order DTO eka harawana gamanma, eka athule thiyana OrderDetailEntity list ekath convert karanawa.
    // enisa front end ekata mulu bilama eka paara watenawa.
    public OrderDTO toOrderDTO(OrderEntity orderEntity) {
        OrderDTO dto = modelMapper.map(orderEntity, OrderDTO.class);

        // User ge ID eka witharak set karanawa. (Me wage wenama mapping ekak thiyenawanam meka Service eke liwwoth code eka katha wenawa.)
        if (orderEntity.getUser() != null) {
            dto.setUserId(orderEntity.getUser().getId());
        }

        // kama list eka harawanawa.
        if (orderEntity.getOrderDetails() != null) {
            dto.setOrderDetails(toOrderDetailDTOList(orderEntity.getOrderDetails()));
        }

        return dto;
    }

    public OrderEntity toOrderEntity(OrderDTO orderDTO) {
        return modelMapper.map(orderDTO, OrderEntity.class);
    }

    // Order Detail mapping

    // methanadi api Data base eke thiyana FoodItemEntity eka athulata gihin kama eke nama aragena DTo ekata danawa.
    // ethakota frontend ekedi customer ta "Oyaa aran thiyenne Cheese Burger " ekak kiyala pennanna puluwan wenawa.
    public OrderDetailDTO toOrderDetailDTO(OrderDetailEntity detailEntity) {
        OrderDetailDTO dto = modelMapper.map(detailEntity, OrderDetailDTO.class);
        
        // kama eke nama saha ID eka set karanawa. (Me wage wenama mapping ekak thiyenawanam meka Service eke liwwoth code eka katha wenawa.)
        if (detailEntity.getFoodItem() != null) {
            dto.setFoodItemId(detailEntity.getFoodItem().getId());
            dto.setFoodItemName(detailEntity.getFoodItem().getName());
        }
        
        return dto;
    }

    public List<OrderDetailDTO> toOrderDetailDTOList(List<OrderDetailEntity> detailEntityList) {
        List<OrderDetailDTO> dtoList = new ArrayList<>();
        for (OrderDetailEntity entity : detailEntityList) {
            dtoList.add(toOrderDetailDTO(entity));
        }
        return dtoList;
    }
}
