package it.ul.restaranserverbackend2.component;

import it.ul.restaranserverbackend2.entity.Role;
import it.ul.restaranserverbackend2.entity.User;
import it.ul.restaranserverbackend2.entity.enums.RoleName;
import it.ul.restaranserverbackend2.repository.AuthRepository;
import it.ul.restaranserverbackend2.repository.RoleRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.rest.webmvc.ResourceNotFoundException;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.crypto.password.PasswordEncoder;

import java.util.Collection;
import java.util.Collections;

@Configuration
@EnableWebSecurity
@RequiredArgsConstructor
public class DataLoader implements CommandLineRunner {
    @Value("${spring.jpa.hibernate.ddl-auto}")
    private String init;
    private final AuthRepository authRepository;
    private final RoleRepository roleRepository;
    private final PasswordEncoder passwordEncoder;

    @Override
    public void run(String... args) throws Exception {
        if (init.equals("create-drop") || init.equals("create")) {
            for (RoleName value : RoleName.values()) {
                roleRepository.save(new Role(value));
            }

            authRepository.save(
                    new User(
                            "qozi", "gadayev", "123456789", passwordEncoder.encode("1234567"), Collections.singleton(roleRepository.findById(3).orElseThrow(() -> new ResourceNotFoundException("getRole")))
                    )
            );
        }
    }
}
