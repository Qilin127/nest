package com.nest.renting.web.admin.custom.interceptor;

import com.nest.renting.common.exception.RentingException;
import com.nest.renting.common.result.ResultCodeEnum;
import com.nest.renting.common.utils.JwtUtil;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;

@Component
public class AuthenticationInterceptor implements HandlerInterceptor {

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        String token = request.getHeader("access_token");

        if (token == null) {
            throw new RentingException(ResultCodeEnum.ADMIN_LOGIN_AUTH);
        } else {
            JwtUtil.parseToken(token);
        }
        return true;
    }
}
