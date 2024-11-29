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
        boolean isDev = env.getProperty("spring.profiles.active", "").equals("dev");
        System.out.println("Security configuration active: " + (isDev ? "dev" : "prod"));

        http
            .authorizeHttpRequests((requests) -> requests
                .requestMatchers(
                    "/", "/game/**", "/signin", "/users", "/login", "/h2-console/**", "/games/**"
                ).permitAll()
                .requestMatchers("/css/**", "/js/**", "/image/**", "/webjars/**", "/favicon.ico").permitAll()
                .anyRequest().permitAll()
            )
            .formLogin((form) -> form
                .loginPage("/login")
                .defaultSuccessUrl("/")
                .permitAll()
            )
            .logout((logout) -> logout.permitAll());

        if (isDev) {
            http.csrf((csrf) -> csrf.disable())
                .headers((headers) -> headers.frameOptions((frame) -> frame.sameOrigin()));
        }

        return http.build();
    }

}
