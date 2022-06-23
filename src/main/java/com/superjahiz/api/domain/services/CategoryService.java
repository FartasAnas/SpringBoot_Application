package com.superjahiz.api.domain.services;

import com.superjahiz.api.domain.entities.Category;
import com.superjahiz.api.domain.repositories.CategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CategoryService {
    @Autowired
    private CategoryRepository categoryRepository;

    // Post Methods
    public void addCategory(Category category) {
        categoryRepository.save(category);
    }

    // Get Methods
    public List<Category> getAllCategories() {
        return categoryRepository.findAll();
    }
    public Category getCategoryById(Long id) {
        return categoryRepository.findById(id).get();
    }

    // Put Methods
    public void updateCategory(Long id, Category newCategory) {
        Category categoryToUpdate = categoryRepository.findById(id).get();
        categoryToUpdate.setName(newCategory.getName()!=null ? newCategory.getName() : categoryToUpdate.getName());
        categoryToUpdate.setPictureUrl(newCategory.getPictureUrl()!=null ? newCategory.getPictureUrl() : categoryToUpdate.getPictureUrl());
        categoryRepository.save(categoryToUpdate);
    }

    // Delete Methods
    public void deleteCategory(Long id) {
        categoryRepository.deleteById(id);
    }
}
