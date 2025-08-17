package egovframework.itman.image.model.repository;

import egovframework.itman.image.model.entity.ImageFile;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface ImageRepository extends JpaRepository<ImageFile, Long> {
    Optional<ImageFile> findByImageSeq(String imageSeq);
}
