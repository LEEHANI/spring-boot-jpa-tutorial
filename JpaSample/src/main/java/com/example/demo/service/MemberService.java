package com.example.demo.service;

import javax.persistence.EntityManager;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.demo.entity.Member;
import com.example.demo.repository.MemberRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
@Transactional
public class MemberService 
{
	private final MemberRepository memberRepository;
	private final EntityManager em;
	
	public Member update(Long id, String name)
	{
		Member m = memberRepository.findById(id);
		m.changeName(name);
		
		// transaction commit
		return m;
	}
}
