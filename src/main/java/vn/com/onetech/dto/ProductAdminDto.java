package vn.com.onetech.dto;

import org.springframework.stereotype.Component;

import lombok.Data;

@Data
@Component
public class ProductAdminDto {
	private int id;
	private String name;
	private String promotion;
	private String trademark;
	private int promotionId;
	private int trademarkId;
	private String note;
}
