package com.berainx.File_Sharing_Manager.entity;

import java.time.LocalDateTime;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Lob;
import lombok.Data;
@Entity
@Data
public class FileEntity {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
	private String fileName;
	
	private String uploadedBy;
	
	private LocalDateTime uploadTime;
	
	private LocalDateTime expiryTime;
	
	@Lob
	@Column(name="file_data",columnDefinition = "LONGBLOB")
	private byte[] file_Data;
	

}
