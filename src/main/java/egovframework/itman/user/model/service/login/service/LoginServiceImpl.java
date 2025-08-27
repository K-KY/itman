package egovframework.itman.user.model.service.login.service;

import egovframework.itman.user.dto.UserDto;
import egovframework.itman.user.model.entity.User;
import egovframework.itman.user.model.service.login.repository.UserRepository;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class LoginServiceImpl implements LoginService {

    @Autowired
    private UserRepository userRepository;
    @Autowired
    private PasswordEncoder passwordEncoder;

    @Override
    public UserDto.Response signup(UserDto.Request request) {
        if (userRepository.findByUserEmail(request.getUserEmail()).isPresent()) {
            throw new IllegalArgumentException("이미 존재하는 이메일 입니다.");
        }
        String password = passwordEncoder.encode(request.getUserPassword());
        try {
            User build = User.builder()
                    .userName(request.getUsername())
                    .userEmail(request.getUserEmail())
                    .userPassword(password)
                    .userName(request.getUsername())
                    .del(Boolean.FALSE)
                    .userRole("ROLE_USER")
                    .build();
            userRepository.save(build);
            return UserDto.from(build);
        } catch (Exception e) {
            e.printStackTrace();
            throw new RuntimeException(e);
        }
    }
}