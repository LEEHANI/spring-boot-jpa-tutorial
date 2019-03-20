package com.test.web.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.NoRepositoryBean;

import com.test.web.entities.BaseEntity;

@NoRepositoryBean
public interface CommonRepository<T extends BaseEntity> extends JpaRepository<T, Long>
{

}
