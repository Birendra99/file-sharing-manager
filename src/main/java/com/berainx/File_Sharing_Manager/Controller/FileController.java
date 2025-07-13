package com.berainx.File_Sharing_Manager.Controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.GetMapping;


@Controller
@RequestMapping("/files")
public class FileController {
	
	@GetMapping("/login")
	public String login() {
		return "home";
	}
	
	@GetMapping("/list")
	public String listFiles() {
		
		return "list-files";
	}
	
	@GetMapping("/share")
	public String share() {
		
		return "share-file";
	}
	
	
	

}
