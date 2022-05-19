package com.springboot.rest.book.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.springboot.rest.book.helper.FileUploadHelper;



@RestController
public class FileUploadController {
	@Autowired
	FileUploadHelper fileUploadHelper;
	@PostMapping("/uploadfile")
	public ResponseEntity<String> uploadFile(@RequestParam("ssd-file") MultipartFile file)
	{
		
		if(file.isEmpty()) {
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("request must contain file");
		}
		//deprecated
		//boolean uploadFile = this.fileUploadHelper.uploadFile(file);
		boolean uploadFile = this.fileUploadHelper.upload(file);
		if(uploadFile==true) {
			
			return ResponseEntity.ok(ServletUriComponentsBuilder.fromCurrentContextPath().path("/images/").path(file.getOriginalFilename()).toUriString());
		}
		
		return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Something Went Wrong");
	}
}