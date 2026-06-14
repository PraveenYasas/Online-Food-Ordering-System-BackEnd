package lk.ijse.cmjd113.FoodOrderingSystem.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import lk.ijse.cmjd113.FoodOrderingSystem.entities.CategoryEntity;

@Repository
public interface CategoryDAO extends JpaRepository<CategoryEntity, Long> {
    // namen category ekak thiyanawada kiyala check karaganna onaunoth meka pawichch karanna puluwan.
    boolean existsByName(String name);
}
