package lk.ijse.cmjd113.FoodOrderingSystem.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class JwtAuthResponse {
    private String token;
    private String role;
    private String firstName;
    private String lastName;
    private String email;
    private String phone;
}