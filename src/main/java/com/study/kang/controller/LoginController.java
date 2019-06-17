package com.study.kang.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.Locale;

@Controller
public class LoginController {
    @RequestMapping(value = "/login/loginForm")
    public String loginFor(Locale locale, Model model) {
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
