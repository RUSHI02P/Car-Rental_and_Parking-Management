package com.example.demo.service;


import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;

import org.springframework.core.io.ClassPathResource;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;
//import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

@Service
public class UploadImageService {
	
	public String uploadImage(MultipartFile multipart,Long id) {
		String msg="";
		try {
			InputStream stream=multipart.getInputStream();
			System.out.println("PATH BEFORE ="+new ClassPathResource("").getFile().getAbsolutePath());
			String path= new ClassPathResource("").getFile().getAbsolutePath();
			String fileName=id+multipart.getOriginalFilename();
			Path uploadPath=Paths.get(path);
			if(!Files.exists(uploadPath)) {
				Files.createDirectories(uploadPath);
			}
		 
				 Path filePath = uploadPath.resolve(fileName);
		         Files.copy(stream, filePath, StandardCopyOption.REPLACE_EXISTING);
		         System.out.println(" Actual Path ="+new ClassPathResource("").getFile().getAbsolutePath().toString().concat("/"+fileName).toString());
		        return  new ClassPathResource("").getFile().getAbsolutePath().toString().concat("/"+fileName).toString();
		         
		 
		
		} catch (IOException e) {
			// TODO Auto-generated catch block
			System.out.println("Error Occured ="+e.getMessage());
			msg+="Error Occured";
			e.printStackTrace();
		}
		
		return msg;
	}



}
