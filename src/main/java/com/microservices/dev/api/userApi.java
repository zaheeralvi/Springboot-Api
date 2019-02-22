package com.microservices.dev.api;

import java.util.Iterator;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.microservices.dev.modal.User;
import com.microservices.dev.services.UserService;

@RestController
public class userApi {

	@Autowired
	private UserService userService;
	
	@RequestMapping("/")
	public String home() {
		return userService.Home();
	}
	
	@PostMapping("/user")
	public User addUser(@RequestBody User user) {
		return userService.add(user);
	}
	
	@GetMapping("/user")
	public Iterable<User> getUsers() {
		return userService.getAll();
	}
	
	@GetMapping("/user/{id}")
	public Optional<User> getOneUser(@PathVariable int id) {
		return userService.getById(id);
	}
	
	@PutMapping("/user/{id}")
	public User updateUser(@PathVariable int id,@RequestBody User user) {
		return userService.Update(id, user);
	}
	@DeleteMapping("/user/{id}")
	public String deleteUser(@PathVariable int id) {
		return userService.delete(id);
	}
}
