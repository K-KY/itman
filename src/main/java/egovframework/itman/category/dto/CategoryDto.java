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
    @ToString
    public static class Request {
        private Long seq;
        private String name;
        private String description;
        private Boolean del;
        private Boolean enabled;
        private Long groupSeq;
    }

    // 📌 응답 DTO
    @Getter
    @Setter
    @NoArgsConstructor
    @AllArgsConstructor
    @Builder
    public static class Response {
        private Long seq;
        private String name;
        private String description;
        private Boolean del;
        private Boolean enabled;
        private Long groupSeq;

        private LocalDateTime createdDate;
        private LocalDateTime modifiedDate;
    }
}
