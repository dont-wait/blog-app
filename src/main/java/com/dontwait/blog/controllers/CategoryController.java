package com.dontwait.blog.controllers;

import com.dontwait.blog.dto.request.ApiResponse;
import com.dontwait.blog.dto.request.category.CategoryCreationRequest;
import com.dontwait.blog.dto.request.category.CategoryUpdateRequest;
import com.dontwait.blog.dto.response.category.CategoryResponse;
import com.dontwait.blog.entity.Category;
import com.dontwait.blog.services.CategoryService;
import com.dontwait.blog.services.UserService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/categories")
public class CategoryController {

    private final CategoryService categoryService;
    private final UserService userService;

    @Autowired
    public CategoryController(CategoryService categoryService, UserService userService) {
        this.categoryService = categoryService;
        this.userService = userService;
    }

    @GetMapping("{categoryId}")
    ApiResponse<CategoryResponse> getCategoryById(@PathVariable Integer categoryId) throws Exception {
        ApiResponse<CategoryResponse> apiResponse = new ApiResponse<>();

        apiResponse.setResult(categoryService.getCategoryById(categoryId));
        return apiResponse;
    }

    @GetMapping
    List<Category> getAllCategories() throws Exception {
        return categoryService.getCategories();
    }

    @PostMapping
    ApiResponse<CategoryResponse> createCategory(@RequestBody @Valid CategoryCreationRequest request)  {

        ApiResponse<CategoryResponse> apiResponse = new ApiResponse<>();
        apiResponse.setResult(categoryService.createCategory(request));
        return apiResponse;
    }

    @PutMapping("{categoryId}")
    ApiResponse<CategoryResponse> updateCategory(@PathVariable Integer categoryId, @RequestBody @Valid CategoryUpdateRequest request) throws Exception {
        ApiResponse<CategoryResponse> apiResponse = new ApiResponse<>();
        apiResponse.setResult(categoryService.updateCategory(categoryId, request));
        return apiResponse;
    }

    @DeleteMapping("{categoryId}")
    ApiResponse<String> deletedCategory(@PathVariable Integer categoryId)  {
        ApiResponse<String> apiResponse = new ApiResponse<>();
        categoryService.deleteCategory(categoryId);
        apiResponse.setResult("category deleted successfully");
        return apiResponse;
    }

}
