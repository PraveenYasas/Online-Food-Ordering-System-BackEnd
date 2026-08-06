package lk.ijse.cmjd113.FoodOrderingSystem.util;

import java.util.Arrays;
import java.util.List;

import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import lk.ijse.cmjd113.FoodOrderingSystem.dao.CategoryDAO;
import lk.ijse.cmjd113.FoodOrderingSystem.entities.CategoryEntity;
import lombok.RequiredArgsConstructor;

@Component
@RequiredArgsConstructor
public class DatabaseSeeder implements CommandLineRunner {

    private final CategoryDAO categoryDAO;

    @Override
    public void run(String... args) throws Exception {
        
        if (categoryDAO.count() == 0) {
            
            List<String> defaultCategories = Arrays.asList(
                "Grocery", "Soup", "Chinese", "Burgers", "Desserts", 
                "BBQ", "Korean", "Bakery", "Indian", "Asian", 
                "Salads", "Smoothies", "Coffee", "American"
            );

            for (String catName : defaultCategories) {
                CategoryEntity category = new CategoryEntity();
                category.setName(catName);
                category.setDescription(catName + " Category");
                
                categoryDAO.save(category);
            }
            
            System.out.println("✅ All categories successfully seeded into the database!");
        }
    }
}