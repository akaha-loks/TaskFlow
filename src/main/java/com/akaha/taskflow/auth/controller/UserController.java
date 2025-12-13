package com.akaha.taskflow.auth.controller;

import com.akaha.taskflow.auth.dto.SignupRequest;
import com.akaha.taskflow.auth.dto.UserResponse;
import com.akaha.taskflow.auth.model.User;
import com.akaha.taskflow.auth.service.UserService;
import jakarta.validation.Valid;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequestMapping("/auth")
@RestController
public class UserController {

    public static final Logger log =  LoggerFactory.getLogger(UserController.class);

    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }


    @GetMapping
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


}
