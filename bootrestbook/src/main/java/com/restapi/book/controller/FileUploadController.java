package com.restapi.book.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.restapi.book.helper.FileUploadHelper;

@RestController
public class FileUploadController {

	@Autowired
	private FileUploadHelper fuc;
	
	@PostMapping("/upload")
	public ResponseEntity<String> uploadFile(@RequestParam("file") MultipartFile file){
		try {
			if(file.isEmpty()) {
				return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Request Must Contain File");	
				}
				if(!file.getContentType().equals("image/jpeg")) {
					return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Only Jpeg Containt allowed");
				}
				
//				file upload code
				boolean result = fuc.uploadFile(file);

				if(result)
				return ResponseEntity.status(HttpStatus.ACCEPTED).body("File Successfuly uploaded...");

		} catch (Exception e) {
			e.printStackTrace();
		}
		return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Something went Wrong ! try again");
	}
	
	
}
