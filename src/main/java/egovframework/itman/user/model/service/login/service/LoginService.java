package egovframework.itman.user.model.service.login.service;

import egovframework.itman.user.dto.UserDto;

public interface LoginService {

    UserDto.Response signup(UserDto.Request request);
}
