package com.rolen.responsiveweb.service;

import com.rolen.responsiveweb.entity.FileEntity;
import org.springframework.core.io.Resource;
import org.springframework.web.multipart.MultipartFile;

public interface FileService {
    FileEntity store(MultipartFile file);
    FileEntity getFile(Long id);
    Resource loadAsResource(String filename);
}