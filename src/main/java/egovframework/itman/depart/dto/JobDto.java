package egovframework.itman.depart.dto;

import egovframework.itman.depart.model.entity.Job;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

public class JobDto {

    @Getter
    @AllArgsConstructor
    @NoArgsConstructor
    @Builder
    public static class Request {
        private Integer seq;
        private String name;
        private String description;
        private Boolean del;
        private LocalDateTime createdDate;
        private LocalDateTime updatedDate;


    }

    @Getter
    @AllArgsConstructor
    @NoArgsConstructor
    @Builder
    public static class Response {
        private Integer seq;
        private String name;
        private String description;
        private Boolean del;
        private LocalDateTime createdDate;
        private LocalDateTime updatedDate;
    }

    public Response from(Job job) {
        return Response.builder()
                .seq(job.getJobSeq())
                .name(job.getJobName())
                .description(job.getJobDescription())
                .del(job.isDel())
                .createdDate(job.getCreatedDate())
                .updatedDate(job.getLastModifiedDate())
                .build();
    }
}
