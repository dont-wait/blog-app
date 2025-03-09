package com.dontwait.blog.dto.response.category;


import lombok.Data;

@Data
public class CategoryResponse {
    private Integer categoryId;

    private String categoryTitle;

    private String categoryDescription;
}
