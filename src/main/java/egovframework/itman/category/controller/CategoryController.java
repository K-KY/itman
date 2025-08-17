package egovframework.itman.category.controller;

import egovframework.itman.category.dto.CategoryDto;
import egovframework.itman.category.model.entity.CategoryFactory;
import egovframework.itman.category.model.service.interfaces.CategoryService;
import egovframework.itman.util.dto.SortDto;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.*;

@RequiredArgsConstructor
@RestController
@RequestMapping("categories")
public class CategoryController {

    private final CategoryService categoryService;

    @GetMapping
    public Page<CategoryDto.Response> read(int page, int size, Long groupSeq, SortDto sort) {
        return categoryService.read(page, size, groupSeq, sort).map(CategoryFactory::toDto);
    }

    @PostMapping
    public CategoryDto.Response create(@RequestBody CategoryDto.Request categoryDto) {
        return CategoryFactory.toDto(categoryService.create(categoryDto));
    }

    @PatchMapping
    public CategoryDto.Response update(@RequestBody CategoryDto.Request categoryDto) {
        return CategoryFactory.toDto(categoryService.update(categoryDto));
    }
}
