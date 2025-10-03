package com.likelion.multipart_prac.image.domain.repository;

import com.likelion.multipart_prac.image.domain.Image;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ImageRepository extends JpaRepository<Image, Long> {
}