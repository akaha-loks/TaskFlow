package com.akaha.taskflow.auth.service;

import com.akaha.taskflow.auth.dto.SignupRequest;
import com.akaha.taskflow.auth.exception.EmailAlreadyExistsException;
import com.akaha.taskflow.auth.exception.UsernameAlreadyExistsException;
import com.akaha.taskflow.auth.model.User;
import com.akaha.taskflow.auth.repository.UserRepository;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {

    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;

    public UserService(UserRepository userRepository,  PasswordEncoder passwordEncoder) {
        this.userRepository = userRepository;
        this.passwordEncoder = passwordEncoder;
    }


    public List<User> findAllUsers() {
        return userRepository.findAll();
    }

    public User signUp(SignupRequest request) {
        if(userRepository.existsByEmail(request.email())){
            throw new EmailAlreadyExistsException();
        }

        if(userRepository.existsByUsername(request.username())){
            throw new UsernameAlreadyExistsException();
        }

        User user = new User();
        user.setEmail(request.email());
        user.setUsername(request.username());
        user.setPassword(passwordEncoder.encode(request.password()));

        return userRepository.save(user);
    }
}
