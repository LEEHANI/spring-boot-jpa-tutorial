package com.test.web.repositories;

import java.util.Optional;

import com.test.web.entities.User;

public interface UserRepository extends CommonRepository<User>
{
	Optional<User> findByUserIdAndPassword(String userId, String password);
}
