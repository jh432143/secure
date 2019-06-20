package com.study.kang.controller;

import com.study.kang.common.security.CustomUserDetail;
import com.study.kang.vo.UserVO;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.Locale;

@Controller
public class IndexController {
    private Logger logger = LoggerFactory.getLogger(IndexController.class);

    @RequestMapping(value = "/")
    public String base (Locale locale, Model model) {
        return "index";
    }

    @RequestMapping(value = "/index")
    public String index (Locale locale, Model model) {
        return "index";
    }

    @RequestMapping(value = "/intro/introduction")
    public String introduction(Locale locale, Model model) {

        return "intro/introduction";
    }
}
