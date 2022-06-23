package com.superjahiz.api.domain.repositories;

import com.superjahiz.api.domain.entities.Spec;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SpecRepository extends JpaRepository<Spec, Long> {
}
