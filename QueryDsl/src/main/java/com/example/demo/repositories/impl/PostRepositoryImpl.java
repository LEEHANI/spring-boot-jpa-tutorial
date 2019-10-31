package com.example.demo.repositories.impl;

import static com.example.demo.entities.QPost.post;

import java.util.List;

import com.example.demo.entities.Post;
import com.example.demo.repositories.custom.PostRepositoryCustom;
import com.querydsl.jpa.impl.JPAQueryFactory;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class PostRepositoryImpl implements PostRepositoryCustom {
	
	private final JPAQueryFactory queryFactory;

	@Override
	public List<Post> findByContent(String content) {
		return queryFactory.selectFrom(post).where(post.content.eq(content)).fetch();
	}
}
