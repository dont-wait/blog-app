package com.dontwait.blog.mapper;

import com.dontwait.blog.dto.request.category.CategoryCreationRequest;
import com.dontwait.blog.dto.request.category.CategoryUpdateRequest;
import com.dontwait.blog.dto.response.category.CategoryResponse;
import com.dontwait.blog.entity.Category;
import org.mapstruct.Mapper;
import org.mapstruct.MappingTarget;

@Mapper(componentModel = "spring")
public interface CategoryMapper {

    Category toCategory(CategoryCreationRequest request);
    CategoryResponse toCategoryResponse(Category category);
    void updateCategory(@MappingTarget Category category, CategoryUpdateRequest request);


}
