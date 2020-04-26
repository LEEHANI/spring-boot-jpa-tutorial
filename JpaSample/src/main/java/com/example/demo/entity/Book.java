package com.example.demo.entity;

import javax.persistence.Column;
import javax.persistence.Entity;

import com.example.demo.entity.Delivery.DeliveryBuilder;
import com.example.demo.enums.DeliveryStatus;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Builder
public class Book extends Item {
	@Column
	private String author;
	@Column
	private String isbn;
	
    public static Book createBook(String name, int price, int quantity) 
    {
        Book book = new Book();
        book.name = name;
        book.price = price;
        book.stockQuantity = quantity;
        
        return book;
     }
}
