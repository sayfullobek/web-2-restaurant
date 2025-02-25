package it.ul.restaranserverbackend2.service;

import it.ul.restaranserverbackend2.entity.Role;
import it.ul.restaranserverbackend2.entity.SaveProduct;
import it.ul.restaranserverbackend2.entity.User;
import it.ul.restaranserverbackend2.payload.ApiResponse;
import it.ul.restaranserverbackend2.payload.AuthDto;
import it.ul.restaranserverbackend2.repository.AuthRepository;
import it.ul.restaranserverbackend2.repository.RoleRepository;
import it.ul.restaranserverbackend2.repository.SaveProductRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.rest.webmvc.ResourceNotFoundException;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class AuthService implements UserDetailsService {
    private final AuthRepository authRepository;
    private final RoleRepository roleRepository;

    @Autowired
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

    public ApiResponse register(AuthDto dto) {
        try {
            boolean b = authRepository.existsUsersByPhoneNumber(dto.getPhoneNumber());
            Role getRole = roleRepository.findById(1).orElseThrow(() -> new ResourceNotFoundException("getRole"));
            if (!b) {
                User build = User.builder().roles(Collections.singleton(getRole)).lastName(dto.getSurName()).password(dto.getPhoneNumber()).phoneNumber(dto.getPhoneNumber()).firstName(dto.getName()).build();
                authRepository.save(build);
                return new ApiResponse("Saqlandi", true);
            }
            return new ApiResponse("Bunday User Avvaldan mavjud", false);
        } catch (Exception e) {
            return new ApiResponse("xatolik", false);
        }

    }
    @Override
    public UserDetails loadUserByUsername(String phoneNumber) throws UsernameNotFoundException {
        return authRepository.findUserByPhoneNumber(phoneNumber).orElseThrow(() -> new UsernameNotFoundException("getUser"));
    }

    public UserDetails getUserById(UUID id) {
        return authRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("getUser"));
    }
}
