package com.kimminwoo.multpartfile_assignment.image.domain.repository;

import com.kimminwoo.multpartfile_assignment.image.domain.Image;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ImageRepository extends JpaRepository<Image, Long> {
}