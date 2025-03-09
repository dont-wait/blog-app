package com.dontwait.blog.dto.request.category;

import jakarta.persistence.Column;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.FieldDefaults;

@Data
@FieldDefaults(level = AccessLevel.PRIVATE)
@NoArgsConstructor
public class CategoryCreationRequest {


    @Size(min = 3, message = "CATEGORYTITLE_EXISTED")
    @NotNull
    String categoryTitle;

    String categoryDescription;



}
