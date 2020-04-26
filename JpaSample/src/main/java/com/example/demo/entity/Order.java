package com.example.demo.entity;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import com.example.demo.enums.DeliveryStatus;
import com.example.demo.enums.OrderStatus;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Builder.Default;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor
@Getter
@Builder
@Table(name = "orders")
public class Order 
{
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@Column
	private LocalDateTime orderDate;

	@Column
	@Enumerated(EnumType.STRING)
	private OrderStatus status;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "member_id")
	private Member member;

	@OneToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	@JoinColumn(name = "delivery_id")
	private Delivery delivery;

	@Default
	@OneToMany(fetch = FetchType.LAZY, mappedBy = "order", cascade = CascadeType.ALL)
	private List<OrderItem> orderItems = new ArrayList<>();

	public void addItem(OrderItem orderItem) {
		orderItems.add(orderItem);
		orderItem.setOrder(this);
	}

	// == 생성 메서드 ==//
	public static Order createOrder(Member member, Delivery delivery, List<OrderItem> orderItems) {
		Order order = Order.builder()
						.member(member)
						.delivery(delivery)
						.status(OrderStatus.ORDER)
						.orderDate(LocalDateTime.now())
						.orderItems(orderItems).build();

		return order;
	}

	// == 비즈니스 로직 ==//
	/**
	 * 주문 취소
	 */
	public void cancel() 
	{
		if (delivery.getStatus() == DeliveryStatus.COMP) 
		{
			throw new IllegalStateException("이미 배송 완료된 상품은 취소가 불가능합니다.");
		}

		this.status = OrderStatus.CANCEL;
		for (OrderItem orderItem : orderItems) {
			orderItem.cancel();
		}
	}

	// ==조회 로직==//
	/**
	 * 전체 주문 가격 조회
	 */
	public int getTotalPrice() 
	{
		int totalPrice = 0;
		
		for (OrderItem orderItem : orderItems) 
		{
			totalPrice += orderItem.getTotalPrice();
		}

		return totalPrice;
	}
}
