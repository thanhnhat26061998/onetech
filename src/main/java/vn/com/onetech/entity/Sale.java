package vn.com.onetech.entity;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;

@Entity
@Data
@Table(name = "sale")
public class Sale {
	 @Id
	 @Column(name = "saleId")
	 @GeneratedValue(strategy = GenerationType.IDENTITY)
	 private int saleId;
	 private String name;
	 private int valuess;
	 private String notes;

}
