package jpabook.jpashop.domain;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import java.util.Objects;

@Embeddable					// 값 타입 (임베디드 타입) 명시
public class Address {
	@Column(length = 10)
	private String city;

	@Column(length = 20)
	private String street;

	@Column(length = 5)
	private String zipcode;

	public String getCity() {
		return city;
	}

	public String getStreet() {
		return street;
	}

	public String getZipcode() {
		return zipcode;
	}

	/* 값 타입 클래스에서 비즈니스적으로 유의미한 메소드 정의하여 활용 가능 */
	public String fullAddress() {
		return getCity() + " " + getStreet() + " " + getZipcode();
	}

	/* 값 타입의 setter - 정의 X 하거나 private 으로 제한하여 불변 객체 */
	private void setCity(String city) {
		this.city = city;
	}

	private void setStreet(String street) {
		this.street = street;
	}

	private void setZipcode(String zipcode) {
		this.zipcode = zipcode;
	}

	/* 동등성(equivalent) 비교, 조회 및 삭제를 위한 equals(), hashCode() */
	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (o == null || getClass() != o.getClass()) return false;
		Address address = (Address) o;
		return Objects.equals(getCity(), address.getCity()) &&
				Objects.equals(getStreet(), address.getStreet()) &&
				Objects.equals(getZipcode(), address.getZipcode());
	}

	@Override
	public int hashCode() {
		return Objects.hash(getCity(), getStreet(), getZipcode());
	}
}
