package com.test.web.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;

import com.test.web.entities.BaseEntity;
import com.test.web.repositories.CommonRepository;

public abstract class CommonService<T extends BaseEntity>
{
	@Autowired
	public CommonRepository<T> repository;
	
	public T save(T entity)
	{
		return repository.save(entity);
	}
	
	public T getOne(Long seq)
	{
		return repository.getOne(seq);
	}
	
	public List<T> getList()
	{
		return repository.findAll();
	}
	
	public T delete(Long seq)
	{
		Optional<T> t = repository.findById(seq);
		
		repository.delete(t.get());
		
		return t.get();
	}
}
