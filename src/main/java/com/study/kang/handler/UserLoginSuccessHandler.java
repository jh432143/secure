package com.study.kang.handler;

import com.study.kang.common.security.CustomUserDetail;
import com.study.kang.vo.UserVO;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class UserLoginSuccessHandler implements AuthenticationSuccessHandler {
    private Logger logger = LoggerFactory.getLogger(UserLoginSuccessHandler.class);
    private static int TIME = 60 * 60; // 1시간

    public void onAuthenticationSuccess(HttpServletRequest request, HttpServletResponse response, Authentication auth) throws IOException, ServletException {
        request.getSession().setMaxInactiveInterval(TIME);

        logger.info("name : {}, auth : {}, detail : {}, principal : {}", auth.getName(), auth.getAuthorities().toString(), auth.getDetails().toString(), auth.getPrincipal().toString());

        response.sendRedirect(request.getContextPath() + "/index");
    }
}
