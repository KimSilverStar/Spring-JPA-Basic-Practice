package jpabook.jpashop.domain;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "ORDERS")			// DB 키워드 "ORDER" 를 피하기 위함
public class Order extends BaseEntity {
	@Id @GeneratedValue
	@Column(name = "ORDER_ID")
	public Long id;

//	@Column(name = "MEMBER_ID")
//	private Long memberId;
	@ManyToOne
	@JoinColumn(name = "MEMBER_ID")		// 외래 키
	private Member member;

	@OneToOne
	@JoinColumn(name = "DELIVERY_ID")	// 외래 키
	private Delivery delivery;

	@OneToMany(mappedBy = "order")		// 양방향 연관관계의 주인: OrderItem.order
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
