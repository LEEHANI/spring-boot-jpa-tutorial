package com.example.demo.repository;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Repository;

import com.example.demo.entity.Order;

@Repository
public class OrderRepository 
{
	@PersistenceContext
	private EntityManager em;
	
	public List<Order> findAll()
	{
		return em.createQuery("SELECT o FROM Order o", Order.class).getResultList();
	}
}
