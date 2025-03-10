package com.dontwait.blog.exception;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
//This place for BE custom error code in PROJECT include code, message Error, we dont need body JSON because that just
// Error nothing for true to save or notify for program :))
public enum ErrorCode {
    INVALID_ID_KEY(1001, "Invalid Message key, you should check your key"), //Sai sot trong dat viec dat Message tai DTO
    UNCATEGORIZED_EXCEPTION(6789, "Uncategorized Exception"),
    USER_EXISTED(1002, "User already existed"),
    NAME_INVALID(1003, "Name must be at least 3 character"),
    INVALID_PASSWORD(1004, "Password must be at least 8 characters"),
    EMAIL_EXISTED(1002, "Email already existed"),
    USERID_NOT_FOUND(1005, "User not found"),
    CATEGORYID_EXISTED(1002, "Category already existed"),
    CATEGORYTITLE_EXISTED(1002, "Category title already existed"),
    CATEGORYID_NOT_FOUND(1005, "Category not found"),
    ;
    private int code;
    private String message;

}
