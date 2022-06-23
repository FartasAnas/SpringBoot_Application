package com.superjahiz.api.domain.repositories;

import com.superjahiz.api.domain.entities.Category;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CategoryRepository extends JpaRepository<Category, Long> {

}
