package jpabook.jpashop.domain;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
public class Member extends BaseEntity {
	@Id @GeneratedValue			// strategy 속성 디폴트: AUTO
	@Column(name = "MEMBER_ID")
	private Long id;

	private String name;

	@Embedded					// 값 타입 (임베디드 타입)
	private Address address;

	@OneToMany(mappedBy = "member")		// 연관관계의 주인: Order.member
	private List<Order> orders = new ArrayList<>();

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Address getAddress() {
		return address;
	}

	public void setAddress(Address address) {
		this.address = address;
	}

	public List<Order> getOrders() {
		return orders;
	}

	public void setOrders(List<Order> orders) {
		this.orders = orders;
	}
}
