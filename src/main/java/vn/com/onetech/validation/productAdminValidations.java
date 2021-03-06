package vn.com.onetech.validation;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.NumberFormat;
import org.springframework.format.annotation.NumberFormat.Style;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

import vn.com.onetech.dao.IColorDao;
import vn.com.onetech.dao.IConfigDao;
import vn.com.onetech.dto.ProductDetailAdminDto;
import vn.com.onetech.entity.Product;
import vn.com.onetech.entity.ProductDetail;
import vn.com.onetech.entity.User;
import vn.com.onetech.service.IProductService;



@Component
public class productAdminValidations implements Validator {
	
	
	@Autowired
	private IConfigDao configDao;
	
	@Autowired
	private IColorDao colorDao;
	
	@Autowired IProductService productService;

	@Override
	public boolean supports(Class<?> aClass) {

		return ProductDetail.class.equals(aClass);
	}

	@Override
	public void validate(Object o, Errors errors) {
		ProductDetailAdminDto prd = (ProductDetailAdminDto) o;
		Product prds = productService.findById(prd.getProductId());
		List<ProductDetail> prdDt = prds.getProductDetail();
	

		
		
		if (!String.valueOf(prd.getAmount()).matches("-?\\d+(\\.\\d+)?")) {
			ValidationUtils.rejectIfEmptyOrWhitespace(errors, "amouts", "erros", "chỉ được nhập số");
		}
		if (!String.valueOf(prd.getPrice()).matches("-?\\d+(\\.\\d+)?")) {
			ValidationUtils.rejectIfEmptyOrWhitespace(errors, "prices", "erros", "chỉ được nhập số");
		}
		

		if (prd.getPrice() != null && prd.getAmount()!=null) {
			ValidationUtils.rejectIfEmptyOrWhitespace(errors, "price", "NotEmpty", "NotEmpty");
            ValidationUtils.rejectIfEmptyOrWhitespace(errors, "amount", "NotEmpty", "NotEmpty");
		}
		
		
		
		else {
			errors.rejectValue("price", "Null","Null");
		}
		
	}

}
