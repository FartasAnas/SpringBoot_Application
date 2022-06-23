package com.superjahiz.api.domain.repositories;

import com.superjahiz.api.domain.entities.UserOrder;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserOrderRepository extends JpaRepository<UserOrder, Long> {
}
