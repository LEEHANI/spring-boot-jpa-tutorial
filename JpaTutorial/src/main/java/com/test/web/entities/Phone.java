package com.test.web.entities;

import javax.persistence.Column;
import javax.persistence.Entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.Setter;

@Entity
@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
//@RequiredArgsConstructor(staticName= "on")
public class Phone extends BaseEntity
{
	private static final long serialVersionUID = 1L;
	
	@NonNull
	@Column(name = "token", nullable = false, updatable = false)
	private String token;
	
	@NonNull
	@Column(name = "number", nullable = false, updatable = true)
	private String number;
}
