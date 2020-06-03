package vn.com.onetech.entity;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import lombok.Data;

@Entity
@Data
@Table(name = "orderDetails")
public class OderDetail {
	@Id
    @Column(name = "orderDetailId")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
	private int quantity;
	private double price;
	private String color;
	private String config;
	private double discountvalue;
	@ManyToOne
    @JoinColumn(name="productId")
    private Product product;
	@OneToMany(mappedBy = "orderDetail")
    private List<Order> order;
}
