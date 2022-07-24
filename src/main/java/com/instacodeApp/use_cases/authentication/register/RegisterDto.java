package com.instacodeApp.use_cases.authentication.register;

import lombok.Data;

@Data
public class RegisterDto {
    public String username;
    public String email;
    public String password;
}
