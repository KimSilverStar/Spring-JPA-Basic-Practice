package jpabook.jpashop.domain;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "ORDERS")			// DB 키워드 "ORDER" 를 피하기 위함
public class Order {
	@Id @GeneratedValue
	@Column(name = "ORDER_ID")
	public Long id;

	@Column(name = "MEMBER_ID")
	private Long memberId;
	private LocalDateTime orderDate;

	@Enumerated(EnumType.STRING)
	private OrderStatus status;
}
