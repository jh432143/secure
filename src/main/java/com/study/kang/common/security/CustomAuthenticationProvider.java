package com.study.kang.common.security;

import com.study.kang.mappers.MemberMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class CustomAuthenticationProvider implements AuthenticationProvider {
    private Logger logger = LoggerFactory.getLogger(CustomAuthenticationProvider.class);

    @Autowired
    private MemberMapper memberMapper;

    @Autowired
    private UserDetailsService userDetailsService;

    @Autowired
    private BCryptPasswordEncoder bCryptPasswordEncoder;

    public Authentication authenticate(Authentication authentication) throws AuthenticationException {
        String userId = (String) authentication.getPrincipal();
        String userPw = (String) authentication.getCredentials();

        CustomUserDetail customUserDetail = (CustomUserDetail) userDetailsService.loadUserByUsername(userId);
        if (bCryptPasswordEncoder.matches(userPw, customUserDetail.getPassword())) {
            logger.info("password success");

        } else {
            logger.info("password fail");
            throw new BadCredentialsException(userId);
        }

        List<GrantedAuthority> roles = new ArrayList<GrantedAuthority>();
        List<HashMap<String, String>> list = memberMapper.getRoles(userId);
        for (HashMap<String, String> data : list) {
            roles.add(new SimpleGrantedAuthority(data.get("AUTHORITY")));
        }

        UsernamePasswordAuthenticationToken result = new UsernamePasswordAuthenticationToken(userId, userPw, roles);

        return result;
    }

    public boolean supports(Class<?> authentication) {
        return authentication.equals(UsernamePasswordAuthenticationToken.class);
    }
}
