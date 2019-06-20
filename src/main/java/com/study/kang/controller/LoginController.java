package com.study.kang.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.Locale;

@Controller
public class LoginController {
    private Logger logger = LoggerFactory.getLogger(LoginController.class);

    @RequestMapping(value = "/login/loginForm")
    public String loginForm(Locale locale, Model model) {
        logger.info("LoginController > loginForm");
        return "login/loginForm";
    }

    @RequestMapping(value = "/login/accessDenied")
    public String accessDenied(Locale locale, Model model) {
        return "login/accessDenied";
    }

    @RequestMapping(value = "/login/duplicateLogin")
    public String duplicateLogin(Locale locale, Model model) {
        return "login/duplicateLogin";
    }
}
