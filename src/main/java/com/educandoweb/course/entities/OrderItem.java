package com.educandoweb.course.entities;

import java.io.Serializable;

import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import com.educandoweb.course.entities.pk.OrderItemPk;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
@Entity
@Table(name= "tb_order_item")
public class OrderItem implements Serializable {
	
	
	private static final long serialVersionUID = 1L;

	@EqualsAndHashCode.Include
	@EmbeddedId
	private OrderItemPk id;
	
	@Getter
	@Setter
	private Integer quantity;
	
	@Getter
	@Setter
	private Double price;

	public OrderItem(Order order , Product product ,Integer quantity, Double price) {
		super();
		id.setOrder(order);
		id.setProduct(product);
		this.quantity = quantity;
		this.price = price;
	}
	
	public Order getOrder() {
		return id.getOrder();
	}
	
	public void setOrder(Order order) {
		 id.setOrder(order);
		}
	public Product getProduct() {
		return id.getProduct();
		}
	public void setProduct(Product product){
		id.setProduct(product);
		
	}
	
	
}