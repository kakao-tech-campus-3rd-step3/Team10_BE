package com.igemoney.igemoney_BE.common.interceptor;


import com.igemoney.igemoney_BE.common.annotation.Authenticated;
import com.igemoney.igemoney_BE.common.exception.user.NoUserIdTokenException;
import com.igemoney.igemoney_BE.common.exception.user.UnvalidJwtTokenException;
import com.igemoney.igemoney_BE.common.utils.JwtUtil;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import org.springframework.web.method.HandlerMethod;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;


@Component
@RequiredArgsConstructor
public class AuthenticationInterceptor implements HandlerInterceptor {

    private final JwtUtil jwtUtil;

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        if(!(handler instanceof HandlerMethod)) { // 정적 리소스는 곧바로 통과
            return true;
        }

        HandlerMethod handlerMethod = (HandlerMethod) handler;
        if(handlerMethod.hasMethodAnnotation(Authenticated.class)){
            String token = jwtUtil.extractJwtTokenFromHeader(request);

            if (token == null || !jwtUtil.validateJwtToken(token)) {
                throw new UnvalidJwtTokenException("토큰이 없거나 유효하지 않은 토큰입니다.");
            }

            String subject = jwtUtil.getSubject(token);
            if (subject == null) {
                throw new NoUserIdTokenException("토큰에 유저 식별자가 없습니다.");
            }
            Long userId = Long.parseLong(subject);
            request.setAttribute("userId", userId);
            return true;
        }
        return true;
    }


    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {
        HandlerInterceptor.super.postHandle(request, response, handler, modelAndView);
    }


    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {
        HandlerInterceptor.super.afterCompletion(request, response, handler, ex);
    }

}
