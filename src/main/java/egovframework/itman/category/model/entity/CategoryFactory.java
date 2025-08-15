package egovframework.itman.category.model.entity;

import egovframework.itman.category.dto.CategoryDto;
import egovframework.itman.group.model.entity.ManageGroupFactory;

import java.util.Optional;

public class CategoryFactory {
    public static Category toEntity(CategoryDto.Request dto) {
        return Category.builder()
                .categorySeq(dto.getCategorySeq())
                .categoryName(dto.getCategoryName())
                .group(ManageGroupFactory.toCompactEntity(dto.getGroupSeq()))
                .tagColor(dto.getTagColor())
                .enabled(Optional.ofNullable(dto.getEnabled()).orElse(true))
                .del(Optional.ofNullable(dto.getDel()).orElse(false))
                .build();
    }

    public static CategoryDto.Response toDto(Category category) {
        return CategoryDto.Response.builder()
                .categorySeq(category.getCategorySeq())
                .categoryName(category.getCategoryName())
                .tagColor(category.getTagColor())
                .enabled(category.getEnabled())
                .del(category.getDel())
                .createdDate(category.getCreatedDate())
                .modifiedDate(category.getLastModifiedDate())
                .build();
    }

    public static Category toCompactEntity(Long categorySeq) {
        return Category.builder()
                .categorySeq(categorySeq)
                .build();
    }
}
