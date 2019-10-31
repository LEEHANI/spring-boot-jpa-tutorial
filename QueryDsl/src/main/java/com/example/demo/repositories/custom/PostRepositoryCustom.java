package com.example.demo.repositories.custom;

import java.util.List;

import com.example.demo.entities.Post;

public interface PostRepositoryCustom {
	List<Post> findByContent(String content);
}
