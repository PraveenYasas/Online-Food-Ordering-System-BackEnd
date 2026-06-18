package lk.ijse.cmjd113.FoodOrderingSystem.controller;

import java.util.List;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import lk.ijse.cmjd113.FoodOrderingSystem.dto.CategoryDTO;
import lk.ijse.cmjd113.FoodOrderingSystem.service.CategoryService;
import lombok.RequiredArgsConstructor;



// me class eken wenne front end eken wena request allaganna eka. 
// eekkiyanne meka controller layer ekak kiyyala Spring boot ekata kiyanne meken.
// meka hariyata hotalayaka reseption ekak wage (menna me category eka save karanna kiwwahama) meya eka aragena categoryService ekata pass karanawa.

@RestController
@RequestMapping("/categories")   // me controller ekata enna ona prdhana URL eka.
@CrossOrigin
@RequiredArgsConstructor

public class CategoryController {
    private final CategoryService categoryService;  // me controller ekata katha karanna eka methanata sambanda karagannawa.

    @PostMapping
    public CategoryDTO saveCategory(@RequestBody CategoryDTO categoryDTO) {     // me method eka front end eken ewana data tika catch karaganna kenagen.
                                                                                // me @RequestBody eken karanne ee ena JSON data tika catch karagena lassanata api ara hadapu CategoryDTO eka athulata yawana ekai.
        return categoryService.saveCategory(categoryDTO);   // Controller eka kelinma Database ekata atha danne naa.
                                                            // Eyaa karanne ara aapu DTO eka Service ekata pass karala kiyanawa "Menna meka save karala denna kiyala".
                                                            // Eyaata therenne Service layer ekak thiyenawa, meka controller ekata katha karanna eka methanata sambanda karagannawa.
                                                            // Service layer eke saveCategory method eka call karala categoryDTO eka pass karanawa.
                                                            // Service layer eke saveCategory method eka iwara unain passe me method eke return wechcha CategoryDTO eka apahu front end ekata yawanawa.
    }

    @GetMapping
    public List<CategoryDTO> getAllCategories() {   // me method eka front end eken category list ekak ganna request ekwwahama call wenawa.
        return categoryService.getAllCategories();  // Service layer eke getAllCategories method eka call karala category list eka ganna kiyanawa.
    }
    
}