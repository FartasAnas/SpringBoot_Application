package com.superjahiz.api.domain.controllers;

import com.superjahiz.api.domain.entities.Category;
import com.superjahiz.api.domain.services.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/category")
public class CategoryController {
    @Autowired
    CategoryService categoryService;

    // Post Methods
    @RequestMapping("/add")
    public void addCategory(@RequestBody Category category) {
        categoryService.addCategory(category);
    }

    // Get Methods
    @PreAuthorize("hasAuthority('USER') or hasAuthority('ADMIN')")
    @RequestMapping("/all")
    public List<Category> getAllCategories() {
        return categoryService.getAllCategories();
    }
    @PreAuthorize("hasAuthority('USER') or hasAuthority('ADMIN')")
    @RequestMapping("/{id}")
    public Category getCategoryById(@PathVariable("id") long id) {
        return categoryService.getCategoryById(id);
    }

    // Put Methods
    @RequestMapping("/edit/{id}")
    public void updateCategory(@PathVariable("id") long id, @RequestBody Category newCategory) {
        categoryService.updateCategory(id, newCategory);
    }

    // Delete Methods
    @RequestMapping("/delete/{id}")
    public void deleteCategory(@PathVariable("id") long id) {
        categoryService.deleteCategory(id);
    }

}
