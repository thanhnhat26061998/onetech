package vn.com.onetech.dto;

import org.springframework.stereotype.Component;

import lombok.Data;

@Data
@Component
public class ConfigDto {
	int id;
	String rom;
	double priceAfter;
	int configId;
}
