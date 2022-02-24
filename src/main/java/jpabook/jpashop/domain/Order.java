package jpabook.jpashop.domain;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import static javax.persistence.FetchType.*;
import static javax.persistence.CascadeType.*;

@Entity
@Table(name = "ORDERS")			// DB 키워드 "ORDER" 를 피하기 위함
public class Order extends BaseEntity {
	@Id @GeneratedValue
	@Column(name = "ORDER_ID")
	public Long id;

//	@Column(name = "MEMBER_ID")
//	private Long memberId;
	@ManyToOne(fetch = LAZY)
	@JoinColumn(name = "MEMBER_ID")		// 외래 키
	private Member member;

	@OneToOne(fetch = LAZY, cascade = ALL)		// Order 와 Delivery 의 라이프 사이클 동기화 (Cascade)
	@JoinColumn(name = "DELIVERY_ID")	// 외래 키
	private Delivery delivery;

	// 양방향 연관관계의 주인: OrderItem.order
	@OneToMany(mappedBy = "order", cascade = ALL)	// Order 와 Delivery 의 라이프 사이클 동기화 (Cascade)
	private List<OrderItem> orderItems = new ArrayList<>();

	private LocalDateTime orderDate;

	@Enumerated(EnumType.STRING)
	private OrderStatus status;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public List<OrderItem> getOrderItems() {
		return orderItems;
	}

	// 양방향 연관관계 편의 메소드
	public void addOrderItem(OrderItem orderItem) {
		orderItems.add(orderItem);
		orderItem.setOrder(this);
	}

	public void setOrderItems(List<OrderItem> orderItems) {
		this.orderItems = orderItems;
	}

	public Member getMember() {
		return member;
	}

	public void setMember(Member member) {
		this.member = member;
	}

	public LocalDateTime getOrderDate() {
		return orderDate;
	}

	public void setOrderDate(LocalDateTime orderDate) {
		this.orderDate = orderDate;
	}

	public OrderStatus getStatus() {
		return status;
	}

	public void setStatus(OrderStatus status) {
		this.status = status;
	}

	public Delivery getDelivery() {
		return delivery;
	}

	public void setDelivery(Delivery delivery) {
		this.delivery = delivery;
	}
}
