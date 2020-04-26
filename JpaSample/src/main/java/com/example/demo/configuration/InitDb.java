package com.example.demo.configuration;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.persistence.EntityManager;

import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import com.example.demo.entity.Book;
import com.example.demo.entity.Delivery;
import com.example.demo.entity.Member;
import com.example.demo.entity.Order;
import com.example.demo.entity.OrderItem;

import lombok.RequiredArgsConstructor;

/**
 * 총 주문 2개
 * userA : JPA1 JP2 주문
 * userB : SPRING1 SPRING2 주문
 * 
 *
 */

//@Component
@RequiredArgsConstructor
public class InitDb {
   
   private final InitService initService;
   
   //스프링 빈이 다 등록되고나서 호출됨.
   @PostConstruct
   public void init() {
      initService.dbInit1();
      initService.dbInit2();
   }
   
   @Component
   @Transactional
   @RequiredArgsConstructor
   static class InitService {
      private final EntityManager em;
      
      public void dbInit1() {
         Member member = Member.cretaeMember("userA", "서울", "1", "1111");
         em.persist(member);
         
         Book book1 = Book.createBook("JPA1 BOOK", 10000, 100);
         em.persist(book1);
         
         Book book2 = Book.createBook("JPA2 BOOK", 20000, 200);
         em.persist(book2);
         
         OrderItem orderItem1 = OrderItem.createOrderItem(book1, 10000, 1);
         OrderItem orderItem2 = OrderItem.createOrderItem(book2, 20000, 2);
         
         List<OrderItem> orderItems = new ArrayList<>();
         orderItems.add(orderItem1);
         orderItems.add(orderItem2);
         
         Delivery delivery = Delivery.createDelivery(member);
         Order order = Order.createOrder(member, delivery, orderItems);
         em.persist(order);
      }
      
      public void dbInit2() {
         Member member = Member.cretaeMember("userB", "진주", "2", "2222");
         em.persist(member);
         
         Book book1 = Book.createBook("SPRING1 BOOK", 20000, 200);
         em.persist(book1);
         Book book2 = Book.createBook("SPRING2 BOOK", 40000, 300);
         em.persist(book2);
         
         OrderItem orderItem1 = OrderItem.createOrderItem(book1, 20000, 3);
         OrderItem orderItem2 = OrderItem.createOrderItem(book2, 40000, 4);
         
         List<OrderItem> orderItems = new ArrayList<>();
         orderItems.add(orderItem1);
         orderItems.add(orderItem2);
         
         Delivery delivery = Delivery.createDelivery(member);
         Order order = Order.createOrder(member, delivery, orderItems);
         em.persist(order);
      }
   }
}