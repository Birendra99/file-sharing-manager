package com.berainx.File_Sharing_Manager.serviceimpl;

import java.io.IOException;
import java.time.LocalDateTime;
import java.util.Collection;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.berainx.File_Sharing_Manager.FileDTO.FileDTO;
import com.berainx.File_Sharing_Manager.entity.FileEntity;
import com.berainx.File_Sharing_Manager.exception.FileNotFoundException;
import com.berainx.File_Sharing_Manager.repository.FileRepository;
import com.berainx.File_Sharing_Manager.service.FileService;

@Service
public class FileServiceImpl implements FileService {
	
	@Autowired
	private FileRepository fileRepository;
	
	
	private FileDTO convertToDTO(FileEntity entity) {
		
		FileDTO dto=new FileDTO();
		BeanUtils.copyProperties(entity, dto);
		return dto;
		
	}
	
	

	@Override
	public List<FileDTO> getAll() {
		List<FileEntity> entities=fileRepository.findAll();
		
		return entities.stream().map(this::convertToDTO).collect(Collectors.toList());
	}

	@Override
	public ResponseEntity<?> uploadFile(MultipartFile file, String uploadedBy) throws IOException {
		FileEntity entity=new FileEntity();
		entity.setFileName(file.getOriginalFilename());
		entity.setUploadedBy(uploadedBy);
		entity.setExpiryTime(LocalDateTime.now().plusDays(1));
		entity.setUploadTime(LocalDateTime.now());
		entity.setFile_Data(file.getBytes());
		fileRepository.save(entity);
		
		return ResponseEntity.ok().body(convertToDTO(entity));
		
		
		
		
	}

	@Override
	public ResponseEntity<?> shareFile(int id) {
		Optional<FileEntity> entity=fileRepository.findById(id);
		if(entity.isPresent()) {
			return ResponseEntity.ok().body(convertToDTO(entity.get()));
		}
		else {
			throw new FileNotFoundException("File Not Found");
		}
		
	}

	@Override
	public ResponseEntity<?> deleteFile(int id) {
		Optional<FileEntity> entity= fileRepository.findById(id);
		
		if(entity.isPresent()) {
			
			return ResponseEntity.ok().body("File Deleted Successfylly.");
			
		}
		else {
			throw new FileNotFoundException("File not found");
		}
		
	}

}
