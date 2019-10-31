package com.test.web.services;

import java.util.Objects;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.test.web.entities.User;
import com.test.web.repositories.UserRepository;

@Service
public class UserService extends CommonService<User>
{
	@Autowired
	private UserRepository userRepository;
	
	public User changePassword(String userId, String password, String newPassword)
	{
		User user = userRepository.findByUserIdAndPassword(userId, password).orElse(null);
		
		if(Objects.nonNull(user))
		{
			user.setPassword(newPassword);
			
			return repository.save(user);
		}
		
		return null;
	}
	
	public Page<User> list(Pageable pageable)
	{
		return repository.findAll(pageable);
	}
}
