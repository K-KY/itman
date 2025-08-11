package egovframework.itman.group.dto;

import egovframework.itman.user.dto.UserDto;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

public class ManageGroupDto {

    @Getter
    @AllArgsConstructor
    @NoArgsConstructor
    @Builder
    public static class Request {
        private Long groupSeq;
        private String groupName;
        private boolean del;
    }

    @Getter
    @Builder
    public static class Response {
        private Long groupSeq;
        private String groupName;
        private UserDto.Response user;
        private boolean del;
    }
}
