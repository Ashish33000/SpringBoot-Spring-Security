package com.masai.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.masai.model.User;
import com.masai.services.UserServices;

@RestController
@RequestMapping("/users")
public class UserContoller {
	@Autowired
	private UserServices userService;
	
	
	@GetMapping
	public List<User> getAllUser(){
		return this.userService.getAllList();
	}
	//@PreAuthorize("hasRole('ADMIN')")
	@GetMapping("/{username}")
	public User getUser(@PathVariable("username") String username) {
		return this.userService.getUser(username);
	}
	
	@PostMapping("/adduser")
	public User addtUser(@RequestBody User user) {
		return this.userService.addUser(user);
	}
	
	

}
