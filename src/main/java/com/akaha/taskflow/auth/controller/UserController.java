package com.akaha.taskflow.auth.controller;

import com.akaha.taskflow.auth.dto.request.LoginRequest;
import com.akaha.taskflow.auth.dto.request.SignupRequest;
import com.akaha.taskflow.auth.dto.response.LoginResponse;
import com.akaha.taskflow.auth.dto.response.UserResponse;
import com.akaha.taskflow.auth.model.User;
import com.akaha.taskflow.auth.service.AuthService;
import com.akaha.taskflow.auth.security.JwtService;
import com.akaha.taskflow.auth.service.UserService;
import jakarta.validation.Valid;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequestMapping("/api/auth")
@RestController
public class UserController {

    public static final Logger log =  LoggerFactory.getLogger(UserController.class);

    private final UserService userService;
    private final AuthService authService;
    private final JwtService jwtService;

    public UserController(UserService userService, AuthService authService, JwtService jwtService) {
        this.userService = userService;
        this.authService = authService;
        this.jwtService = jwtService;
    }


    @GetMapping("/users")
    public ResponseEntity<List<UserResponse>> getAllUsers() {
        List<UserResponse> users = userService.findAllUsers()
                .stream()
                .map(UserResponse::from)
                .toList();
        return ResponseEntity.ok(users);
    }

    @PostMapping("/sign-up")
    public ResponseEntity<UserResponse> signUp(@Valid @RequestBody SignupRequest request){
        try {
            log.info(request.username() + " sign-up");
            User user = userService.signUp(request);
            return ResponseEntity.status(HttpStatus.CREATED).body(UserResponse.from(user));
        }catch (Exception e){
            log.error("Sign up failed {}", e.getMessage());
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }

    @PostMapping("/login")
    public ResponseEntity<LoginResponse> login(@Valid @RequestBody LoginRequest request){
        try {
            log.info(request.email() + " sign-in");
            User user = authService.login(request);
            String token = jwtService.generateToken(user);
            return ResponseEntity.status(HttpStatus.OK).body(LoginResponse.from(user, token));
        }catch (Exception e){
            log.error("Login failed {}", e.getMessage());
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }
}
