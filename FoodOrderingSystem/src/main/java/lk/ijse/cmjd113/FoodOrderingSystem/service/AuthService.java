package lk.ijse.cmjd113.FoodOrderingSystem.service;

import lk.ijse.cmjd113.FoodOrderingSystem.dto.JwtAuthResponse;
import lk.ijse.cmjd113.FoodOrderingSystem.dto.LoginDTO;
import lk.ijse.cmjd113.FoodOrderingSystem.dto.RegisterDTO;

public interface AuthService {
    JwtAuthResponse register(RegisterDTO registerDTO);
    JwtAuthResponse login(LoginDTO loginDTO);
}