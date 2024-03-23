package com.marvel.MarvelAPI.Security.Controller;

import com.marvel.MarvelAPI.Security.Persistence.Entity.AuthenticationResponse;
import com.marvel.MarvelAPI.Security.Persistence.Entity.UserEntity;
import com.marvel.MarvelAPI.Security.Service.AuthenticationService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AuthenticationController {

    private final AuthenticationService authService;


    public AuthenticationController(AuthenticationService authService) {
        this.authService = authService;
    }


    @PostMapping("/register")
    public ResponseEntity<AuthenticationResponse> register(
            @RequestBody UserEntity request
    ) {
        return ResponseEntity.ok(authService.register(request));
    }

    @PostMapping("/login")
    public ResponseEntity<AuthenticationResponse> login(
            @RequestBody UserEntity request
    ) {
        return ResponseEntity.ok(authService.authenticate(request));
    }
}
