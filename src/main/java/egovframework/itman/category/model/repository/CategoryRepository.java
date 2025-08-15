package egovframework.itman.category.model.repository;

import egovframework.itman.category.model.entity.Category;
import org.springframework.data.jpa.repository.JpaRepository;


public interface CategoryRepository extends JpaRepository<Category, Long> {
    boolean existsByCategorySeq(Long categorySeq);

    Category findByCategorySeq(Long categorySeq);
}
