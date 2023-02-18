package com.example.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.model.User;
import com.example.demo.repository.UserRepository;

@RestController
@CrossOrigin
public class UserController {
	
	@Autowired
	UserRepository 	userRepository ;

	
	@PostMapping(value = "/login/{username}/{password}") // lookup
	public User getUser(@PathVariable(value = "username") String username,
			@PathVariable(value = "password") String password) {
		System.out.println("USERNAME : "+username);
		System.out.println(password);
		return userRepository.findByUserNameAndPassword(username,password);
	
	}
	
	@PostMapping(value="/save")
	public User saveUser(@RequestBody User user)
	{
		userRepository.save(user);
		return user;
	}
}
