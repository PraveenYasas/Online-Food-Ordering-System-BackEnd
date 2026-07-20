package lk.ijse.cmjd113.FoodOrderingSystem.dto;

import lombok.Data;

@Data
public class RegisterDTO {
    private String firstName;
    private String lastName;
    private String email;
    private String phone;
    private String password;
}