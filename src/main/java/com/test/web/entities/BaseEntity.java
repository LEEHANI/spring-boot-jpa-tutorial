package com.test.web.entities;


import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
@MappedSuperclass
public class BaseEntity extends AbstractAuditing
{
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long seq;
	
	@Override
	public String toString()
	{
//		return ToStringBuilder.reflectionToString(this);
		return ToStringBuilder.reflectionToString(this, ToStringStyle.JSON_STYLE);
//		return new ToStringBuilder(this, ToStringStyle.JSON_STYLE).appendSuper(super.toString()).toString();
	}
}
