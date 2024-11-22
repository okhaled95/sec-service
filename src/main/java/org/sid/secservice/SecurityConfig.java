package org.sid.secservice;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
public class SecurityConfig {

  @Bean
  public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
    http
        .authorizeHttpRequests(authorize -> authorize
            .requestMatchers("/", "/home").permitAll() // Accès libre à ces pages
            .anyRequest().authenticated() // Toutes les autres requêtes nécessitent une authentification
        )
        .formLogin(form -> form
            .loginPage("/login") // Page de connexion personnalisée
            .permitAll() // Permet l'accès à tous
        )
        .logout(logout -> logout
            .permitAll() // Permet l'accès à tous pour la déconnexion
        );

    return http.build();
  }
}
