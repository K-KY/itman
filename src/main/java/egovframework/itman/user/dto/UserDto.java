package egovframework.itman.user.dto;

import egovframework.itman.user.model.entity.User;
import lombok.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.redis.core.RedisHash;

import java.util.UUID;

public class UserDto {

    @Getter
    @AllArgsConstructor
    @NoArgsConstructor
    @Builder
    @RedisHash(value = "user", timeToLive = 600)//10분
    @ToString
    public static class Request {
        @Id
        private UUID id = UUID.randomUUID();
        private Integer userSeq;
        private String userEmail;
        private String userPassword;
        private String username;
        private Boolean del;
    }

    @Getter
    @AllArgsConstructor
    @NoArgsConstructor
    @Builder
    public static class Response {
        private Integer userSeq;
        private String userEmail;
        private String username;
        private String userRole;
        private Boolean del;

    }

    public static Response from(User user) {
        return Response.builder()
                .userSeq(user.getUserSeq())
                .userEmail(user.getUserEmail())
                .username(user.getUsername())
                .userRole(user.getUserRole())
                .del(user.getDel())
                .build();
    }


}
