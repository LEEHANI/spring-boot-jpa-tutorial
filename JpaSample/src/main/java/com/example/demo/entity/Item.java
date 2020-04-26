package com.example.demo.entity;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.OneToMany;

import com.example.demo.Exception.NotEnoughStockException;

import lombok.Getter;

@Entity
@Inheritance(strategy=InheritanceType.SINGLE_TABLE)
@Getter
public abstract class Item {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	protected Long id;
	
	@Column
	protected String name;
	
	@Column
	protected int price;
	
	@Column
	protected int stockQuantity;
	
	@OneToMany(mappedBy = "item")
	private List<CategoryItem> categoryItems = new ArrayList<>();
	
	public void addStock(int count)
	{
		this.stockQuantity += count;
	}
	
	public void removeStock(int count)
	{
		if(this.stockQuantity < count)
		{
			throw new NotEnoughStockException();
		}
		
		this.stockQuantity -= count;
	}
}
