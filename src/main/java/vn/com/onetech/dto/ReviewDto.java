package vn.com.onetech.dto;

import org.springframework.stereotype.Component;

import lombok.Data;

@Component
@Data
public class ReviewDto {
	
	private int productId;
	private String conten;
	private int userId;
	private String userName;

}
