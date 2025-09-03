package egovframework.itman.asset.dto;

import egovframework.itman.category.dto.CategoryDto;
import lombok.*;
import java.time.LocalDateTime;

public class AssetCategoryDto {

    // 요청 DTO
    @Getter
    @NoArgsConstructor
    @AllArgsConstructor
    @Builder
    public static class Request {
        private Long assetCategorySeq;
        private CategoryDto.Request category;
        private Long assetSeq;      // Asset FK
        private String tagColor; // RGB
        private Boolean del;
    }

    // 응답 DTO
    @Getter
    @NoArgsConstructor
    @AllArgsConstructor
    @Builder
    public static class Response {
        private Long assetCategorySeq;

        private CategoryDto.Response category;

        private Boolean del;

        private LocalDateTime createdDate;
        private LocalDateTime modifiedDate;
    }
}
