package egovframework.itman.user.model.repository;

import egovframework.itman.user.dto.UserDto;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.UUID;

@SpringBootTest
class RedisRepositoryTest {

    @Autowired
    private UserVerifyRepository userVerifyRepository;

    @Test
    void test() {
        UserDto.Request build = UserDto.Request.builder()
                .id(UUID.randomUUID())
                .userName("테스트2")
                .userPassword("테스트2")
                .build();
        userVerifyRepository.save(build);



    }
}