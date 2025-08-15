package egovframework.itman.category.dto;

import lombok.*;
import java.time.LocalDateTime;

public class CategoryDto {

    // 📌 요청 DTO
    @Getter
    @Setter
    @NoArgsConstructor
    @AllArgsConstructor
    @Builder
    public static class Request {
        private Long categorySeq;
        private String categoryName;
        private String tagColor; //RGB
        private Boolean enabled;
        private Boolean del;
        private Long groupSeq;
    }

    // 📌 응답 DTO
    @Getter
    @Setter
    @NoArgsConstructor
    @AllArgsConstructor
    @Builder
    public static class Response {
        private Long categorySeq;
        private String categoryName;
        private String tagColor; //RGB
        private Boolean enabled;
        private Boolean del;

        private LocalDateTime createdDate;
        private LocalDateTime modifiedDate;
    }
}
