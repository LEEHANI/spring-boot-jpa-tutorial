package com.test.web.entities;

import java.io.Serializable;
import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.EntityListeners;
import javax.persistence.MappedSuperclass;

import org.springframework.data.annotation.CreatedBy;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedBy;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

@MappedSuperclass
@EntityListeners(value = AuditingEntityListener.class)
public abstract class AbstractAuditing implements Serializable
{
	private static final long serialVersionUID = 1L;
	
	@CreatedDate
	@Column(name = "created_date", nullable = false, updatable = false)
    private LocalDateTime createdDate;
	
	@CreatedBy
	@Column(name = "created_by", nullable = true, updatable = true)
	private String createdBy;
	
	@LastModifiedDate
	@Column(name = "last_modified_date", nullable = false, updatable = true)
    private LocalDateTime lastModifiedDate;
	
	@LastModifiedBy
	@Column(name = "last_modified_by", nullable = true, updatable = true)
	private String lastModifiedBy;
}
