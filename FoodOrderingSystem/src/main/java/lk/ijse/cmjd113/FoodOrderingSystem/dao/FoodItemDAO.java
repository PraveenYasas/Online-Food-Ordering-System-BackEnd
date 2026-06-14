package lk.ijse.cmjd113.FoodOrderingSystem.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import lk.ijse.cmjd113.FoodOrderingSystem.entities.FoodItemEntity;

@Repository
public interface FoodItemDAO extends JpaRepository<FoodItemEntity, Long> {
    // Issarahata apita "Burgers" Category walata adala kama witharak filter karala ganna ona unahama meka watinawa.
    List<FoodItemEntity> findByCategoryId(Long categoryId);
}
