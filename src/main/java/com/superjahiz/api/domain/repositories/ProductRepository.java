package com.superjahiz.api.domain.repositories;

import com.superjahiz.api.domain.entities.Product;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductRepository extends JpaRepository<Product, Long> {

}
