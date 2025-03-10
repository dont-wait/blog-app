package com.dontwait.blog.dto.request.category;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.AccessLevel;
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
