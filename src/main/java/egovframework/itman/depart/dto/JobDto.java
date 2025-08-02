package egovframework.itman.depart.dto;

import java.time.LocalDateTime;

public class JobDto {

    public static class Request {
        private Integer jobSeq;
        private String jobName;
        private boolean del;
        private LocalDateTime createdDate;
        private LocalDateTime updatedDate;

    }
    public static class Response {
        private Integer jobSeq;
        private String jobName;
        private boolean del;
        private LocalDateTime createdDate;
        private LocalDateTime updatedDate;
    }
}
