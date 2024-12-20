package fr.gamehub.gamehub.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.env.Environment;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

import fr.gamehub.gamehub.service.MyUserDetailsService;
import jakarta.servlet.http.HttpServletResponse;

@Configuration
@EnableWebSecurity
public class SecurityConfig {

    @Autowired
    private MyUserDetailsService myUserDetailsService;
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
        boolean isDev = env.getProperty("spring.profiles.active", "").equals("dev");
        System.out.println("Security configuration active: " + (isDev ? "dev" : "prod"));

        http

            .userDetailsService(myUserDetailsService)  // Indique quel service utiliser
            .authorizeHttpRequests((requests) -> requests
                
                .requestMatchers("/",  "/register", "/login", "/h2-console/**", "/css/**", "/js/**", "/image/**").permitAll()
                .requestMatchers("/admin-dashboard/**").hasRole("SUPER_ADMIN")
                .anyRequest().authenticated()
            )
            .formLogin(form -> form
            .loginPage("/login")
            .usernameParameter("username")
            .passwordParameter("password")
            .defaultSuccessUrl("/")
            .failureHandler((request, response, exception) -> {
                // Retourner un statut HTTP 401 (Unauthorized) pour un login échoué
                response.setStatus(HttpServletResponse.SC_UNAUTHORIZED);
                response.getWriter().write("Nom d'utilisateur ou mot de passe incorrect.");
            })
            .permitAll()
            )

            .logout(logout -> logout
                .logoutUrl("/logout")
                .logoutSuccessUrl("/login?logout=true")
                .permitAll()
            );
  

        if (isDev) {
            http.csrf((csrf) -> csrf.disable())
                .headers((headers) -> headers.frameOptions((frame) -> frame.sameOrigin()));
        }

        return http.build();
    }

}
