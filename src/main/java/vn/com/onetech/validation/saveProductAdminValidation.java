package vn.com.onetech.validation;

import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

import vn.com.onetech.dto.ProductAdminDto;
import vn.com.onetech.entity.Product;


@Component

public class saveProductAdminValidation implements Validator {

	@Override
	public boolean supports(Class<?> aClass) {
		// TODO Auto-generated method stub
		return Product.class.equals(aClass);
	}

	@Override
	public void validate(Object o, Errors errors) {
		ProductAdminDto prd = (ProductAdminDto) o;
		if (prd.getName()==null) {
			ValidationUtils.rejectIfEmptyOrWhitespace(errors, "name", "NotEmpty", "NotEmpty");
		}
		
	}

}
