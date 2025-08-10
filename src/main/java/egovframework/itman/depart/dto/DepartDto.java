package egovframework.itman.depart.dto;

import egovframework.itman.depart.model.entity.Depart;
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

    public static Depart toEntity(DepartDto.Request request) {
        return Depart.from(request);
    }

    public static Response from(Depart depart) {
        return Response.builder()
                .seq(depart.getDepartSeq())
                .name(depart.getDepartName())
                .description(depart.getDescription())
                .enabled(depart.isEnabled())
                .createdDate(depart.getCreatedDate())
                .updatedDate(depart.getLastModifiedDate())
                .build();
    }

}
