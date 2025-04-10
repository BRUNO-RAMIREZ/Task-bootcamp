package com.dhasset.auth_service.controller;

import com.dhasset.auth_service.api.request.AuthUserRequest;
import com.dhasset.auth_service.api.TokenDto;
import com.dhasset.auth_service.model.Constants;
import com.dhasset.auth_service.model.domain.AuthUser;
import com.dhasset.auth_service.service.AuthUserService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Objects;

/**
 * Bruno Ramirez
 **/
@RestController
@RequestMapping(Constants.BasePath.AUTH)
public class AuthUserController {

    private final AuthUserService authUserService;

    public AuthUserController(AuthUserService authUserService) {
        this.authUserService = authUserService;
    }

    @PostMapping("/login")
    public ResponseEntity<TokenDto> login(@RequestBody AuthUserRequest authUserRequest) {
        TokenDto tokenDto = authUserService.login(authUserRequest);
        if (Objects.isNull(tokenDto)) {
            return ResponseEntity.badRequest().build();
        }

        return ResponseEntity.ok(tokenDto);
    }

    @PostMapping("/validate")
    public ResponseEntity<TokenDto> validate(@RequestParam String token) {
        TokenDto tokenDto = authUserService.validate(token);
        if (Objects.isNull(tokenDto)) {
            return ResponseEntity.badRequest().build();
        }

        return ResponseEntity.ok(tokenDto);
    }

    @PostMapping("/create")
    public ResponseEntity<AuthUser> create(@RequestBody AuthUserRequest authUserRequest) {
        AuthUser authUser = authUserService.save((authUserRequest));
        if (Objects.isNull(authUser)) {
            return ResponseEntity.badRequest().build();
        }

        return ResponseEntity.ok(authUser);
    }
}
