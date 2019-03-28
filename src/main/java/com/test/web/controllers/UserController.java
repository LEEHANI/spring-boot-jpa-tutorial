package com.test.web.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.test.web.controller.interfaces.UserControllerInterface;
import com.test.web.entities.User;
import com.test.web.services.UserService;

@RestController
public class UserController implements UserControllerInterface
{
//	private final static ObjectMapper OBJECT_MAPPER = new ObjectMapper();
	
	@Autowired
	private UserService userService;
	
	@Override
	public User insert(String userId, String password)
	{
		return userService.save
				(
					User.builder()
					.userId(userId)
					.password(password)
					.build()
				);
	}

	@Override
	@ResponseBody
	public List<User> list()
	{
		return userService.getList();
	}

	@Override
	public User one(@PathVariable Long seq)
	{
		return userService.getOne(seq);
	}

	@Override
	public void delete(@PathVariable Long seq)
	{
		userService.delete(seq);
	}
	
	@Override
	public User changePassword(String userId, String password, String newPassword)
	{
		return userService.changePassword(userId, password, newPassword);
	}

}
