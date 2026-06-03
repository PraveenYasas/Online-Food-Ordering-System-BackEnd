package lk.ijse.cmjd113.FoodOrderingSystem.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

// React eken logweddi ewanne Email and Password witharaii.
// Ee ena password and email catcj karaganna thama me class eka crete karanne.
// Log wenakota apita ona wennenathi tika name, phone number wage ewwa catch karanna ona nathi nisa me class eka hadanne email and password witharaii.
// anna ee tika arakshithawa catch karaganna thama mee DTO eka crete karaganne.

@Data                   // me @Data anotation eka dammahama getters and setters hadala denawa.
                        // getEmail(), setPassword(), setEmail() wage code liya liya inna one naa.
                        // Lombock eken eetika ibema pitipassen hadala denawa.

@NoArgsConstructor      // me @NoArgsConstructor annotation eken kisima parameter ekak nathi his constructor ekak hadala denawa.
                        // Frontend eken ewana json data tika Java Object ekakata harawaganna SpringBoot ekata me his constructor eka aniwaryai.
                        
@AllArgsConstructor     // me @AllArgsConstructor annotation eken fields okkotama ekapara Object ekak hadaganna puluwan constructor ekak hadanawa.
                        // Meka godak welawata onawenne api code eka liyaddi eka test karaganna ona unahama meka watinawa.

public class LoginDTO {
    private String Email;
    private String Password;
}
