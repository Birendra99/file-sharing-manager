package com.berainx.File_Sharing_Manager.service;

import java.io.IOException;
import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.multipart.MultipartFile;

import com.berainx.File_Sharing_Manager.FileDTO.FileDTO;

public interface FileService {

	public List<FileDTO> getAll();
	
//	         Use Case	                  Why ResponseEntity?
//			Custom status code ->	ResponseEntity.status(HttpStatus.XYZ)
//			Control response body & headers ->	Add headers, content type, etc.
//			Flexible return types ->	Use of <?> allows generality
	
	public ResponseEntity<?> uploadFile(MultipartFile file, String uploadedBy)throws IOException;
	
	public ResponseEntity<?> shareFile(int id);
	
	public ResponseEntity<?> deleteFile(int id);
}
