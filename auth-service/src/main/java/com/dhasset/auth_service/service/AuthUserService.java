package com.dhasset.auth_service.service;

import com.dhasset.auth_service.api.TokenDto;
import com.dhasset.auth_service.api.request.AuthUserRequest;
import com.dhasset.auth_service.model.domain.AuthUser;
import com.dhasset.auth_service.model.repository.AuthUserRepository;
import com.dhasset.auth_service.security.JwtProvider;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Optional;

/**
 * Bruno Ramirez
 **/
@Service
public class AuthUserService {

    private final AuthUserRepository authUserRepository;

    private final PasswordEncoder passwordEncoder;

    private final JwtProvider jwtProvider;

    public AuthUserService(AuthUserRepository authUserRepository, PasswordEncoder passwordEncoder, JwtProvider jwtProvider) {
        this.authUserRepository = authUserRepository;
        this.passwordEncoder = passwordEncoder;
        this.jwtProvider = jwtProvider;
    }

    public AuthUser save(AuthUserRequest authUserRequest) {
        Optional<AuthUser> user = authUserRepository.findByUserName(authUserRequest.getUserName());
        if (user.isPresent()) {
            return null;
        }

        String password = passwordEncoder.encode(authUserRequest.getPassword());
        AuthUser authUser = AuthUser.builder()
                .userName(authUserRequest.getUserName())
                .password(password)
                .build();

        return authUserRepository.save(authUser);
    }

    public TokenDto login(AuthUserRequest authUserRequest) {
        Optional<AuthUser> user = authUserRepository.findByUserName(authUserRequest.getUserName());
        if (!user.isPresent()) {
            return null;
        }

        if (passwordEncoder.matches(authUserRequest.getPassword(), user.get().getPassword())) {
            return new TokenDto(jwtProvider.createToken(user.get()));
        }

        return null;
    }

    public TokenDto validate(String token) {
        if (!jwtProvider.validate(token)) {
            return null;
        }

        String userName = jwtProvider.getUserNameFromToken(token);
        if (!authUserRepository.findByUserName(userName).isPresent()) {
            return null;
        }

        return new TokenDto(token);
    }
}
