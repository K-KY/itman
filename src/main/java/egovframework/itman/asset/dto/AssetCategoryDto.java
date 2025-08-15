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
        private Long categorySeq;   // Category FK
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

//        private Long categorySeq;
//        private String categoryNameFromEntity; // Category 엔티티에서 가져올 이름
//        private String categoryName; // AssetCategory 자체에 저장된 이름
//        private String tagColor;
        private CategoryDto.Response category;

        //
//        private Long assetSeq;
//        private String assetName;

        private Boolean del;

        private LocalDateTime createdDate;
        private LocalDateTime modifiedDate;
    }
}
