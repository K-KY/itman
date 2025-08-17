package egovframework.itman.category.model.repository;

import egovframework.itman.category.model.entity.Category;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;


public interface CategoryRepository extends JpaRepository<Category, Long> {
    boolean existsByCategorySeq(Long categorySeq);

    Category findByCategorySeq(Long categorySeq);

    Page<Category> findAllByEnabledTrueAndDelFalseAndGroup_GroupSeq(Pageable pageable, Long groupSeq);

    Category findByCategoryName(String categoryName);

    Optional<Category> findByCategoryNameAndGroup_GroupSeq(String categoryName, Long groupGroupSeq);
}
