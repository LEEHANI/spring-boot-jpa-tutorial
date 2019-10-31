package com.example.demo.repositories.impl;

import java.util.List;

import com.example.demo.entities.User;
import com.example.demo.repositories.custom.UserRepositoryCustom;
import com.querydsl.jpa.impl.JPAQueryFactory;

import lombok.RequiredArgsConstructor;
import static com.example.demo.entities.QUser.user;

@RequiredArgsConstructor
public class UserRepositoryImpl implements UserRepositoryCustom {
	
	private final JPAQueryFactory queryFactory;

	@Override
	public List<User> findByName(String name) {
		return queryFactory.selectFrom(user).where(user.name.eq(name)).fetch();
	}
}
