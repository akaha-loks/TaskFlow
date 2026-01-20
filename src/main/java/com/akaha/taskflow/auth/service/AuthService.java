package com.akaha.taskflow.auth.service;

import com.akaha.taskflow.auth.dto.request.LoginRequest;
import com.akaha.taskflow.auth.exception.InvalidCredentialsException;
import com.akaha.taskflow.auth.model.User;
import com.akaha.taskflow.auth.repository.UserRepository;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class AuthService {

    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;

    public AuthService(UserRepository userRepository,  PasswordEncoder passwordEncoder) {
        this.userRepository = userRepository;
        this.passwordEncoder = passwordEncoder;
    }

    public User login(LoginRequest request){
        User user = userRepository.findByEmail(request.email()).orElseThrow(InvalidCredentialsException::new);

        if(!passwordEncoder.matches(
                request.password(),
                user.getPassword()
        )){
            throw new InvalidCredentialsException();
        }

        return user;
    }
}
