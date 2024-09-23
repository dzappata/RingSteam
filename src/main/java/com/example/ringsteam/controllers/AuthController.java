package com.example.ringsteam.controllers;

import com.example.ringsteam.dto.LoginRequest;
import com.example.ringsteam.dto.LoginResponse;
import com.example.ringsteam.dto.SignupRequest;
import com.example.ringsteam.dto.SignupResponse;
import com.example.ringsteam.models.UserSteam;
import com.example.ringsteam.services.AuthService;
import com.example.ringsteam.services.JwtTokenService;
import com.example.ringsteam.services.JwtUserDetailsService;
import com.example.ringsteam.services.UserService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
public class AuthController {
    private final AuthenticationManager authenticationManager;
    private final UserService userService;
    private final AuthService authService;
    private final JwtTokenService jwtTokenService;
    private final JwtUserDetailsService jwtUserDetailsService;

    @Autowired
    public AuthController(AuthenticationManager authenticationManager, UserService userService, AuthService authService, JwtTokenService jwtTokenService, JwtUserDetailsService jwtUserDetailsService) {
        this.authenticationManager = authenticationManager;
        this.userService = userService;
        this.authService = authService;
        this.jwtTokenService = jwtTokenService;
        this.jwtUserDetailsService = jwtUserDetailsService;
    }

    @PostMapping("/register")
    public ResponseEntity<?> registerUser(@RequestBody SignupRequest signupRequest) {
        if (userService.findByUsername(signupRequest.getUsername()).isPresent()) {
            SignupResponse signupResponse = new SignupResponse("Username is already taken",409);
            return ResponseEntity.status(HttpStatus.CONFLICT).body(signupResponse);
        }
        authService.createUser(signupRequest);
        SignupResponse signupResponse = new SignupResponse("User registered successfully",201);
        return ResponseEntity.status(HttpStatus.CREATED).body(signupResponse);
    }

    @PostMapping("/login")
    public ResponseEntity<?> authenticateUser(@RequestBody @Valid final LoginRequest authenticationRequest) {
        try {
            authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(
                    authenticationRequest.getUsername(), authenticationRequest.getPassword()));
        } catch (final BadCredentialsException ex) {
            throw new ResponseStatusException(HttpStatus.UNAUTHORIZED);
        }

        final UserDetails userDetails = jwtUserDetailsService.loadUserByUsername(authenticationRequest.getUsername());
        UserSteam userLogged = userService.findByUsername(authenticationRequest.getUsername()).get();
        final LoginResponse authenticationResponse = new LoginResponse(jwtTokenService.generateToken(userDetails),userLogged.getUsername(),userLogged.getId());
        return ResponseEntity.ok(authenticationResponse);
    }

}
