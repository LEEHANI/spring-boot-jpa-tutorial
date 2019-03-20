package com.test.web.controller.interfaces;

import java.util.List;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.test.web.entities.User;

@RequestMapping(value = "/user")
public interface UserControllerInterface
{
	@PostMapping("/insert")
	public User insert(String userId, String password);
	
	@GetMapping("")
	public List<User> list();
	
	@GetMapping("/one")
	public User one(Long seq);
	
	@DeleteMapping("/delete")
	public void delete(Long seq);
	
	@PutMapping("/change")
	public User changePassword(String userId, String password, String newPassword);
}
