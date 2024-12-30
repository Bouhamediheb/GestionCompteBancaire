package tn.iit.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.configuration.AuthenticationConfiguration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
public class SecurityConfig {

	// Define the AuthenticationManager bean explicitly
	@Bean
	public AuthenticationManager authenticationManager(AuthenticationConfiguration authenticationConfiguration) throws Exception {
		return authenticationConfiguration.getAuthenticationManager();
	}

	// Define the PasswordEncoder bean
	@Bean
	public PasswordEncoder passwordEncoder() {
		return new BCryptPasswordEncoder();  // Use BCrypt for password encoding
	}

	@Bean
	public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
		// Disable all security configurations (no authentication required)
		http.csrf().disable()  // Disable CSRF protection
				.authorizeHttpRequests()  // New method for authorization
				.requestMatchers("/api/comptes/**", "/api/clients/**", "/api/login", "/error","/api/**","/api/comptes").permitAll()  // Allow all these endpoints without authentication
				.anyRequest().permitAll()  // Allow all other endpoints without authentication
				.and()
				.formLogin().disable()  // Disable login form
				.logout().disable();  // Disable logout

		return http.build();
	}
}
