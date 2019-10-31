package com.example.demo.repositories.custom;

import java.util.List;

import com.example.demo.entities.User;

public interface UserRepositoryCustom {
	List<User> findByName(String name);
}
