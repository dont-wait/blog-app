package com.dontwait.blog.payloads.request;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class UserCreationRequest {

    private int id;

    @Size(min = 3, message = "user name must be at least 3 characters")
    @NotNull
    private String name;

    @Email
    @NotNull
    private String email;

    @Size(min = 8, max = 20, message = "password must be at least 8 characters")
    private String password;

    private String about;
}
