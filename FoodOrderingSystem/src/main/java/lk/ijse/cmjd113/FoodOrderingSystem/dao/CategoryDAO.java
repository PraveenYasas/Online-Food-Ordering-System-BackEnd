package lk.ijse.cmjd113.FoodOrderingSystem.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import lk.ijse.cmjd113.FoodOrderingSystem.entities.CategoryEntity;

// api kalin hadapu tables athare kathabaha karanna (Data danna, Ganna, Maknanna) palamak hadana eka.

// @Repository
public interface CategoryDAO extends JpaRepository<CategoryEntity, Long> {
    // namen category ekak thiyanawada kiyala check karaganna onaunoth meka pawichch karanna puluwan.
    boolean existsByName(String name);
}
