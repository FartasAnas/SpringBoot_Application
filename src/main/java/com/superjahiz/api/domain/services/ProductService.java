package com.superjahiz.api.domain.services;

import com.superjahiz.api.domain.entities.Product;
import com.superjahiz.api.domain.repositories.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductService {
    @Autowired
    private ProductRepository productRepository;


    // Post Methods
    public void addProduct(Product product) {
        productRepository.save(product);
    }

    // Get Methods
    public List<Product> getAllProducts() {
        return productRepository.findAll();
    }
    public Product getProductById(Long id) {
        return productRepository.findById(id).get();
    }

    // Put Methods
    public void updateProduct(Long id, Product newProduct) {
        Product productToUpdate = productRepository.findById(id).get();
        productToUpdate.setName(newProduct.getName()!=null ? newProduct.getName() : productToUpdate.getName());
        productToUpdate.setDescription(newProduct.getDescription()!=null ? newProduct.getDescription() : productToUpdate.getDescription());
        productToUpdate.setPrice(newProduct.getPrice());
        productToUpdate.setInStock(newProduct.getInStock());
        productToUpdate.setSold(newProduct.getSold());
        productRepository.save(productToUpdate);
    }

    // Delete Methods
    public void deleteProduct(Long id) {
        productRepository.deleteById(id);
    }
}
