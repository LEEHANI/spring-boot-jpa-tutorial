package com.example.demo.entity;

import javax.persistence.Column;
import javax.persistence.Entity;

import lombok.Getter;

@Entity
@Getter
public class Album extends Item{
	@Column
	private String artist;
	@Column
	private String etc;
}
