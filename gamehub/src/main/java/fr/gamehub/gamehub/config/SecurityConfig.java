package fr.gamehub.gamehub.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.env.Environment;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
public class SecurityConfig {

    private final Environment env;

    public SecurityConfig(Environment env) {
        this.env = env;
    }

    @Bean
    public BCryptPasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        // Vérifier le profil actif en utilisant les propriétés
        boolean isDev = env.getProperty("spring.profiles.active", "").equals("dev");

        if (isDev) {
            System.out.println("Configuration dev activée");
        } else {
            System.out.println("Configuration prod activée");
        }

        if (isDev) {
            // Configuration pour l'environnement "dev"
            http
            .authorizeHttpRequests((requests) -> requests
                // Autoriser explicitement les ressources publiques et la page d'accueil
                .requestMatchers("/", "/index", "/sign-in", "/users", "/css/**", "/js/**", "/images/**", "/h2-console/**").permitAll()
                // Toute autre requête nécessite une authentification
                .anyRequest().authenticated()
            )
            .formLogin((form) -> form
                .loginPage("/login") // Page de connexion personnalisée
                .defaultSuccessUrl("/") // Redirection après connexion réussie
                .permitAll()
            )
            .logout((logout) -> logout.permitAll()) // Autoriser la déconnexion pour tous
            .csrf((csrf) -> csrf.disable()) // Facultatif : Désactiver CSRF pour simplifier (à réactiver en production)
            .headers((headers) -> headers.frameOptions((frame) -> frame.sameOrigin())); // Autoriser les frames H2 (en dev)
    
        return http.build();
        } else {
            // Configuration pour l'environnement "prod" ou autre
            http
                .authorizeHttpRequests((requests) -> requests
                    .requestMatchers("/", "/sign-in", "/css/**", "/js/**", "/images/**").permitAll()
                    .anyRequest().authenticated()
                )
                .formLogin((form) -> form
                    .loginPage("/login")
                    .defaultSuccessUrl("/") // Redirection après connexion réussie
                    .permitAll()
                )

                .logout((logout) -> logout.permitAll());
            // Pas de désactivation CSRF ou de frame options en production
        }

        return http.build();
    }
}
