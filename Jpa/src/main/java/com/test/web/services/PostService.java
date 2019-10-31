package com.test.web.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.test.web.entities.Post;
import com.test.web.repositories.PostRepository;

@Service
public class PostService extends CommonService<Post>
{
	@Autowired
	private PostRepository postRepository;
	
	public List<Post> findAllJoinFetch()
	{
		return postRepository.findAllJoinFetch();
	}
}
