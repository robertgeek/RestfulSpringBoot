package com.robertgeek.controller;

import java.net.URI;
import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.robertgeek.exceptions.UserNotFoundException;
import com.robertgeek.model.User;
import com.robertgeek.service.UserDAOService;

@RestController
public class UserController {

	@Autowired
	private UserDAOService service;
	
	@GetMapping(path = "/users")
	public List<User> retrieveAllUser(){
		return service.findAll();
	}
	
	@GetMapping(path = "/users/{id}")
	public User findOneUser(@PathVariable int id) {
		User user = service.findId(id);
		
		if(user== null) {
			throw new UserNotFoundException("id-"+ id);
		}
		return user;
	}
	/*
	@GetMapping(path = "/users/{id}")
	public EntityModel<User> findOneUser(@PathVariable int id) {
		User user = service.findId(id);
		
		if(user== null) {
			throw new UserNotFoundException("id-"+ id);
		}
		//HATEOAS
		EntityModel<User> model = new EntityModel<>(user);
		WebMvcLinkBuilder linkTo = linkTo(methodOn(this.getClass()).retrieveAllUser());
		model.add(linkTo.withRel("all-users"));
		
		return model
		
	}*/
	
	@PostMapping(path = "/users")
	public ResponseEntity<Object>  addUser(@Valid @RequestBody User user) {
		service.saveUser(user);
		URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/id").buildAndExpand(user.getId()).toUri();
		return ResponseEntity.created(location).build();
	}
	
	@DeleteMapping(path = "/user/{id}")
	public void deleteUser(@PathVariable int id) {
		User user = service.deleteById(id);
		
		if(user == null) {
			throw new UserNotFoundException("id - "+ id);
		}
	}
}
