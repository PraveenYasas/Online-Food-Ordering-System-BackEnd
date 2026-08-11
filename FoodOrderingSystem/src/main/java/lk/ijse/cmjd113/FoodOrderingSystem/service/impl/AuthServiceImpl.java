package lk.ijse.cmjd113.FoodOrderingSystem.service.impl;

import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import lk.ijse.cmjd113.FoodOrderingSystem.dao.UserDAO;
import lk.ijse.cmjd113.FoodOrderingSystem.dto.JwtAuthResponse;
import lk.ijse.cmjd113.FoodOrderingSystem.dto.LoginDTO;
import lk.ijse.cmjd113.FoodOrderingSystem.dto.RegisterDTO;
import lk.ijse.cmjd113.FoodOrderingSystem.entities.UserEntity;
import lk.ijse.cmjd113.FoodOrderingSystem.entities.enums.Role;
import lk.ijse.cmjd113.FoodOrderingSystem.securityConfig.JwtService;
import lk.ijse.cmjd113.FoodOrderingSystem.service.AuthService;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class AuthServiceImpl implements AuthService {

    private final UserDAO userDAO;
    private final PasswordEncoder passwordEncoder;
    private final JwtService jwtService;
    private final AuthenticationManager authenticationManager;

    @Override
    public JwtAuthResponse register(RegisterDTO request) {
        // 1. Check the Email already exists in the database or not. If exists, throw an exception
        if (userDAO.existsByEmail(request.getEmail())) {
            throw new RuntimeException("Email is already registered!");
        }

        // 2. Create new User and save it to the database
        UserEntity user = new UserEntity();
        user.setFirstName(request.getFirstName());
        user.setLastName(request.getLastName());
        user.setEmail(request.getEmail());
        user.setPhone(request.getPhone());
        
        // 3. Password eka Encrypt karala (#) save karanawa
        user.setPassword(passwordEncoder.encode(request.getPassword()));
        
        System.out.println("👉 Frontend එකෙන් ආපු Role එක: " + request.getRole());
        
        if (request.getRole() != null && request.getRole().trim().equalsIgnoreCase("RESTURANT_OWNER")) {
            user.setRole(Role.RESTURANT_OWNER); 
        } else {
            user.setRole(Role.CUSTOMER);
        }

        userDAO.save(user);

        // 5. Aluth Token ekak hadala return karanawa
        String jwtToken = jwtService.generateToken(user);
        return new JwtAuthResponse(jwtToken, user.getRole().name());
    }

    @Override
    public JwtAuthResponse login(LoginDTO request) {
        // 1. Spring Security eken email and password match karala check karanawa. (AuthenticationManager eken)
        authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(request.getEmail(), request.getPassword())
        );

        // 2. Ok nam, User wa Database eken aran eyata Token ekak hadala return karanawa (Frontend eken e token eka catch karaganna thama me class eka hadanne)
        var user = userDAO.findByEmail(request.getEmail())
                .orElseThrow(() -> new IllegalArgumentException("Invalid email or password."));
        
        var jwtToken = jwtService.generateToken(user);
        return new JwtAuthResponse(jwtToken, user.getRole().name());
    }
}