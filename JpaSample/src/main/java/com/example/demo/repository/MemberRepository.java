package com.example.demo.repository;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.example.demo.entity.Member;

@Repository
@Transactional
public class MemberRepository {

	@PersistenceContext
	private EntityManager em;
	
	public List<Member> findAll()
	{
		return em.createQuery("SELECT m FROM Member m", Member.class).getResultList();
	}
	
	public Member findById(Long id)
	{
		System.out.println("레파지토리 : " + em.getDelegate());
		return em.find(Member.class, id);
	}
	
	public Long save(Member member)
	{
		em.persist(member);
		
		return member.getId();
	}
}
