package com.dontwait.blog.payloads.request;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class UserUpdateRequest {

    private String name;
    private String password;
    private String about;
}
