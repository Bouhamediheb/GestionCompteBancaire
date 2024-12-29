package tn.iit;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.password.PasswordEncoder;
import tn.iit.beans.User;
import tn.iit.repository.UserRepository;

import java.util.List;

@SpringBootApplication
public class GestionCompteApplication {

	public static void main(String[] args) {
		SpringApplication.run(GestionCompteApplication.class, args);
	}

	@Bean
	CommandLineRunner initDatabase(UserRepository userRepository, PasswordEncoder passwordEncoder) {
		return args -> {
			if (userRepository.findByUsername("admin").isEmpty()) {
				userRepository.save(
						new User("admin", passwordEncoder.encode("password"), List.of("ADMIN"))
				);
			}
			if (userRepository.findByUsername("user").isEmpty()) {
				userRepository.save(
						new User("user", passwordEncoder.encode("password"), List.of("USER"))
				);
			}
		};
	}
}
