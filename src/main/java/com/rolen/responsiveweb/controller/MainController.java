package com.rolen.responsiveweb.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import com.rolen.responsiveweb.entity.FileEntity;
import com.rolen.responsiveweb.repository.FileRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class MainController {
    @Autowired
    private FileRepository fileRepository;

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

//    @GetMapping("/files") FileController에서 처리
//    public String files(Model model) {
//        model.addAttribute("title", "파일 관리");
//        model.addAttribute("files", fileRepository.findAll());
//        return "files";
//    }

}