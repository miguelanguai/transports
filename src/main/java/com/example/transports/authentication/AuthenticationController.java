package com.example.transports.authentication;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.transports.user.model.DriverEntity;

@RestController
public class AuthenticationController {

    private final AuthenticationService authService;

    public AuthenticationController(AuthenticationService authService) {
        this.authService = authService;
    }

    /**
     * Registers a {@link UserEntity} on the application
     * 
     * @param request
     * @return {@link AuthenticationResponse} and ok body.
     */
    @PostMapping("/register")
    public ResponseEntity<AuthenticationResponse> register(@RequestBody DriverEntity request) {
        return ResponseEntity.ok(authService.register(request));
    }

    /**
     * Logins on the application with a {@link UserEntity} username and password
     * 
     * @param request
     * @return {@link AuthenticationResponse} and ok body.
     */
    @PostMapping("/login")
    public ResponseEntity<AuthenticationResponse> login(@RequestBody DriverEntity request) {
        return ResponseEntity.ok(authService.authenticate(request));
    }

    /**
     * Makes the token no longer work for the {@link UserEntity}
     * 
     * @param signOutRequest
     * @return {@link AuthenticationResponse} to null and ok body.
     */
    @PostMapping("/user/signout")
    public ResponseEntity<AuthenticationResponse> signOut(@RequestBody DriverEntity signOutRequest) throws Exception {
        return ResponseEntity.ok(authService.signOut(signOutRequest));
    }
}
