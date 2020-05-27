package vn.com.onetech.validation;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

import vn.com.onetech.dao.IColorDao;
import vn.com.onetech.dao.IConfigDao;
import vn.com.onetech.dto.ProductDetailAdminDto;
import vn.com.onetech.entity.Product;
import vn.com.onetech.entity.ProductDetail;
import vn.com.onetech.service.IProductService;



@Component
public class productAdminValidation implements Validator {
	
	
	@Autowired
	private IConfigDao configDao;
	
	@Autowired
	private IColorDao colorDao;
	
	@Autowired IProductService productService;

	@Override
	public boolean supports(Class<?> aClass) {

		return ProductDetailAdminDto.class.equals(aClass);
	}

	@Override
	public void validate(Object o, Errors errors) {
		ProductDetailAdminDto prd = (ProductDetailAdminDto) o;
		Product prds = productService.findById(prd.getProductId());
		List<ProductDetail> prdDt = prds.getProductDetail();
		for (ProductDetail productDetail : prdDt) {
			if (productDetail.getColor().getId() == prd.getColorId() &&
					productDetail.getConfigurator().getId()== prd.getConfigId()) {
				ValidationUtils.rejectIfEmptyOrWhitespace(errors, "colorVsConfig", "Sản phẩm đã tồn tại", "Sản phẩm đã tồn tại");
			}
		}
		if (prd.getPrice() != 0 && prd.getAmount()!=0) {
			ValidationUtils.rejectIfEmptyOrWhitespace(errors, "price", "NotEmpty", "NotEmpty");
            ValidationUtils.rejectIfEmptyOrWhitespace(errors, "amount", "NotEmpty", "NotEmpty");
		}
		
		else {
			errors.rejectValue("price", "Null","Null");
		}
		
	}

}
