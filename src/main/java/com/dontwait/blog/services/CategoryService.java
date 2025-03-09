package com.dontwait.blog.services;


import com.dontwait.blog.dto.request.category.CategoryCreationRequest;
import com.dontwait.blog.dto.request.category.CategoryUpdateRequest;
import com.dontwait.blog.dto.request.user.UserCreationRequest;
import com.dontwait.blog.dto.request.user.UserUpdateRequest;
import com.dontwait.blog.dto.response.category.CategoryResponse;
import com.dontwait.blog.dto.response.user.UserResponse;
import com.dontwait.blog.entity.Category;
import com.dontwait.blog.entity.User;

import java.util.List;

public interface CategoryService {
    CategoryResponse createCategory(CategoryCreationRequest request);
    CategoryResponse updateCategory(Integer categoryId, CategoryUpdateRequest request);
    CategoryResponse getCategoryById(Integer categoryId) throws Exception;
    List<Category> getCategories();
    void deleteCategory(Integer categoryId);
}
