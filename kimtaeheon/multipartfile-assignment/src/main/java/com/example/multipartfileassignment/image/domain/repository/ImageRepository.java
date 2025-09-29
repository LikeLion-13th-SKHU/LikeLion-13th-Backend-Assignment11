package com.example.multipartfileassignment.image.domain.repository;

import com.example.multipartfileassignment.image.domain.Image;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ImageRepository extends JpaRepository<Image, Long> {
}
