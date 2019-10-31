package com.test.web.controller.interfaces;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.test.web.entities.Post;

@RequestMapping(value = "/post")
public interface PostControllerInterface
{
	@PostMapping("")
	public Post insert(String city, String street);

	@GetMapping("")
	public List<Post> list();
	
	@GetMapping("fetch")
	public List<Post> joinFetchList();
	
	@GetMapping("{seq}")
	public Post one(@PathVariable Long seq);
}
