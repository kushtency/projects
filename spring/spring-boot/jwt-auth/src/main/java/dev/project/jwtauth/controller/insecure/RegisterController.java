package dev.project.jwtauth.controller.insecure;

import dev.project.jwtauth.dto.request.LoginRequest;
import dev.project.jwtauth.dto.request.RegisterRequest;
import dev.project.jwtauth.model.Role;
import dev.project.jwtauth.model.User;
import dev.project.jwtauth.service.UserService;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("api/auth/")
public class RegisterController {

    private final UserService userService;

    public RegisterController(UserService userService) {
        this.userService = userService;
    }

    @PostMapping("register")
    public ResponseEntity<Object> registerUser(@Valid @RequestBody RegisterRequest registerRequest){
        User user = User.builder().username(registerRequest.getUsername())
                .firstName(registerRequest.getFirstName())
                .lastName(registerRequest.getLastName())
                .password(registerRequest.getPassword())
                .role(Role.ROLE_USER)
                .email(registerRequest.getEmail()).build();
        var message = userService.createUser(user);
        if((int)message.get("status") != 1){
            return ResponseEntity.status(400).body(message);
        }
        return ResponseEntity.ok().body(message);
    }

    @PostMapping("login")
    public ResponseEntity<Object> loginUser(@Valid @RequestBody LoginRequest loginRequest){
        Map<String, Object> object = new HashMap<>();
        User u = userService.getByUsername(loginRequest.getUsername());
        if(u != null){
            String token = userService.loginUser(loginRequest, u);
            object.put("message", "user logged in successfully");
            object.put("status", 1);
            object.put("timestamp", LocalDateTime.now());
            object.put("token", token);
            return ResponseEntity.ok(object);
        }
        object.put("message", "username does not exists");
        object.put("status", 0);
        object.put("timestamp", LocalDateTime.now());
        object.put("token", null);
        return ResponseEntity.badRequest().body(object);

    }

    @GetMapping("")
    public ResponseEntity<Object> test() {
        return ResponseEntity.ok("hello");
    }
}
