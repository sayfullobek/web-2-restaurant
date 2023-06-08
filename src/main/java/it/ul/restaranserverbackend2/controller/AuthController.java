package it.ul.restaranserverbackend2.controller;

import it.ul.restaranserverbackend2.entity.User;
import it.ul.restaranserverbackend2.payload.ApiResponse;
import it.ul.restaranserverbackend2.payload.GetData;
import it.ul.restaranserverbackend2.payload.LoginDto;
import it.ul.restaranserverbackend2.payload.ResToken;
import it.ul.restaranserverbackend2.repository.AuthRepository;
import it.ul.restaranserverbackend2.security.JwtTokenProvider;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/auth")
@RequiredArgsConstructor
public class AuthController {
    private final AuthenticationManager authenticationManager;
    private final AuthRepository authRepository;
    private final JwtTokenProvider jwtTokenProvider;

    @PostMapping("/login")
    public HttpEntity<?> register(@RequestBody LoginDto loginDto) {
        authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(loginDto.getPhoneNumber(), loginDto.getPassword())
        );
        User user = authRepository.findByPhoneNumber(loginDto.getPhoneNumber());
        if (user != null) {
            GetData data = getData(user);
            return ResponseEntity.ok(data);
        }
        return ResponseEntity.ok(ApiResponse.builder().message("sizga kirish mumkin emas").success(false).build());
    }

    public GetData getData(User user) {
        String token = jwtTokenProvider.generateToken(user.getId());
        ResToken resToken = ResToken.builder().body(token).build();
        return GetData.builder().resToken(resToken).user(user).build();
    }

}
