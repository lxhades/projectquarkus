package org.acme.dto.request;

import jakarta.validation.constraints.NotBlank;

public class LoginRequest {
    @NotBlank
    public String msv;
    @NotBlank
    public String password;
}
