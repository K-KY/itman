package egovframework.itman.util.mailsender.service;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;

@Service
@RequiredArgsConstructor
public class EmailService {
    @Value("${spring.mail.host}")
    private String host;

    private final JavaMailSender mailSender;

    public void sendMail(String to, String subject, String linkUrl) throws MessagingException {
        MimeMessage message = mailSender.createMimeMessage();

        MimeMessageHelper helper = new MimeMessageHelper(message, true, "UTF-8");
        helper.setTo(to);
        helper.setSubject(subject);
        helper.setFrom(host);
        String htmlContent = "<html>" +
                "<body>" +
                "<h1 style='color:blue;'>이메일 제목</h1>" +
                "<p>내용 본문입니다.</p>" +
                "<a href='" + "http://localhost:5174/signup?token=" + linkUrl + "'>버튼</a>" +
                "</body>" +
                "</html>";
        helper.setText(htmlContent, true); // true: HTML 사용 설정

        mailSender.send(message);

    }
}
