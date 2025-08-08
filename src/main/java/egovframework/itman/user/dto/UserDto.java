package egovframework.itman.user.dto;

import egovframework.itman.user.model.entity.User;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.redis.core.RedisHash;

import java.util.UUID;

public class UserDto {

    @Getter
    @AllArgsConstructor
    @NoArgsConstructor
    @Builder
    @RedisHash(value = "user", timeToLive = 600)//60분
    public static class Request {
        @Id
        private UUID id = UUID.randomUUID();
        private String userEmail;
        private String userPassword;
        private String userName;
    }

    @Getter
    @AllArgsConstructor
    @NoArgsConstructor
    @Builder
    public static class Response {
        private Integer userSeq;
        private String userEmail;
        private String userName;
        private String userRole;
        private Boolean del;

        public static Response from(User user) {
            return Response.builder()
                    .userSeq(user.getUserSeq())
                    .userEmail(user.getUserEmail())
                    .userName(user.getUsername())
                    .userRole(user.getUserRole())
                    .del(user.getDel())
                    .build();
        }

    }
}
