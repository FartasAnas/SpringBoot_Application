package com.superjahiz.api.domain.repositories;

import com.superjahiz.api.domain.entities.OrderLine;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderLineRepository extends JpaRepository<OrderLine, Long> {
}

