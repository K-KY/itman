package egovframework.itman.depart.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

public class EmployeeDto {
    @Getter
    @AllArgsConstructor
    @NoArgsConstructor
    @Builder
    public static class Request {
        private int empSeq;
        private String empName;
        private String empPhone;
        private String empEmail;
        private String empNum;
        private DepartDto.Request departDto;
        private Request manager;
        //직무 position
        private Long groupSeq;
        private JobDto.Request job;
        private Boolean del;
        private LocalDateTime createdDate;
        private LocalDateTime updatedDate;

    }

    @Getter
    @Builder
    public static class Response {
        private int empSeq;
        private boolean del;
        private String empName;
        private String empNum;
        private String empPhone;
        private String empEmail;
        private DepartDto.Response departDto;
        private JobDto.Response job;
        private Response manager;
        private LocalDateTime createdDate;
        private LocalDateTime updatedDate;

    }

    public static EmployeeDto.Response.ResponseBuilder getResponse() {
        return new EmployeeDto.Response.ResponseBuilder();
    }

}
