package vn.com.onetech.dto;

import org.springframework.stereotype.Component;

import lombok.Data;

@Data
@Component
public class Register {
	private String email;
	private String name;
	private String password;
	private String cfpassword;
	private String address;
	private Long phone;
	private String passwords;
	private String emails;
}
