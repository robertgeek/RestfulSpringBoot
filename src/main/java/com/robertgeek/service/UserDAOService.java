package com.robertgeek.service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.stereotype.Component;

import com.robertgeek.model.User;

@Component
public class UserDAOService {

	private static List<User> listUser = new ArrayList<>();
	private int countUser = 3;
	
	static {
		listUser.add(new User(1, "Roberto",new Date()));
		listUser.add(new User(2, "Adam"   ,new Date()));
		listUser.add(new User(3, "Eve"    ,new Date()));
		
	}
	
	public List<User> findAll(){
		return listUser;
	}
	
	public User addUser(User user){
		if(user.getId()==null) {
			user.setId(++countUser);
		}
		listUser.add(user);
		return user;
	}
	
	public User findId(int id) {
		for(User user : listUser){
			if(user.getId()==id) {
				return user;
			}
		}
		return null; 
	}
}
