package it.ul.restaranserverbackend2.repository;

import it.ul.restaranserverbackend2.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.web.bind.annotation.CrossOrigin;

import java.util.UUID;

@CrossOrigin
public interface AuthRepository extends JpaRepository<User, UUID> {
    User findByPhoneNumber(String phoneNumber);
}
