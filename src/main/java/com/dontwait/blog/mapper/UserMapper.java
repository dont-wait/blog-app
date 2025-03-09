package com.dontwait.blog.mapper;

import com.dontwait.blog.entity.User;
import com.dontwait.blog.dto.request.user.UserCreationRequest;
import com.dontwait.blog.dto.request.user.UserUpdateRequest;
import com.dontwait.blog.dto.response.user.UserResponse;
import org.mapstruct.Mapper;
import org.mapstruct.MappingTarget;

@Mapper(componentModel = "spring")
public interface UserMapper {

    User toUser(UserCreationRequest request);
    UserResponse toUserResponse(User user);
    void updateUser(@MappingTarget User user, UserUpdateRequest request);
}
