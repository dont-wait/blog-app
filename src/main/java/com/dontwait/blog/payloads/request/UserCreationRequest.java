package com.dontwait.blog.payloads.request;

import com.dontwait.blog.exception.ErrorCode;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class UserCreationRequest {

    private int id;

    @Size(min = 3, message = "NAME_INVALID")
    @NotNull
    private String name;

    @Email
    @NotNull
    private String email;

    @Size(min = 8, message = "INVALID_PASSWORD")
    private String password;

    private String about;
}
