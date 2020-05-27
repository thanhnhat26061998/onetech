package vn.com.onetech.validation;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

import vn.com.onetech.dao.IUserDao;
import vn.com.onetech.dto.EditProfile;
import vn.com.onetech.dto.Register;
import vn.com.onetech.entity.User;



@Component
public class EditProfileValidation implements Validator {
	
	@Autowired
	private IUserDao userDao;

	@Override
	public boolean supports(Class<?> aClass) {

		return User.class.equals(aClass);
	}

	@Override
	public void validate(Object o, Errors errors) {
		EditProfile user = (EditProfile) o;
		if (user.getEmail()!=null && user.getName()!=null && user.getAddress()!=null 
				&& user.getPhone()!=null && user.getPassword()!=null && user.getCfpassword()!=null) {
			ValidationUtils.rejectIfEmptyOrWhitespace(errors, "email", "NotEmpty", "NotEmpty");
			ValidationUtils.rejectIfEmptyOrWhitespace(errors, "name", "NotEmpty", "NotEmpty");
			ValidationUtils.rejectIfEmptyOrWhitespace(errors, "address", "NotEmpty", "NotEmpty");
			ValidationUtils.rejectIfEmptyOrWhitespace(errors, "phone", "NotEmpty", "NotEmpty");
			ValidationUtils.rejectIfEmptyOrWhitespace(errors, "password", "NotEmpty", "NotEmpty");
			ValidationUtils.rejectIfEmptyOrWhitespace(errors, "cfpassword", "NotEmpty", "NotEmpty");
		}if (!user.getPassword().equals(user.getCfpassword())) {
			ValidationUtils.rejectIfEmptyOrWhitespace(errors, "passwords", "password incorrect", "password incorrect");
		}else {
			ValidationUtils.rejectIfEmptyOrWhitespace(errors, "cfpassword", "NotEmpty", "NotEmpty");
			
		}
		
	}

}
