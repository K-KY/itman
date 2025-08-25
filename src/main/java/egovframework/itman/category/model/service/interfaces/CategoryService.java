package egovframework.itman.category.model.service.interfaces;

import egovframework.itman.category.dto.CategoryDto;
import egovframework.itman.category.model.entity.Category;
import egovframework.itman.util.dto.SortDto;
import org.springframework.data.domain.Page;

import java.util.Optional;

public interface CategoryService {
    Page<Category> read(int page, int size, Long groupSeq, SortDto sort);
    Page<Category> readAll(int page, int size, Long groupSeq, SortDto sort);

    Optional<Category> read(String name, Long groupSeq);//분류 중복 처리용

    Category create(CategoryDto.Request categoryDto);

    Category update(CategoryDto.Request categoryDto);

    Category enable(CategoryDto.Request categoryDto);

    Page<Category> read(int page, int size, Long groupSeq, String keyword, SortDto sort);
}
