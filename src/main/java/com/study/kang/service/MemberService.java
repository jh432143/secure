package com.study.kang.service;

import com.study.kang.mappers.MemberMapper;
import com.study.kang.vo.UserVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class MemberService {
    @Autowired
    private BCryptPasswordEncoder bCryptPasswordEncoder;

    @Autowired
    private MemberMapper memberMapper;

    public void insertMember(UserVO userVO) throws Exception {
        userVO.setPassword(bCryptPasswordEncoder.encode(userVO.getPassword()));
        userVO.setAuthority("ROLE_USER");

        memberMapper.insertMember(userVO);
        memberMapper.insertAuth(userVO);
    }
}
