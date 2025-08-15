package egovframework.itman.asset.dto;

import lombok.*;
import java.time.LocalDateTime;
import java.util.List;

public class AssetDto {

    // 📌 요청 DTO
    @Getter
    @NoArgsConstructor
    @AllArgsConstructor
    @Builder
    public static class Request {
        private Long assetSeq;
        private String serialNumber;
        private String assetName;
        private Long groupSeq; // ManageGroup FK
        private String location;
        private LocalDateTime acqDate;
        private Boolean enabled;

        // 카테고리 여러 개 추가 가능
        private List<AssetCategoryDto.Request> categories;
    }

    // 📌 응답 DTO
    @Getter
    @NoArgsConstructor
    @AllArgsConstructor
    @Builder
    public static class Response {
        private Long assetSeq;
        private String serialNumber;
        private String assetName;
        private String location;
        private Boolean enabled;
        // 카테고리 목록 포함
        private List<AssetCategoryDto.Response> categories;

        private LocalDateTime acqDate;
        private LocalDateTime createdDate;
        private LocalDateTime modifiedDate;
    }
}
