package lk.ijse.cmjd113.FoodOrderingSystem.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

// front end eke indan ena kaama wala wisthara aran ena data tika thiyaganna ona, 
// meka data transfer object ekak (DTO) kiyana eka.

@Data                   // meka dammahama getters and setters, toString, equals, hashCode methods tika auto generate karala denawa.
@NoArgsConstructor
@AllArgsConstructor

public class CategoryDTO {
    private Long id;
    private String name;
    private String description;
}
