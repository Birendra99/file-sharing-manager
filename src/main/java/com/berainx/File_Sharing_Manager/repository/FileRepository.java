package com.berainx.File_Sharing_Manager.repository;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.berainx.File_Sharing_Manager.entity.FileEntity;

public interface FileRepository extends JpaRepository<FileEntity, Integer>{
			
	List<FileEntity> findByExpiryDateBefore(LocalDateTime now);
	
}
