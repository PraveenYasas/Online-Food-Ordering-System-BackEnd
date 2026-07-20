package lk.ijse.cmjd113.FoodOrderingSystem.dto;

import lombok.AllArgsConstructor;
import lombok.Data;

// api frontend ekata yawana token eka catch karaganna thama me class eka hadanne.

@Data
@AllArgsConstructor
public class JwtAuthResponse {
    private String token;
}