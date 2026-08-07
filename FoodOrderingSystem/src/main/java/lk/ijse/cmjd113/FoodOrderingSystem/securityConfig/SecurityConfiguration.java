package lk.ijse.cmjd113.FoodOrderingSystem.securityConfig;

import java.util.List;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configurers.AbstractHttpConfigurer;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.CorsConfigurationSource;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;

import lombok.RequiredArgsConstructor;

@Configuration
@EnableWebSecurity
@RequiredArgsConstructor
public class SecurityConfiguration {

    private final JwtAuthenticationFilter jwtAuthFilter;
    private final AuthenticationProvider authenticationProvider;

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        http
            .cors(cors -> cors.configurationSource(corsConfigurationSource())) // 🔥 CORS ප්‍රශ්නෙ විසඳන්න මේක දැම්මා
            .csrf(AbstractHttpConfigurer::disable) // Token පාවිච්චි කරන නිසා CSRF ඕනේ නෑ
            .authorizeHttpRequests(auth -> auth
                .requestMatchers("/auth/**").permitAll() // Login සහ Register වලට හැමෝටම යන්න දෙනවා
                
                // 🔥 දැනට අපිට මේ ටික Test කරගන්න ඕන නිසා, මේ ලින්ක් වලටත් Token නැතුව යන්න දෙනවා.
                // (පස්සේ අපි Frontend එකෙන් Token එක හරියට යවද්දී මේක අයින් කරමු)
                .requestMatchers(   "/api/v1/categories/**", 
                                                "/api/v1/food-items/**", 
                                                "/api/v1/images/**")
                                                .permitAll() 
                
                .anyRequest().authenticated() // අනිත් හැම රික්වෙස්ට් එකකටම ලොග් වෙලා ඉන්න ඕනේ
            )
            .sessionManagement(sess -> sess.sessionCreationPolicy(SessionCreationPolicy.STATELESS)) // Session තියාගන්නේ නෑ (JWT වල හැටි)
            .authenticationProvider(authenticationProvider)
            .addFilterBefore(jwtAuthFilter, UsernamePasswordAuthenticationFilter.class); // අපේ ෆිල්ටර් එක මුලින්ම දානවා

        return http.build();
    }

    // 🔥 React එකෙන් එන කෝල්ස් අනුමත කරන අලුත් කෑල්ල (CORS Configuration)
    @Bean
    public CorsConfigurationSource corsConfigurationSource() {
        CorsConfiguration configuration = new CorsConfiguration();
        configuration.setAllowedOrigins(List.of("*")); 
        configuration.setAllowedMethods(List.of("GET", "POST", "PUT", "DELETE", "OPTIONS"));
        configuration.setAllowedHeaders(List.of("*"));
        
        UrlBasedCorsConfigurationSource source = new UrlBasedCorsConfigurationSource();
        source.registerCorsConfiguration("/**", configuration);
        return source;
    }
}