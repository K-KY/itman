package egovframework.itman.state.dto;

import lombok.*;

import javax.validation.constraints.NotNull;
import java.time.LocalDateTime;

public class StateDto {

    // 📌 요청 DTO
    @Getter
    @Setter
    @NoArgsConstructor
    @AllArgsConstructor
    @Builder
    @ToString
    public static class Request {
        private Long stateSeq;
        private String stateName;
        private String tagColor; //RGB
        private Boolean enabled;
        private Boolean del;
        @NotNull
        private Long groupSeq;
    }

    // 📌 응답 DTO
    @Getter
    @Setter
    @NoArgsConstructor
    @AllArgsConstructor
    @Builder
    public static class Response {
        private Long stateSeq;
        private String stateName;
        private String tagColor; //RGB
        private Boolean enabled;
        private Boolean del;

        private LocalDateTime createdDate;
        private LocalDateTime modifiedDate;
    }
}
