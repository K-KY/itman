package egovframework.itman.category.model.service;

import egovframework.itman.category.dto.CategoryDto;
import egovframework.itman.category.model.entity.Category;
import egovframework.itman.category.model.entity.CategoryFactory;
import egovframework.itman.category.model.repository.CategoryRepository;
import egovframework.itman.category.model.service.interfaces.CategoryService;
import egovframework.itman.util.dto.SortDto;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Objects;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class CategoryServiceImpl implements CategoryService {

    private final CategoryRepository categoryRepository;

    @Override
    @Transactional(readOnly = true)
    public Page<Category> read(int page, int size, Long groupSeq, SortDto sort) {
        Pageable pageable = PageRequest.of(page, size, sort.getSorts());
        return categoryRepository.findAllByEnabledTrueAndDelFalseAndGroup_GroupSeq(pageable, groupSeq);
    }

    @Override
    public Page<Category> readAll(int page, int size, Long groupSeq, SortDto sort) {
        Pageable pageable = PageRequest.of(page, size, sort.getSorts());
        return categoryRepository.findAllByDelFalseAndGroup_GroupSeq(pageable, groupSeq);
    }

    @Override
    public Optional<Category> read(String name, Long groupSeq) {
        return categoryRepository.findByCategoryNameAndGroup_GroupSeq(name, groupSeq);
    }

    @Override
    @Transactional
    public Category create(CategoryDto.Request categoryDto) {
        Category read = read(categoryDto.getName(), categoryDto.getGroupSeq()).orElse(null);
        if (read != null && Objects.equals(categoryDto.getGroupSeq(), read.getCategorySeq())) {
            throw new IllegalArgumentException("같은 이름의 분류가 존재합니다.");
        }
        Category category = CategoryFactory.toEntity(categoryDto);
        return categoryRepository.save(category);
    }

    @Override
    @Transactional
    public Category update(CategoryDto.Request categoryDto) {
        Category read = read(categoryDto.getName(), categoryDto.getGroupSeq()).orElse(null);
        if (read != null && Objects.equals(categoryDto.getGroupSeq(), read.getCategorySeq())) {
            throw new IllegalArgumentException("같은 이름의 분류가 존재합니다.");
        }

        Category category = categoryRepository.findByCategorySeq(categoryDto.getSeq());
        category.change(categoryDto);
        return category;
    }

    @Override
    public Category enable(CategoryDto.Request categoryDto) {
        Category read = read(categoryDto.getName(), categoryDto.getGroupSeq()).orElse(null);
        if (read == null) {
            throw new IllegalArgumentException("데이터를 찾을 수 없습니다");
        }
        read.changeEnable(categoryDto);
        return read;
    }

}
