package com.example.transactions.service;

import com.example.transactions.dto.CategoryDTO;
import com.example.transactions.model.Category;
import com.example.transactions.response.CategoryResponse;
import com.example.transactions.response.Response;

public interface CategoryService {

    Response<Category> getAllCategories();

    CategoryResponse getCategoryById(long category_id);

    Response<Category> addCategory(Category category);

    CategoryResponse updateCategory(CategoryDTO category);

    Response<Category> deleteCategory(long category_id);
}
