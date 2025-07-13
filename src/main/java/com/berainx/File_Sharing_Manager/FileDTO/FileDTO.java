package com.berainx.File_Sharing_Manager.FileDTO;

import java.time.LocalDateTime;

import lombok.Data;

@Data
public class FileDTO {
	
	private int id;
	private String fileName;
	
	private String uploadedBy;
	
	private LocalDateTime uploadTime;
	private LocalDateTime expiryTime;
	
	private byte[] fileData;
	
	

}
