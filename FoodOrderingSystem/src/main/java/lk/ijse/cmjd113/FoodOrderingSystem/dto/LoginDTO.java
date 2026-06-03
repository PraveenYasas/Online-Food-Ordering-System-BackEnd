package lk.ijse.cmjd113.FoodOrderingSystem.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

// React eken logweddi ewanne Email and Password witharaii.
// Ee ena password and email catcj karaganna thama me class eka crete karanne.
// Log wenakota apita ona wennenathi tika name, phone number wage ewwa catch karanna ona nathi nisa me class eka hadanne email and password witharaii.
// anna ee tika arakshithawa catch karaganna thama mee DTO eka crete karaganne.

@Data
@NoArgsConstructor
@AllArgsConstructor

public class LoginDTO {
    private String Email;
    private String Password;
}
