package egovframework.itman.user.controller;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseCookie;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.web.authentication.logout.SecurityContextLogoutHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@Slf4j
@RestController
@RequestMapping("user")
@RequiredArgsConstructor
public class UserController {

    @GetMapping("/auth/me")
    public ResponseEntity<?> getCurrentUser(@AuthenticationPrincipal UserDetails user) {
        if (user == null) {

            log.info("로그인 되지 않은 사용자.");
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).build();
        }
        return ResponseEntity.ok(user);
    }

    @PostMapping("logout")
    public ResponseEntity<Void> deleteSession(
            HttpServletRequest request, HttpServletResponse response, Authentication auth) {

        new SecurityContextLogoutHandler().logout(request, response, auth);

        //쿠키 삭제
        ResponseCookie cookie = ResponseCookie.from("JSESSIONID", "")
                .path("/")                // 발급 시 path와 동일
                .maxAge(0)
                .httpOnly(true)
                .build();
        response.addHeader("Set-Cookie", cookie.toString());

        return ResponseEntity.noContent().build(); // 204
    }

}
