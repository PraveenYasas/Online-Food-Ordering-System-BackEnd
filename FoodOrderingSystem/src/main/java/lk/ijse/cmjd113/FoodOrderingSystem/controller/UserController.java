package lk.ijse.cmjd113.FoodOrderingSystem.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import lk.ijse.cmjd113.FoodOrderingSystem.dao.UserDAO;
import lombok.RequiredArgsConstructor;

@RestController                     
@RequestMapping("/users")
@CrossOrigin                        
@RequiredArgsConstructor            
public class UserController {

    private final UserDAO userDAO;

    @GetMapping
    public ResponseEntity<List<Map<String, Object>>> getAllUsers() {
        
        List<Map<String, Object>> userList = userDAO.findAll().stream().map(user -> {
            Map<String, Object> map = new HashMap<>();
            map.put("id", user.getId());
            map.put("firstName", user.getFirstName());
            map.put("lastName", user.getLastName());
            map.put("email", user.getEmail());
            map.put("phone", user.getPhone());
            map.put("role", user.getRole().name());
            return map;
        }).collect(Collectors.toList());
        
        return ResponseEntity.ok(userList);
    }
}