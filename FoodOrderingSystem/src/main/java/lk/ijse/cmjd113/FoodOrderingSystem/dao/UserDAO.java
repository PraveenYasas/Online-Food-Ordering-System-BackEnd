package lk.ijse.cmjd113.FoodOrderingSystem.dao;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import lk.ijse.cmjd113.FoodOrderingSystem.entities.UserEntity;

// Ape application ekai data bse eka athara katha baha karanne me layer eka haraha.
// Data bse ekakth ekka kelinma sambanda wela data ganna, danna pawichchi karana kalla

@Repository
public interface UserDAO extends JpaRepository<UserEntity, Long> {

    // Email eka pawichchi karala user kenek wa hoyaganna liyapu method ekak. 
    // JpaRepository eke thiyana method walin hariyata hoyaganna ba. 
    // E nisa mehema method ekak hadala denawa.
    Optional<UserEntity> findByEmail(String email); 

    // Yamkisi email ekak danatamath thiyanawada nathda kiyala check karanna ona method ekak hadala denawa.
    boolean existsByEmail(String email);
}
