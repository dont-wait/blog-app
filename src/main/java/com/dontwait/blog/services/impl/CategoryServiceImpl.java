package com.dontwait.blog.services.impl;

import com.dontwait.blog.dto.request.category.CategoryCreationRequest;
import com.dontwait.blog.dto.request.category.CategoryUpdateRequest;
import com.dontwait.blog.dto.response.category.CategoryResponse;
import com.dontwait.blog.entity.Category;
import com.dontwait.blog.exception.AppException;
import com.dontwait.blog.exception.ErrorCode;
import com.dontwait.blog.mapper.CategoryMapper;
import com.dontwait.blog.repositories.CategoryRepository;
import com.dontwait.blog.services.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CategoryServiceImpl implements CategoryService {

    private final CategoryRepository categoryRepository;
    private final CategoryMapper categoryMapper;

    @Autowired
    public CategoryServiceImpl(CategoryRepository categoryRepository, CategoryMapper categoryMapper) {
        this.categoryRepository = categoryRepository;
        this.categoryMapper = categoryMapper;
    }

    @Override
    public CategoryResponse createCategory(CategoryCreationRequest request) {

        if(categoryRepository.existsByCategoryTitle(request.getCategoryTitle())) {
            throw new AppException(ErrorCode.CATEGORYTITLE_EXISTED);
        }

        Category category = categoryMapper.toCategory(request);
        return categoryMapper.toCategoryResponse(categoryRepository.save(category));

    }

    @Override
    public CategoryResponse updateCategory(Integer categoryId, CategoryUpdateRequest request) {
        Category category = categoryRepository.findById(categoryId).orElseThrow(() -> new AppException(ErrorCode.CATEGORYID_NOT_FOUND));
        categoryMapper.updateCategory(category, request);
        return categoryMapper.toCategoryResponse(categoryRepository.save(category));
    }

    @Override
    public CategoryResponse getCategoryById(Integer categoryId) throws Exception {
        return categoryMapper.toCategoryResponse(categoryRepository.findById(categoryId).orElseThrow(() -> new AppException(ErrorCode.CATEGORYID_NOT_FOUND)));
    }

    @Override
    public List<Category> getCategories() {
        return categoryRepository.findAll();
    }

    @Override
    public void deleteCategory(Integer categoryId) {
        categoryRepository.deleteById(categoryId);
    }
}
