package com.ashraf.blog.service;

import com.ashraf.blog.payloads.CategoryDto;

import java.util.List;

public interface CategoryService {

    //create
    CategoryDto createCategory(CategoryDto categoryDto);

    //update
    CategoryDto updateCategory(CategoryDto categoryDto, Integer categoryId);

    //delete
    void deleteCategory(Integer categoryId);

    // get
    CategoryDto getCategoryById(Integer categoryId);

    List<CategoryDto> getAllCategory();
}
