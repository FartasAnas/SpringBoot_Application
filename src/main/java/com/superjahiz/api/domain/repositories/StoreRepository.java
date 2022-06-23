package com.superjahiz.api.domain.repositories;

import com.superjahiz.api.domain.entities.Store;
import org.springframework.data.jpa.repository.JpaRepository;

public interface StoreRepository extends JpaRepository<Store, Long> {
}
