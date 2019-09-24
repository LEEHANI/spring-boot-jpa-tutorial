package com.test.web.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.EntityGraph;
import org.springframework.data.jpa.repository.Query;

import com.test.web.entities.Post;

public interface PostRepository extends CommonRepository<Post>
{
	@EntityGraph(attributePaths = "comments") 
//	@Query("select p from Post p join fetch p.comments ") 
	@Query("select p from Post p")
	List<Post> findAllJoinFetch();
	
}
