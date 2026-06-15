package lk.ijse.cmjd113.FoodOrderingSystem.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor

public class FoodItemDTO {
    private Long id;
    private String name;
    private String description;
    private double price;

    private Long categoryId;    // meka category id eka thiyaganna ona, 
                                // nathnam api food item ekak save karanna yaddi category ekak select karanna ba. 
                                // meka category ekakata adala id eka thiyaganna ona.
}
