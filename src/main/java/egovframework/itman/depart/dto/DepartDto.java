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
        private int departSeq;
        private String departName;
        private String description;
        private LocalDateTime createdDate;
        private LocalDateTime updatedDate;
    }

    @Getter
    @Builder
    public static class Response {
        private int departSeq;
        private String departName;
        private String description;
        private boolean del;
        private LocalDateTime createdDate;
        private LocalDateTime updatedDate;

        public static Response from(Depart depart) {
            return Response.builder()
                    .departSeq(depart.getDepartSeq())
                    .departName(depart.getDepartName())
                    .description(depart.getDescription())
                    .createdDate(depart.getCreatedDate())
                    .updatedDate(depart.getLastModifiedDate())
                    .build();
        }
    }

    public static DepartDto.Response.ResponseBuilder getResponse() {
        return new DepartDto.Response.ResponseBuilder();
    }

    public static Depart toEntity(DepartDto.Request request) {
        return Depart.from(request);
    }
}
