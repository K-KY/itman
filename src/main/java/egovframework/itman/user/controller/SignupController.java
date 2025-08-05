package egovframework.itman.user.controller;

import egovframework.itman.user.dto.UserDto;
import egovframework.itman.user.model.service.login.service.LoginService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("signup")
public class SignupController {


    @Autowired
    private LoginService userService;


    @PostMapping
    public UserDto.Response signup(@RequestBody UserDto.Request request) {
        return userService.signup(request);
    }
}
