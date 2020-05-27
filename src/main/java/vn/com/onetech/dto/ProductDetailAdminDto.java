package vn.com.onetech.dto;

import org.springframework.stereotype.Component;

import lombok.Data;

@Component
@Data
public class ProductDetailAdminDto {
	
	private int id;
	private int amount;
	private double price;
	private int colorId;
	private int configId;
	private int productId;
	private String colorVsConfig;
	private String image;

}
