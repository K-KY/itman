package egovframework.itman.depart.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

public class DepartDto {

    @Getter
    @AllArgsConstructor
    @NoArgsConstructor
    @Builder
    public static class Request {
        private int seq;
        private String name;
        private String description;
        private Boolean del;
        private Boolean enabled;
        private Long groupSeq;
        private LocalDateTime createdDate;
        private LocalDateTime updatedDate;
    }

    @Getter
    @Builder
    public static class Response {
        private int seq;
        private String name;
        private String description;
        private boolean del;
        private boolean enabled;
        private LocalDateTime createdDate;
        private LocalDateTime updatedDate;
    }

    public static DepartDto.Response.ResponseBuilder getResponse() {
        return new DepartDto.Response.ResponseBuilder();
    }
}
