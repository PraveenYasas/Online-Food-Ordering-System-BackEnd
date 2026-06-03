package lk.ijse.cmjd113.FoodOrderingSystem.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import lk.ijse.cmjd113.FoodOrderingSystem.dto.LoginDTO;
import lk.ijse.cmjd113.FoodOrderingSystem.dto.UserDTO;
import lk.ijse.cmjd113.FoodOrderingSystem.service.UserService;

// me controller class eka hariyata ape receptionist kenek wage.
// frontend eken ewana JSON data tika mulinma catch karaganne meya.
// Allagena eka kelinma ara api hadapu UserService ekata pass karanawa.
// "Menna meka save karala denna kiyala".

@RestController                     // Meka API endpont ekak kiyyala Spring boot ekata kiyanne meken.
@RequestMapping("/api/v1/users")    // Me Controller ekata enna ona prdhana URL eka.
@CrossOrigin                        // front end eke port ekekin katha karanakota Block wenne nathiwenna meka danawa.

public class UserController {
    @Autowired
    private UserService userService;    // Service ekata katha karanna eka methanata sambanda karagannawa.

    @PostMapping("/register")   
    public String registerUser(@RequestBody UserDTO userDTO) {

        userService.saveUser(userDTO);          // Frontend apu daththa tika Service ekata ywanawa save karanna kiyala.
        return "User registered successfully";
    }

    @PostMapping("/login")
    public String loginUser(@RequestBody LoginDTO loginDTO) {
        return userService.loginUser(loginDTO);    // Frontend apu daththa tika Service ekata ywanawa login karanna kiyala.
    }
}
