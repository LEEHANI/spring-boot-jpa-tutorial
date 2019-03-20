package com.test.web.controller.interfaces;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.test.web.entities.Comment;

@RequestMapping(value = "/comment")
public interface CommentControllerInterface
{
	@PostMapping("/insert")
	public Comment insert(String content);

	@GetMapping("")
	public List<Comment> list();
	
	@GetMapping("/one")
	public Comment one(Long seq);
}
