package com.jvs.hibernate.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "ITEMS")
public class Item {
	//--------------------------------------------------------------------------
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="ITEM_ID")
	private Long itemId;

	@Column(name="PRODUCT_NAME")
	private String productName;

	@Column(name="PRICE")
	private Double price;

	@Column(name="QUANTITY")
	private Integer quantity;

	@ManyToOne
	@JoinColumn(name = "ORDER_ID", insertable=false, updatable=false, nullable=false)
	private Order order;
	//--------------------------------------------------------------------------
	public Item() {}
	
	public Item(String productName) {
		super();
		this.productName = productName;
	}	
	//--------------------------------------------------------------------------
	
	public Long getItemId() {
		return itemId;
	}

	public void setItemId(Long itemId) {
		this.itemId = itemId;
	}

	public Order getOrder() {
		return order;
	}

	public void setOrder(Order order) {
		this.order = order;
	}

	public String getProductName() {
		return productName;
	}

	public void setProductName(String productName) {
		this.productName = productName;
	}

	public Double getPrice() {
		return price;
	}

	public void setPrice(Double price) {
		this.price = price;
	}

	public Integer getQuantity() {
		return quantity;
	}

	public void setQuantity(Integer quantity) {
		this.quantity = quantity;
	}

	@Override
	public String toString() {
		return "Item [itemId=" + itemId + ", productName=" + productName + ", price=" + price + ", quantity=" + quantity + ", order=" + order + "]";
	}
	
}
