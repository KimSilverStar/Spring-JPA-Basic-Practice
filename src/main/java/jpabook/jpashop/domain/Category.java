package jpabook.jpashop.domain;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

import static javax.persistence.FetchType.*;

@Entity
public class Category extends BaseEntity {
	@Id
	@GeneratedValue
	private Long id;

	private String name;

	// 상위 카테고리에 다수의 하위 카테고리
	@ManyToOne(fetch = LAZY)		// Category 본인 vs 상위 카테고리
	@JoinColumn(name = "PARENT_ID")
	private Category parent;		// 상위 카테고리

	@OneToMany(mappedBy = "parent")		// Category 본인 vs 하위 카테고리
	private List<Category> child = new ArrayList<>();	// 하위 카테고리

	@ManyToMany
	@JoinTable(name = "CATEGORY_ITEM",
			joinColumns = @JoinColumn(name = "CATEGORY_ID"),
			inverseJoinColumns = @JoinColumn(name = "ITEM_ID")
	)		// 연결 테이블
	private List<Item> items = new ArrayList<>();		// 양방향 연관관계의 주인

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

	public Category getParent() {
		return parent;
	}

	public void setParent(Category parent) {
		this.parent = parent;
	}

	public List<Category> getChild() {
		return child;
	}

	public void setChild(List<Category> child) {
		this.child = child;
	}

	public List<Item> getItems() {
		return items;
	}

	public void setItems(List<Item> items) {
		this.items = items;
	}
}
