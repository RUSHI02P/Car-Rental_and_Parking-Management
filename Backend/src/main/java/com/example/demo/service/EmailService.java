package com.example.demo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.mail.SimpleMailMessage;
//import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;



@Service
public class EmailService {
	
    @Autowired
	JavaMailSender mailsender;
	
	public void sendEmail(String email,String password) {
		SimpleMailMessage message=new SimpleMailMessage();
		message.setTo(email);
		message.setSubject("Your Password to access ALPHA-CARS ");
		message.setText("Hi "+email + ", Your Password is "+password);
		mailsender.send(message);
		
		System.out.println("Mail Sent Successfully ......");
	}




}
