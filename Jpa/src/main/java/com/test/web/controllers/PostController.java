package com.test.web.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.test.web.controller.interfaces.PostControllerInterface;
import com.test.web.entities.Post;
import com.test.web.services.PostService;

@RestController
public class PostController implements PostControllerInterface
{
	@Autowired
	private PostService postService;

	@Override
	public Post insert(String title, String content)
	{
		return postService.save
				(
					Post.builder()
					.title(title)
					.content(content)
					.build()
				);
	}

	@Override
	public List<Post> list()
	{
		return postService.getList();
	}
	
	@Override
	public List<Post> joinFetchList()
	{
		return postService.findAllJoinFetch();
	}

	@Override
	public Post one(@PathVariable Long seq)
	{
		Post post = postService.getOne(seq);
		
		return post;
	}
}
