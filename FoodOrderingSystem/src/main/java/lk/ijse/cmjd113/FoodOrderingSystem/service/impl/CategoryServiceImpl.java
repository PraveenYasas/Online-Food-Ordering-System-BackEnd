package lk.ijse.cmjd113.FoodOrderingSystem.service.impl;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import lk.ijse.cmjd113.FoodOrderingSystem.dao.CategoryDAO;
import lk.ijse.cmjd113.FoodOrderingSystem.dto.CategoryDTO;
import lk.ijse.cmjd113.FoodOrderingSystem.entities.CategoryEntity;
import lk.ijse.cmjd113.FoodOrderingSystem.service.CategoryService;
import lk.ijse.cmjd113.FoodOrderingSystem.util.Mapper;
import lombok.RequiredArgsConstructor;

@Service

@Transactional              // @Transactional meka service layer ekata danna ona aniwa kallak.
                            // meken database ekath ekka karana ganudenu araksha karanawa.
                            // @Transactional meka dammahama wenne bageta fill wichcha data tika aaii sampurnayenma apassata harawanawa.
                            // Ethakota data base eke bageta save wechcha data ithuru wenne na.
                            // saralawa kiwwoth database ganudenu araksha karaawa.

@RequiredArgsConstructor    // @RequredArgsConstructor - meka damma gaman ara private final kiyala thiyana hama Variable ekakatama Lombok eken ibema constructor eka hadanawa.
                            // categoryDAO saha modelMapper kiyana deka athata ganna athin constructor ekak liyala thiyanawa ekek @RequredArgsConstructor dammahama ehema karanna one naha 
                            // saralawa kiwwoth Ibema constructor eka hadenawa.

public class CategoryServiceIMPL implements CategoryService {

    // private final controller.CategoryController categoryController;

    private final CategoryDAO categoryDAO;

    private final Mapper mapper;  // meken karanne ModelMapper eken karana wada thama me class eke thiyenne. (DTO eka Entity ekata harawana wada)

    // CategoryServiceIMPL(controller.CategoryController categoryController) {
    //     this.categoryController = categoryController;
    // }

    // methanata dan constructor ekak liyala thiyenne na, 
    // @RequredArgsConstructor dammahama ehema karanna one naha. 
    // Lombok eken ibema constructor eka hadenawa.

    @Override
    public CategoryDTO saveCategory(CategoryDTO categoryDTO) {  // Controller eken (Ekiyanne post man eken ena data tika allaganna kenagen) 
                                                                // CategoryDTO kiyana parsalaya me method eka athulata enawa.
                                                                // ewagema wade iwara unahama meken aaii return karanawa kiyalath.

        if (categoryDAO.existsByName(categoryDTO.getName())) {  // danatamath e namin category ekak thiyanawada kiyala check karanawa.
            throw new RuntimeException("Category Allready Exists");
        }

        // DTO ekak Entity ekakata haraweema.
        // Ape Database eka DTO kiyana eka aduranne naha.
        // Eyaata therenne Entity witharai.
        // Enisa api ModelMapper pawichchi karala ara apu categoryDTO eke thiyena data tika aluth CategoryEntity ekakata copy karanawa.
        // CategoryEntity categoryEntity = modelMapper.map(categoryDTO, CategoryEntity.class);

        CategoryEntity categoryEntity = mapper.toCategoryEntity(categoryDTO);   // meken karanne ModelMapper eken karana wada thama me class eke thiyenne. 
                                                                                // (DTO eka Entity ekata harawana wada)

        // Database ekata save kireema
        // Dan ara haduna Entity eka api ape categoryDAO ekata deela kiyanawa meka databse eke save karanna kiyala.
        // Me welawedi thamai Hibernate eken ibema SQL (INSERT INTO categories...) gahala database ekata data yawanne.
        // Save unain passe Database eken aluth ID ekak (primary key ekak) ekata denawa.
        // Id ekath ekkama save wechcha aluth object eka aragena savedCategory kiyana ekata dagannawa.
        CategoryEntity savedCategory = categoryDAO.save(categoryEntity);

        // Apahu DTO ekata harawa yaweema
        // Industry standed ekata anuwa api kawadawath data base eke thiyana entity ekak ee widihatama frontEnd ekata yawanna one naha.
        // E nisa aaith sarayak ModelMapper eka pawichci karala ara savewechaha savedCategory(Entity eka) CategoryDTO ekata convert karagena eka rwturn karanawa.
        // return modelMapper.map(savedCategory, CategoryDTO.class);

        return mapper.toCategoryDTO(savedCategory);     // meken karanne ModelMapper eken karana wada thama me class eke thiyenne. 
                                                        // (DTO eka Entity ekata harawana wada)
    }

    @Override
    @Transactional(readOnly = true)
    public List<CategoryDTO> getAllCategories() {
        List<CategoryEntity> categoryEntities = categoryDAO.findAll();  // meken karanne database eke thiyena categories serama aragena categoryEntities kiyana llist ekata daganna ekai.
                                                                        // mewa thiyenne entity widihata.

        // List<CategoryDTO> categoryDTOList = new ArrayList<>();  // Aluth DTO list ekak hadanawa (Convert karana ewwa ekathu karaganna).

        // // For loop ekak dala ara apu entity List eke thiyana ewwa ekin eka gannawa.
        // for (CategoryEntity categoryEntity : categoryEntities) {

        //     // Ekin eka aragena ModelMapper eken DTO ekata convert karanawa.
        //     CategoryDTO categoryDTO = modelMapper.map(categoryEntity, CategoryDTO.class);

        //     // Convert karapu DTO eka ara aluth list ekata danawa.
        //     categoryDTOList.add(categoryDTO);
        // }

        // oya uda kallath ain une api mapper class eka pawichchi karapu nisa categoryController ekata call karala ara apu list eka convert karala aluth list ekakata daganna puluwan.
        return mapper.toCategoryDTOList(categoryEntities);  // meken karanne ModelMapper eken karana wada thama me class eke thiyenne. (DTO eka Entity ekata harawana wada)

        // anthimata ara okoma ekathukaragaththa DTO list eka return karanawa.
        //return categoryDTOList;
    }
}