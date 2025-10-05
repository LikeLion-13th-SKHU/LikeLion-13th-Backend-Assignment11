package multipartfile.multipartfile.repository;

import multipartfile.multipartfile.entity.Image;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ImageRepository extends JpaRepository<Image, Long> {
}
