package it.ul.restaranserverbackend2.repository;

import it.ul.restaranserverbackend2.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface AuthRepository extends JpaRepository<User, UUID> {
    User findByPhoneNumber(String phoneNumber);
}
