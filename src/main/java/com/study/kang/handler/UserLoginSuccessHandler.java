package com.study.kang.handler;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class UserLoginSuccessHandler implements AuthenticationSuccessHandler {
    public void onAuthenticationSuccess(HttpServletRequest request, HttpServletResponse response, Authentication auth) throws IOException, ServletException {
        System.out.println(auth.getName());
        System.out.println(auth.getAuthorities().toString());
        System.out.println(auth.getDetails().toString());
        System.out.println(auth.getPrincipal().toString());

        UserDetails userDetails = (UserDetails) auth.getPrincipal();

        System.out.println(userDetails.getUsername());
        System.out.println(userDetails.getPassword());
        System.out.println(userDetails.isAccountNonExpired());
        System.out.println(userDetails.isAccountNonLocked());
        System.out.println(userDetails.isCredentialsNonExpired());
        System.out.println(userDetails.isEnabled());

        response.sendRedirect(request.getContextPath() + "/index");
    }


}
