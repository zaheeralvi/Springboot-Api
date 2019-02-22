package com.microservices.dev.services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.microservices.dev.modal.User;
import com.microservices.dev.repository.UserRepository;

@Component
public class UserService {
	
	@Autowired
	private UserRepository userRepository;
	
	public String Home() {
		return "this is home page";
	}
	
	public User add(User user) {
		return userRepository.save(user);
	}
	
	public Iterable<User> getAll() {
		return userRepository.findAll();
	}
	
	public Optional<User> getById(int id) {
		return userRepository.findById(id);
	}
	
	public User Update(int id,User user) {
		user.setId(id);
		return userRepository.save(user);
	}
	
	public String delete(int id) {
			User user=userRepository.findById(id).get();
			userRepository.delete(user);
			return "User Deleted Successfully";
	}
	
}
