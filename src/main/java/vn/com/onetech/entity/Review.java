package vn.com.onetech.entity;


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import lombok.Data;

@Entity
@Data
@Table(name="review")
public class Review {

	@Id
	@Column(name = "reviewId")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
	private String content;
	private int star;
	@ManyToOne
    @JoinColumn(name="productId")
    private Product product;
}
