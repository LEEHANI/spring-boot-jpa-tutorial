package com.example.demo.entity;

import javax.persistence.Column;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotNull;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Builder
public class Member {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long id;
	
	@Column
	private String name;
	
	@Embedded
	private Address address;
	
    public static Member cretaeMember(String name, String city, String street, String zipcode) {
    	return Member.builder()
	    			.name(name)
	    			.address(new Address(city, street, zipcode))
	    			.build();
     }
	
    public void changeName(String name)
    {
    	this.name = name;
    }
}
