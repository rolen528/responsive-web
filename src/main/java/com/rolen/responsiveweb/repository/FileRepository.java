package com.rolen.responsiveweb.repository;

import com.rolen.responsiveweb.entity.FileEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface FileRepository extends JpaRepository<FileEntity, Long> {
}