package com.dontwait.blog.payloads.request;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.Setter;
import lombok.experimental.FieldDefaults;

@Getter
@Setter
@FieldDefaults(level = AccessLevel.PRIVATE)
public class UserCreationRequest {

    //id - ko dc chinh id =))


    @Size(min = 3, message = "NAME_INVALID")
    @NotNull
    String name;

    @Email
    @NotNull(message = "EMAIL_INVALID")
    String email;

    @Size(min = 8, message = "INVALID_PASSWORD")
    String password;

    String about;
}
