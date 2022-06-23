package com.superjahiz.api.domain.repositories;

import com.superjahiz.api.domain.entities.AppUser;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AppUserRepository extends JpaRepository<AppUser, Long> {

}
