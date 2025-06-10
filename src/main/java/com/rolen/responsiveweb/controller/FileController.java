package com.rolen.responsiveweb.controller;

import com.rolen.responsiveweb.entity.FileEntity;
import com.rolen.responsiveweb.service.FileService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.Resource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;  // Model import 추가
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

@Controller
@RequestMapping("/files")
public class FileController {
    @Autowired
    private FileService fileService;

    @GetMapping("")
    public String files(Model model) {
        model.addAttribute("title", "파일 관리");
        return "files";
    }

    @PostMapping("/upload")
    public String uploadFile(@RequestParam("file") MultipartFile file) {
        fileService.store(file);
        return "redirect:/files";
    }

    @GetMapping("/download/{id}")
    public ResponseEntity<Resource> downloadFile(@PathVariable Long id) {
        FileEntity fileEntity = fileService.getFile(id);
        Resource resource = fileService.loadAsResource(fileEntity.getFilename());

        return ResponseEntity.ok()
                .header(HttpHeaders.CONTENT_DISPOSITION,
                        "attachment; filename=\"" + fileEntity.getOriginalFilename() + "\"")
                .body(resource);
    }
}