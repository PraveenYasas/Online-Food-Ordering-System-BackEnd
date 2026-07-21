package lk.ijse.cmjd113.FoodOrderingSystem.controller;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import lombok.RequiredArgsConstructor;

// me controller class eka hariyata ape receptionist kenek wage.
// frontend eken ewana JSON data tika mulinma catch karaganne meya.
// Allagena eka kelinma ara api hadapu UserService ekata pass karanawa.
// "Menna meka save karala denna kiyala".

@RestController                     // Meka API endpont ekak kiyyala Spring boot ekata kiyanne meken.
@RequestMapping("/users")           // Me Controller ekata enna ona prdhana URL eka.
@CrossOrigin                        // front end eke port ekekin katha karanakota Block wenne nathiwenna meka danawa.
@RequiredArgsConstructor            // @RequredArgsConstructor - meka damma gaman ara private final kiyala thiyana hama Variable ekakatama Lombok eken ibema constructor eka hadanawa.
                                    // userService kiyana deka athata ganna athin constructor ekak liyala thiyanawa ekek @RequredArgsConstructor dammahama ehema karanna one naha 
                                    // saralawa kiwwoth Ibema constructor eka hadenawa.
public class UserController {

    //@Autowired                // Methanin karanne ape conntroller ekai, ara api kalin hadapu UserService ekai athara connection eka hadana eka.
                                // Samanyayen java walanam UserService userService = new UserServiceImpl(); kiyala gahanna ona.
                                // Habai @Autowired kiyala dammahama mukuth one naha spring eken ibema sambanda karala denawa. (Dependency Injection kiyanne mekata)
                                // Ethakota controller ekata puluwan service ekata orders denna

    // private final UserService userService;    // Service ekata katha karanna eka methanata sambanda karagannawa.

    // @PostMapping("/register")   // Frontend eken alth user kenek save karanna request ewwwahama eka enne mee register kiyana (API endpoint ekata).
    //                             // meka dakka gaman yata thiyana method eka aharenawa.

    // public String registerUser(@RequestBody UserDTO userDTO) {  // Frontend eken ewanne JSON format eken.
    //                                                             // Me @RequestBody eken karanne ee ena JSON data tika catch karagena lassanata api ara hadapu UserDTO eka athulata yawana ekai.
                                                                

    //     userService.saveUser(userDTO);          // Controller eka kelinma Database ekata atha danne naa.
    //                                             // Eyaa karanne ara aapu DTO eka Service ekata pass karala kiyanawa "Menna meka save karala denna kiyala".
                                                
    //     return "User registered successfully";  // Wade iwara unagaman react ekata mesg ekak yawanawa.
    // }

    // @PostMapping("/login")      // Kalin eka wagea thama.
    //                             // React eken ewana Email ekai Password ekai allaganna methanadi pawichchi karanne LogiDTO eka.

    // public String loginUser(@RequestBody LoginDTO loginDTO) {
    //     return userService.loginUser(loginDTO);    // Methanadi SaveUser ekewge neweii, kellinma Service eken enade React ekat return karanawa.
    // }
}
