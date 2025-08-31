package egovframework.itman.category.controller;

import egovframework.itman.category.dto.CategoryDto;
import egovframework.itman.category.model.entity.CategoryFactory;
import egovframework.itman.category.model.service.interfaces.CategoryService;
import egovframework.itman.user.model.entity.User;
import egovframework.itman.util.dto.SortDto;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.*;

@RequiredArgsConstructor
@RestController
@RequestMapping("categories")
public class CategoryController {

    private final CategoryService categoryService;

    @GetMapping
    public Page<CategoryDto.Response> read(int page, int size, Long groupSeq, SortDto sort) {
        return categoryService.read(page - 1, size, groupSeq, sort).map(CategoryFactory::toDto);
    }

    @GetMapping("/keyword")
    public Page<CategoryDto.Response> read(int page, int size, Long groupSeq, String keyword, SortDto sort) {
        return categoryService.read(page, size, groupSeq, keyword, sort).map(CategoryFactory::toDto);
    }

    @GetMapping("/all")
    public Page<CategoryDto.Response> readAll(int page, int size, Long groupSeq, SortDto sort) {
        return categoryService.read(page - 1, size, groupSeq, sort).map(CategoryFactory::toDto);
    }

    @PostMapping
    public CategoryDto.Response create(@RequestBody CategoryDto.Request categoryDto) {
        return CategoryFactory.toDto(categoryService.create(categoryDto));
    }

    @PatchMapping
    public CategoryDto.Response update(@RequestBody CategoryDto.Request categoryDto) {
        return CategoryFactory.toDto(categoryService.update(categoryDto));
    }

    @PostMapping("enable")
    public CategoryDto.Response enable(@RequestBody CategoryDto.Request categoryDto) {
        return CategoryFactory.toDto(categoryService.enable(categoryDto));
    }

    @GetMapping("count")
    public Long count(@AuthenticationPrincipal User user, Long groupSeq) {
        return 0L;
    }

    @GetMapping("count/{del}")
    public Long count(@AuthenticationPrincipal User user, Long groupSeq, @PathVariable Boolean del) {
        return 0L;
    }
}
