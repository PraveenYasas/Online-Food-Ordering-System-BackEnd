package lk.ijse.cmjd113.FoodOrderingSystem.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import lk.ijse.cmjd113.FoodOrderingSystem.dto.JwtAuthResponse;
import lk.ijse.cmjd113.FoodOrderingSystem.dto.LoginDTO;
import lk.ijse.cmjd113.FoodOrderingSystem.dto.RegisterDTO;
import lk.ijse.cmjd113.FoodOrderingSystem.service.AuthService;
import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/auth")
@RequiredArgsConstructor
@CrossOrigin(origins = "*") // React Frontend එකෙන් එන Request වලට ඉඩ දෙන්න මේක අනිවාර්යයි
public class AuthController {

    private final AuthService authService;

    // 1. අලුත් User කෙනෙක් රෙජිස්ටර් කරන Endpoint එක (POST /api/v1/auth/register)
    @PostMapping("/register")
    public ResponseEntity<JwtAuthResponse> register(@RequestBody RegisterDTO request) {
        // අර අපි හදපු AuthService එකට වැඩේ බාර දෙනවා
        JwtAuthResponse response = authService.register(request);
        return ResponseEntity.ok(response);
    }

    // 2. දැනට ඉන්න User කෙනෙක් ලොග් වෙන Endpoint එක (POST /api/v1/auth/login)
    @PostMapping("/login")
    public ResponseEntity<JwtAuthResponse> login(@RequestBody LoginDTO request) {
        // AuthService එකෙන් email/password චෙක් කරලා ටෝකන් එක දෙනවා
        JwtAuthResponse response = authService.login(request);
        return ResponseEntity.ok(response);
    }
}