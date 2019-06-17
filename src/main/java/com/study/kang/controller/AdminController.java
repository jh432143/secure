package com.study.kang.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.Locale;

@Controller
public class AdminController {
    @RequestMapping(value = "/admin/adminHome")
    public String home(Locale locale, Model model) {
        return "admin/adminHome";
    }
}
