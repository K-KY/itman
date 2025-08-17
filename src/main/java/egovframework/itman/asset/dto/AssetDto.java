package egovframework.itman.asset.dto;

import lombok.*;
import javax.validation.constraints.NotNull;
import java.time.LocalDate;
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
        private String imageUrl;
        @NotNull
        private Long groupSeq; // ManageGroup FK
        private String location;
        private LocalDate acqDate;
        private Boolean enabled;
        private Boolean del;

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
        private String imageUrl;
        private String assetName;
        private String location;
        private Boolean enabled;
        private Boolean del;
        // 카테고리 목록 포함
        private List<AssetCategoryDto.Response> categories;

        private LocalDate acqDate;
        private LocalDateTime createdDate;
        private LocalDateTime modifiedDate;
    }
}
