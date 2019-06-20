package com.study.kang.controller;

import com.study.kang.service.MemberService;
import com.study.kang.vo.UserVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.Locale;

@Controller
public class MemberController {
    @Autowired
    private MemberService memberService;

    // 회원가입 페이지
    @RequestMapping(value = "/member/memberJoinPage")
    public String memberJoinPage (Locale locale, Model model) {
        return "member/memberJoinPage";
    }

    // 회원가입 처리
    @RequestMapping(value = "/member/memberJoin")
    public String memberJoin (Locale locale, Model model, UserVO userVO) throws Exception {
        memberService.memberJoin(userVO);
        return "index";
    }
}
