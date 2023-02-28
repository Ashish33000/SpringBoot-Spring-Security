package com.masai.services;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import com.masai.model.User;
@Service
public class UserServices {
	
	List<User> list=new ArrayList<>(); 
	
	
	public UserServices() {
		list.add(new User("abc","abc","abc@gmail.com","u1"));
		list.add(new User("xyz","xyz","xyz@gmail.com","u1"));
	}
	
	public List<User> getAllList(){
		return this.list;
	}
	
	public User getUser(String username) {
		return this.list.stream().filter((u)->u.getUsername().equals(username)).findAny().orElse(null);
	}
	
	public User addUser(User user) {
		this.list.add(user);
		return user;
	}
	

}
