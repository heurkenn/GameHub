package fr.gamehub.gamehub.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
public class SecurityConfig {

    @Bean
    public BCryptPasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        http
            .authorizeHttpRequests((requests) -> requests
                .requestMatchers("/", "/index", "/css/**", "/js/**", "/images/**").permitAll() // Permettre l'accès public à l'index
                .anyRequest().authenticated() // Toute autre requête nécessite une authentification
            )
            .formLogin((form) -> form
                .loginPage("/login") // Définir la page de login
                .permitAll() // Permettre l'accès public à la page de login
            )
            .logout((logout) -> logout.permitAll()); // Permettre à tout le monde de se déconnecter

        return http.build();
    }
}
