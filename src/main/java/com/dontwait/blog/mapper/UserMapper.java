package com.dontwait.blog.mapper;

import com.dontwait.blog.entity.User;
import com.dontwait.blog.payloads.request.UserCreationRequest;
import com.dontwait.blog.payloads.request.UserUpdateRequest;
import com.dontwait.blog.payloads.response.UserResponse;
import org.mapstruct.Mapper;
import org.mapstruct.MappingTarget;

@Mapper(componentModel = "spring")
public interface UserMapper {

    User toUser(UserCreationRequest request);
    UserResponse toUserResponse(User user);
    void updateUser(@MappingTarget User user, UserUpdateRequest request);
}
