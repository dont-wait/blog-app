package com.dontwait.blog.payloads.request;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class UserCreationRequest {

    private int id;
    private String name;
    private String email;
    private String password;
    private String about;
}
