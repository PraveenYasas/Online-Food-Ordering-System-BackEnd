package lk.ijse.cmjd113.FoodOrderingSystem.dao;

// Ape application ekai data bse eka athara katha baha karanne me layer eka haraha.
// Data bse ekakth ekka kelinma sambanda wela data ganna, danna pawichchi karana kalla

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import lk.ijse.cmjd113.FoodOrderingSystem.entities.UserEntity;

// @Repository       - meken springboot ekata kiyanawa meka thama database ekath ekka ganu denu karana pradhana kalla kiyala.
@Repository

// extends JpaRepository<UserEntity, Long>.    - UserEntity kiyanne ape entitiy eka
//                                             - Long kiyanne eke primary key eke data type eka.
// meka extend kalahama apita data base ekata data danna, makanna, update karanna amuthuwen SQL code liyanna one naha.
// (save(), findById(), findAll(), delete(), deleteById() widihata thiyana method walin data base ekata ganu denu karanna puluwan.)

// Spring Data JPA walathiyana supirima de thama apita ona widihata name gahala method haduwahama 
// Ex: (findByEmail, existsByEmail) Ekata adala SQL query eka ibema hadagannawa. 
// Eka amuthuwen liyanna one naha.

public interface UserDAO extends JpaRepository<UserEntity, Long> {

    // Email eka pawichchi karala user kenek wa hoyaganna liyapu method ekak. 
    // JpaRepository eke thiyana method walin hariyata hoyaganna ba. 
    // E nisa mehema method ekak hadala denawa.
    Optional<UserEntity> findByEmail(String email); 

    // Yamkisi email ekak danatamath thiyanawada nathda kiyala check karanna ona method ekak hadala denawa.
    boolean existsByEmail(String email);
}
