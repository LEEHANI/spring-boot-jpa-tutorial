package com.test.web.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.test.web.controller.interfaces.CommentControllerInterface;
import com.test.web.entities.Comment;
import com.test.web.services.CommentService;

@RestController
public class CommentController implements CommentControllerInterface
{
	@Autowired
	private CommentService commentService;

	@Override
	public Comment insert(String content)
	{
		return commentService.save
				(
					Comment.builder()
					.content(content)
					.build()
				);
	}

	@Override
	public List<Comment> list()
	{
		return commentService.getList();
	}

	@Override
	public Comment one(@PathVariable Long seq)
	{
		return commentService.getOne(seq);
	}
}
