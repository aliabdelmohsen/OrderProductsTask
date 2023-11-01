package com.qeema.shopping.request.auth;

import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class AuthenticationRequest {
@NotBlank(message = "email field is required")
    private String email;
    @NotBlank(message = "password field is required")
    private String password;
}
