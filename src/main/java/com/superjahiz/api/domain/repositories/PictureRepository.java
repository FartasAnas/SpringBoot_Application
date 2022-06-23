package com.superjahiz.api.domain.repositories;

import com.superjahiz.api.domain.entities.Picture;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PictureRepository extends JpaRepository<Picture, Long> {
}
