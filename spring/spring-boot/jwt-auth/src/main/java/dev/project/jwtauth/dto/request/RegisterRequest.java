package dev.project.jwtauth.dto.request;

import jakarta.validation.constraints.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Builder
public class RegisterRequest {
    @NotBlank(message = "username should not be blank")
    @Min(value = 8, message = "username should have at least 8 characters")
    @Max(value = 32, message = "username should have at most 32 characters")
    @Pattern(regexp = "^[A-Za-z0-9._]+$", message = "invalid username")
    private String username;
    @NotBlank(message = "password should not be blank")
    @Min(value = 8, message = "password should have at least 8 character")
    @Max(value = 32, message = "password should have at most 32 characters")
    @Pattern(regexp = "^[A-Za-z0-9._@$#]+$", message = "invalid password")
    private String password;
    @NotBlank(message = "name should not be blank")
    @Min(value = 5, message = "name should have at least 5 character")
    @Pattern(regexp = "^[A-Za-z]+$", message = "invalid name")
    private String firstName;
    @NotBlank(message = "lastname should not be blank")
    @Min(value = 5, message = "lastname should have at least 5 character")
    @Pattern(regexp = "^[A-Za-z]+$", message = "invalid lastname")
    private String lastName;
    @NotBlank(message = "email should not be blank")
    @Email(regexp = "^[a-zA-Z0-9_+&*-]+(?:\\.[a-zA-Z0-9_+&*-]+)*@(?:[a-zA-Z0-9-]+\\.)+[a-zA-Z]{2,7}$",
            message = "invalid email address")
    private String email;
}
