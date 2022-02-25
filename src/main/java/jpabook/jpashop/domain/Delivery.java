package jpabook.jpashop.domain;

import javax.persistence.*;

import static javax.persistence.FetchType.*;

@Entity
public class Delivery extends BaseEntity {
	@Id @GeneratedValue
	@Column(name = "DELIVERY_ID")
	private Long id;

	@OneToOne(mappedBy = "delivery", fetch = LAZY)	// 양방향 연관관계의 주인: Order.delivery
	private Order order;

	@Embedded					// 값 타입 (임베디드 타입)
	private Address address;

	private DeliveryStatus status;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Order getOrder() {
		return order;
	}

	public void setOrder(Order order) {
		this.order = order;
	}

	public Address getAddress() {
		return address;
	}

	public void setAddress(Address address) {
		this.address = address;
	}

	public DeliveryStatus getStatus() {
		return status;
	}

	public void setStatus(DeliveryStatus status) {
		this.status = status;
	}
}
