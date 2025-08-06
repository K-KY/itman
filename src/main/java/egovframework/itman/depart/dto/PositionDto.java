package egovframework.itman.depart.dto;

import egovframework.itman.depart.model.entity.Position;
import lombok.*;
import java.time.LocalDateTime;

public class PositionDto {

    @Getter
    @Builder
    @AllArgsConstructor
    @NoArgsConstructor
    public static class Request {
        private Integer seq;
        private String name;
        private String description;
        private Boolean del;
        private LocalDateTime createdDate;
        private LocalDateTime updatedDate;

    }

    @Getter
    @Builder
    @AllArgsConstructor
    @NoArgsConstructor
    public static class Response {
        private Integer seq;
        private String name;
        private String description;
        private Boolean del;
        private LocalDateTime createdDate;
        private LocalDateTime updatedDate;

    }

    public Response from(Position position) {
        return Response.builder()
                .seq(position.getPositionSeq())
                .name(position.getPositionName())
                .description(position.getPositionDescription())
                .del(position.getDel())
                .createdDate(position.getCreatedDate())
                .updatedDate(position.getLastModifiedDate())
                .build();
    }

}
