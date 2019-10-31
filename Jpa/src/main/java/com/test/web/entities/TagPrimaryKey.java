package com.test.web.entities;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.NoArgsConstructor;
import lombok.NonNull;

@Embeddable
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class TagPrimaryKey implements Serializable //extends BaseEntity
{
	private static final long serialVersionUID = 1L;
	
//	@Id
//	@GeneratedValue(strategy=GenerationType.IDENTITY) //@Id annotation 필드에만 적용
	@NonNull
	@Column(name = "seq")
	private Long seq;
	
	@NonNull
	@Column(name = "title", nullable = false, updatable = true)
	private String title;
	
	public TagPrimaryKey(String title)
	{
		this(null, title);
	}
//	
//	public TagPK builder2(String title)
//	{
//		return new TagPK(title);
//	}
}
