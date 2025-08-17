package egovframework.itman.user.model.service.login.filter;

import com.fasterxml.jackson.databind.ObjectMapper;
import egovframework.itman.user.dto.LoginDto;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;
import org.springframework.security.web.context.HttpSessionSecurityContextRepository;
import org.springframework.stereotype.Component;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@Component
public class LoginFilter extends UsernamePasswordAuthenticationFilter {
    private final AuthenticationManager authenticationManager;

    public LoginFilter(AuthenticationManager authenticationManager) {
        super.setAuthenticationManager(authenticationManager);
        this.authenticationManager = authenticationManager;
        setFilterProcessesUrl("/login"); // 로그인 요청 경로 지정 필터 체인에 해도 되는듯

    }

    @Override
    public Authentication attemptAuthentication(HttpServletRequest request, HttpServletResponse response)
            throws AuthenticationException {

        try {
            System.out.println("LoginFilter.attemptAuthentication-----------------------------");
            // JSON으로 전달된 로그인 요청 파싱
            ObjectMapper mapper = new ObjectMapper();
            LoginDto.Request loginRequest = mapper.readValue(request.getInputStream(), LoginDto.Request.class);

            UsernamePasswordAuthenticationToken authRequest = new UsernamePasswordAuthenticationToken(
                    loginRequest.getUserEmail(), loginRequest.getUserPassword());

            return authenticationManager.authenticate(authRequest);

        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    protected void successfulAuthentication(HttpServletRequest request, HttpServletResponse response,
                                            FilterChain chain, Authentication authResult)
            throws IOException, ServletException {
//        response.setStatus(HttpServletResponse.SC_OK);
//        response.setContentType("text/plain; charset=UTF-8");
//        response.getWriter().write("로그인 성공");
//
//
//        //*************여기 다시 볼 것****************
//        super.successfulAuthentication(request, response, chain, authResult);//기본 리다이렉트 경로 가 루트경로임
//        //*************여기 다시 볼 것****************

        // 인증 정보를 SecurityContext에 넣기
        SecurityContextHolder.getContext().setAuthentication(authResult);

        // 세션에 SecurityContext 저장
        HttpSession session = request.getSession(true);
        session.setAttribute(HttpSessionSecurityContextRepository.SPRING_SECURITY_CONTEXT_KEY,
                SecurityContextHolder.getContext());

        // redirect 없이 상태 코드와 메시지만 반환
        response.setStatus(HttpServletResponse.SC_OK);
        response.setContentType("text/plain; charset=UTF-8");
        response.getWriter().write("로그인 성공");

    }

    @Override
    protected void unsuccessfulAuthentication(HttpServletRequest request, HttpServletResponse response,
                                              AuthenticationException failed)
            throws IOException, ServletException {
        response.setStatus(HttpServletResponse.SC_UNAUTHORIZED);
        response.setContentType("text/plain; charset=UTF-8");

        response.getWriter().write("로그인 실패: " + failed.getMessage());
    }

}
