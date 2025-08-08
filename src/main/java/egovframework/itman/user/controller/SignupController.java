package egovframework.itman.user.controller;

import egovframework.itman.user.dto.UserDto;
import egovframework.itman.user.model.repository.UserVerifyRepository;
import egovframework.itman.user.model.service.login.service.LoginService;
import egovframework.itman.util.mailsender.service.EmailService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.mail.MessagingException;
import java.util.Optional;

@Slf4j
@RestController
@RequestMapping("signup")
@RequiredArgsConstructor
public class SignupController {
    @Autowired
    private final LoginService userService;
    @Autowired
    private final EmailService emailService;
    @Autowired
    private final UserVerifyRepository userVerifyRepository;


    //이메일 인증 전 레디스에 유효기간이 지정된 사용자 데이터 저장
    @PostMapping
    public UserDto.Request signup(@RequestBody UserDto.Request request) throws MessagingException {
        emailService.sendMail(request.getUserEmail(), "아이티맨 회원가입 인증 메일", request.getId().toString());
        userVerifyRepository.save(request);
        return request;
    }

    @GetMapping
    public UserDto.Response verify(@RequestParam String token) {
        Optional<UserDto.Request> request = userVerifyRepository.findById(token);
        if (request.isPresent()) {
            UserDto.Response signup = userService.signup(request.get());
            userVerifyRepository.delete(request.get());//인증 완료 후 삭제
            return signup;
        }
        throw new IllegalArgumentException("회원 인증 실패");
    }

}
