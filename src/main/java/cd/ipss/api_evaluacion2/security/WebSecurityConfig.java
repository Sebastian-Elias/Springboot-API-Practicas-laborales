package cd.ipss.api_evaluacion2.security;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
public class WebSecurityConfig {

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        http.authorizeHttpRequests(request -> 
            request
                .requestMatchers("/api/estudiantes/**").hasRole("ESTUDIANTE") // Solo estudiantes
                .requestMatchers("/api/profesores/**").hasRole("PROFESOR")   // Solo profesores
                .requestMatchers("/api/public/info").permitAll()              // Acceso público
                .anyRequest().authenticated()                               // Cualquier otro endpoint requiere autenticación
        )
        .httpBasic(Customizer.withDefaults()) // Autenticación HTTP Basic
        .csrf(csrf -> csrf.disable());        // Deshabilitar CSRF (para pruebas, no recomendado en producción)
        
        return http.build();
    }

    @Bean
    public UserDetailsService userDetailsService(PasswordEncoder passwordEncoder) {
        // Configuración de usuarios en memoria para pruebas
        User.UserBuilder users = User.builder();

        UserDetails estudiante = users
            .username("estudiante1")
            .password(passwordEncoder.encode("123456"))
            .roles("ESTUDIANTE") // Rol de estudiante
            .build();

        UserDetails profesor = users
            .username("profesor1")
            .password(passwordEncoder.encode("654321"))
            .roles("PROFESOR") // Rol de profesor
            .build();

        return new InMemoryUserDetailsManager(estudiante, profesor);
    }

    @Bean
    public PasswordEncoder passwordEncoder() {
        // Codificador de contraseñas usando BCrypt
        return new BCryptPasswordEncoder();
    }
}
