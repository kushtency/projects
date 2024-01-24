package dev.project.jwtauth.dto.request;

import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Builder
@Data
public class LoginRequest {
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
}
