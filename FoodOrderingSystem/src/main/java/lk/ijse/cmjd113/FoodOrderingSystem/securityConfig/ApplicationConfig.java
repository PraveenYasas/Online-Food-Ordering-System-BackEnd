package lk.ijse.cmjd113.FoodOrderingSystem.securityConfig;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.authentication.configuration.AuthenticationConfiguration;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

import lk.ijse.cmjd113.FoodOrderingSystem.dao.UserDAO;
import lombok.RequiredArgsConstructor;

@Configuration
@RequiredArgsConstructor
public class ApplicationConfig {

    private final UserDAO userDAO;

    // 1. Database එකෙන් User ව හොයාගන්න විදිය
    @Bean
    public UserDetailsService userDetailsService() {
        return username -> userDAO.findByEmail(username)
                .orElseThrow(() -> new UsernameNotFoundException("User not found!"));
    }

    // 2. Password එක හැෂ් කරන්න (Encrypt කරන්න) පාවිච්චි කරන ක්‍රමය
    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

    // 3. User වයි Password එකයි මැච් කරලා බලන ප්‍රධාන කෑල්ල
    @Bean
    public AuthenticationProvider authenticationProvider() {
        // අලුත් වර්ෂන් එකේ UserDetailsService එක කෙලින්ම constructor එකට පාස් කරන්න ඕනේ
        DaoAuthenticationProvider authProvider = new DaoAuthenticationProvider(userDetailsService());
        authProvider.setPasswordEncoder(passwordEncoder());
        return authProvider;
    }

    // 4. අපි AuthService එකේ පාවිච්චි කරපු Authentication Manager එක
    @Bean
    public AuthenticationManager authenticationManager(AuthenticationConfiguration config) throws Exception {
        return config.getAuthenticationManager();
    }
}