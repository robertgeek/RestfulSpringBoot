package com.robertgeek.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.robertgeek.model.User;
import com.robertgeek.service.UserDAOService;

@RestController
public class UserController {

	@Autowired
	private UserDAOService service;
	
	@GetMapping(path = "/users")
	public List<User> getAllUsers(){
		return service.findAll();
	}
	
	@GetMapping(path = "/users/{id}")
	public User findOneUser(@PathVariable int id) {
		return service.findId(id);
	}
	
	@PostMapping(path = "/users")
	public void  createUser(@RequestBody User user) {
		service.addUser(user);
	}
}
