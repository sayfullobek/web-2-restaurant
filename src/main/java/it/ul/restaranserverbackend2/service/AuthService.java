package it.ul.restaranserverbackend2.service;

import it.ul.restaranserverbackend2.entity.User;
import it.ul.restaranserverbackend2.repository.AuthRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.rest.webmvc.ResourceNotFoundException;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
@RequiredArgsConstructor
public class AuthService implements UserDetailsService {
    private final AuthRepository authRepository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        return null;
    }

    public User getUserById(UUID id) {
        return authRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("getUser"));
    }
}
