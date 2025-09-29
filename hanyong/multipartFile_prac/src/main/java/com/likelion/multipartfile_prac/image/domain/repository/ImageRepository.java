package com.likelion.multipartfile_prac.image.domain.repository;

import com.likelion.multipartfile_prac.image.domain.Image;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ImageRepository extends JpaRepository<Image, Long> {
}
