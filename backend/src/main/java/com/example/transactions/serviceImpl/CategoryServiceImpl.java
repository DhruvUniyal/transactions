package com.example.transactions.serviceImpl;

import com.example.transactions.dto.CategoryDTO;
import com.example.transactions.model.Category;
import com.example.transactions.repository.CategoryRepository;
import com.example.transactions.response.CategoryResponse;
import com.example.transactions.response.Response;
import com.example.transactions.service.CategoryService;
import com.example.transactions.utils.constants.Constants;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class CategoryServiceImpl implements CategoryService {

    @Autowired
    private CategoryRepository categoryRepository;

    public Response<Category> getAllCategories() {
        Response<Category> category = new Response<Category>();
        try{
            Iterable<Category> response = this.categoryRepository.findAll();
            if(!response.iterator().hasNext()) throw new Exception(Constants.EMPTY_RESULT_RETURNED);
            List<Category> categoryList = new ArrayList<Category>();
            response.forEach(categoryList::add);
            if(categoryList.isEmpty()) throw new Exception(Constants.ERROR_RETURNING_DATA);
            category.setStatus_code(Constants.HTTP_OK_CODE);
            category.setStatus_message(Constants.SUCCESS_MESSAGE);
            category.setResponse(categoryList);
        } catch(Exception e){
            category.setStatus_code(Constants.HTTP_ERROR_CODE);
            category.setStatus_message(e.getMessage());
        }
        return category;
    }

    public CategoryResponse getCategoryById(long category_id) {
        CategoryResponse category = new CategoryResponse();
        try {
            Optional<Category> response = this.categoryRepository.findById(category_id);
            if(response.isEmpty()) throw new Exception(Constants.EMPTY_RESULT_RETURNED);
            category.setStatus_message(Constants.SUCCESS_MESSAGE);
            category.setStatus_code(Constants.HTTP_OK_CODE);
            category.setResponse(response.get());
        } catch (Exception e){
            category.setStatus_code(Constants.HTTP_ERROR_CODE);
            category.setStatus_message(e.getMessage());
        }
        return category;
    }

    public Response<Category> addCategory(Category category) {
        return null;
    }

    public CategoryResponse updateCategory(CategoryDTO category) {
        return null;
    }

    public Response<Category> deleteCategory(long category_id) {
        return null;
    }
}
