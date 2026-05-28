package lk.ijse.cmjd113.FoodOrderingSystem.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

// Controller kene service ekata eddi enna ona DTO ekak.
// Itapasse Service eka athuledi thamai DTO eka Entity ekakata convert karala DAO ekata yawanne.
// Ethakota Data base eke hadaya koiwelawaka wath eliyata expose wenne naa.

// me class eken karanne frontend eken ena data tika catch karaganne.

// me anotation tika enne lombok kiyana library eken.
@Data                   // @Data , java waladi api fields haduwahama (firstName, lastName) wage ewwa gannai wenas karannai getters, setters athin liyanna ona.
                        // @Data , dammahama e code tika auto ma pitipassen hadenawa. ethakota code eka patta clean.

@NoArgsConstructor      // @NoArgsConstructor , meken karanne kisima parameter ekak nathi his constructor ekak ibema hadana eka.
                        // Fronttend eken ena JSON data tika allagna java object ekak bawata path karanakota springboot ekata me his constructor eka aniwa ona wenawa.

@AllArgsConstructor     // @AllArgsConstructor , meken karane fields okkoma thiyana constructor ekak hadana ekai.
                        // Ethakota kohe hari thanakin lesiyenma " new UserDTO("Praveen", "Yasas", "praween@example.com", ...) " kiyala eka peliyakin object ekak hadaganna puluwan.

public class UserDTO {
    private String firstName;
    private String lastName;
    private String email;
    private String phoneNumber;
    private String password;
}
