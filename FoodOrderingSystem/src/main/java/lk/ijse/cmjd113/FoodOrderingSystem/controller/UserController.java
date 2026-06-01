package lk.ijse.cmjd113.FoodOrderingSystem.controller;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

// me controller class eka hariyata ape receptionist kenek wage.
// frontend eken ewana JSON data tika mulinma catch karaganne meya.
// Allagena eka kelinma ara api hadapu UserService ekata pass karanawa.
// "Menna meka save karala denna kiyala".

@RestController                     // Meka API endpont ekak kiyyala Spring boot ekata kiyanne meken.
@RequestMapping("/api/v1/users")    // Me Controller ekata enna ona prdhana URL eka.
@CrossOrigin                        // front end eke port ekekin katha karanakota Block wenne nathiwenna meka danawa.

public class UserController {
    
}
