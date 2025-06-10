package com.rolen.responsiveweb.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
public class MainController {

    @GetMapping("/")
    public String home(Model model) {
        model.addAttribute("message", "Spring Boot 반응형 웹 애플리케이션에 오신 것을 환영합니다!");
        return "index";
    }

    @GetMapping("/about")
    public String about(Model model) {
        model.addAttribute("title", "소개 페이지");
        return "about";
    }

    @GetMapping("/services")
    public String services(Model model) {
        model.addAttribute("title", "서비스 페이지");
        return "services";
    }

    @GetMapping("/contact")
    public String contact(Model model) {
        model.addAttribute("title", "연락처 페이지");
        return "contact";
    }
}