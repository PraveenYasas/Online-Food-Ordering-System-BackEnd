package lk.ijse.cmjd113.FoodOrderingSystem.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import lk.ijse.cmjd113.FoodOrderingSystem.entities.FoodItemEntity;

// api kalin hadapu tables athare kathabaha karanna (Data danna, Ganna, Maknanna) palamak hadana eka.

@Repository
public interface FoodItemDAO extends JpaRepository<FoodItemEntity, Long> { // me JPA repository ekeken extend kalahama api aaii amuthuwen SQL queris gahanna one naha.

    // Issarahata apita "Burgers" Category walata adala kama witharak filter karala ganna ona unahama meka watinawa.
    List<FoodItemEntity> findByCategoryId(Long categoryId);
}
