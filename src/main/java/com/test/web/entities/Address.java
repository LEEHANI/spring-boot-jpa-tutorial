package com.test.web.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;

import org.hibernate.envers.NotAudited;

import com.fasterxml.jackson.annotation.JsonBackReference;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
@RequiredArgsConstructor(staticName= "on")
public class Address extends BaseEntity
{
	private static final long serialVersionUID = 1L;
	
	@NonNull
	@Column(name = "city", nullable = false, updatable = true)
	private String city;
	
	@NonNull
	@Column(name = "street", nullable = false, updatable = true)
	private String street;
	
	@Column(name = "zipcode", nullable = true, updatable = true)
	private String zipcode;
	
	@Column(name = "bigo", nullable = true, updatable = true)
	private String bigo;
	
	@NotAudited
	@OneToOne
	@JoinColumn( name = "user_seq")
	@JsonBackReference
	private User user;
}
