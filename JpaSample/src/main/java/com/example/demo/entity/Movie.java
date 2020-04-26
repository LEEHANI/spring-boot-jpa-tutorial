package com.example.demo.entity;

import javax.persistence.Column;
import javax.persistence.Entity;

import lombok.Getter;

@Entity
@Getter
public class Movie extends Item{
	@Column
	private String director;
	@Column
	private String actor;
}