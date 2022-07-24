package com.instacodeApp.use_cases.user.exposition;

import lombok.Data;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;

@Data
public class UserDto {
    public Long id;

    @NotEmpty(message = "username should not be null or empty")
    public String username;

    @NotEmpty(message = "email should not be null or empty")
    @Email
    public String email;

    @NotEmpty(message = "password should not be null or empty")
    public String password;

}
