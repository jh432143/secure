package com.study.kang.handler;

import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.authentication.AuthenticationFailureHandler;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class UserLoginFailureHandler implements AuthenticationFailureHandler {
    public void onAuthenticationFailure(HttpServletRequest request, HttpServletResponse response, AuthenticationException e) throws IOException, ServletException {
        System.out.println(e.getLocalizedMessage());
        System.out.println(e.getMessage());
        for (StackTraceElement stack : e.getStackTrace()) {
            System.out.println(stack.getClassName());
            System.out.println(stack.getFileName());
            System.out.println(stack.getMethodName());
            System.out.println(stack.getLineNumber()+"");
            System.out.println(stack.isNativeMethod()+"");
        }

        response.sendRedirect(request.getContextPath() + "/login/loginForm?error");
    }
}
