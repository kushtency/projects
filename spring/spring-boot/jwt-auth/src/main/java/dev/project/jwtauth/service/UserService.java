package dev.project.jwtauth.service;

import dev.project.jwtauth.dto.request.LoginRequest;
import dev.project.jwtauth.model.User;
import dev.project.jwtauth.repository.UserRepository;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.Map;

@Service
public class UserService {

    private final PasswordEncoder passwordEncoder;
    private final UserRepository userRepository;
    private final AuthenticationManager authenticationManager;
    private  final JwtService jwtService;

    public UserService(
            UserRepository userRepository,
            PasswordEncoder passwordEncoder,
            AuthenticationManager authenticationManager,
            JwtService jwtService
    ) {
        this.userRepository = userRepository;
        this.passwordEncoder = passwordEncoder;
        this.authenticationManager = authenticationManager;
        this.jwtService = jwtService;
    }

    public User getByUsername(String username) {
        return userRepository.findByUsername(username);
    }

    public Map<String, Object> createUser(User user) {
        Map<String, Object> object = new HashMap<>();
        try {
            if(user != null) {
                userRepository.save(user);
                object.put("message", "register successfully");
                object.put("status", 1);
                object.put("timestamp", LocalDateTime.now());
            }
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("error while saving the user");
            object.put("message", "user already exist or invalid input");
            object.put("status", 0);
            object.put("timestamp", LocalDateTime.now());
        }
        return object;
    }

    public String loginUser(LoginRequest loginRequest, User user) {
        authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(
                        loginRequest.getUsername(),
                        loginRequest.getPassword()
                )
        );
        return jwtService.generateToken(user);
    }
}
