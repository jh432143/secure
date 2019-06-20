package com.study.kang.common.security;

import com.study.kang.mappers.MemberMapper;
import com.study.kang.vo.UserVO;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class CustomUserDetailsService implements UserDetailsService {
    private Logger logger = LoggerFactory.getLogger(CustomUserDetailsService.class);

    @Autowired
    private MemberMapper memberMapper;

    public UserDetails loadUserByUsername(String id) throws UsernameNotFoundException {
        boolean enabled = true;
        boolean accountNonExpired = true;
        boolean credentialsNonExpired = true;
        boolean accountNonLocked = true;

        UserVO dbUser = memberMapper.getUser(id);
        if (dbUser == null) {
            throw new UsernameNotFoundException(id);
        }

        List<GrantedAuthority> roles = new ArrayList<GrantedAuthority>();
        List<HashMap<String, String>> list = memberMapper.getRoles(id);
        for (HashMap<String, String> data : list) {
            roles.add(new SimpleGrantedAuthority(data.get("AUTHORITY")));
        }

        CustomUserDetail customUserDetail = new CustomUserDetail(dbUser.getId()
                                                                , dbUser.getPassword()
                                                                , enabled, accountNonExpired, credentialsNonExpired, accountNonLocked
                                                                , roles
                                                                , dbUser);

        return customUserDetail;
    }
}
