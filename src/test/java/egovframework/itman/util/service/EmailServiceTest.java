package egovframework.itman.util.service;

import egovframework.itman.util.mailsender.service.EmailService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import javax.mail.MessagingException;

@SpringBootTest
class EmailServiceTest {

    @Autowired
    private EmailService emailService;

    @Test
    void sendMail() throws MessagingException {
        emailService.sendMail("kyuyoungk@naver.com", "테스트 메일", "https://www.naver.com");
    }

}