package com.study.kang.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.Locale;

@Controller
public class IndexController {
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
