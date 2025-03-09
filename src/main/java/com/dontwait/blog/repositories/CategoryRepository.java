package com.dontwait.blog.repositories;

import com.dontwait.blog.entity.Category;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CategoryRepository extends JpaRepository<Category, Integer> {
    boolean existsByCategoryId(Integer categoryId);
    boolean existsByCategoryTitle(String title);
}
