package com.superjahiz.api.domain.controllers;

import com.superjahiz.api.domain.entities.Product;
import com.superjahiz.api.domain.services.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/product")
@PreAuthorize("hasAuthority('ADMIN')")
public class ProductController {
    @Autowired
    private ProductService productService;

    // Post Methods
    @RequestMapping("/add")
    public void addProduct(@RequestBody Product product) {
        productService.addProduct(product);
    }

    // Get Methods
    @PreAuthorize("hasAuthority('USER') or hasAuthority('ADMIN')")
    @RequestMapping("/all")
    public List<Product> getAllProducts() {
        return productService.getAllProducts();
    }
    @RequestMapping("/{id}")
    @PreAuthorize("hasAuthority('USER') or hasAuthority('ADMIN')")
    public Product getProductById(@PathVariable("id") long id) {
        return productService.getProductById(id);
    }

    // Put Methods
    @RequestMapping("/edit/{id}")
    public void updateProduct(@PathVariable("id") long id, @RequestBody Product newProduct) {
        productService.updateProduct(id, newProduct);
    }

    // Delete Methods
    @RequestMapping("/delete/{id}")
    public void deleteProduct(@PathVariable("id") long id) {
        productService.deleteProduct(id);
    }

}
