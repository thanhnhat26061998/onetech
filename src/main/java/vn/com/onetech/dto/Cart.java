package vn.com.onetech.dto;

import lombok.Data;
import vn.com.onetech.entity.Product;

@Data

public class Cart{
	
	private Product product;
	private int quantity = 1;

}
