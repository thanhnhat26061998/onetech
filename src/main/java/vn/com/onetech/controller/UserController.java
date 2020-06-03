package vn.com.onetech.controller;

import java.util.HashSet;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import vn.com.onetech.dao.IRoleDao;
import vn.com.onetech.dao.IUserDao;
import vn.com.onetech.dto.EditProfile;
import vn.com.onetech.dto.Register;
import vn.com.onetech.entity.Role;
import vn.com.onetech.entity.User;
import vn.com.onetech.validation.EditProfileValidation;
import vn.com.onetech.validation.RegisterValidation;

@Controller
public class UserController {
	@Autowired 
	private IUserDao userDao;
	
	@Autowired 
	private PasswordEncoder passwordEncoder;
	
	@Autowired
	private IRoleDao roleDao;
	
	@Autowired 
	RegisterValidation registerValidation;
	
	@Autowired
	EditProfileValidation editProfileValidation;
	
	@Autowired
	JavaMailSender emailSender;
	
	@RequestMapping("/login")
	public String login() {
		return "/business/user/login";
	}
	
	@RequestMapping("/logout")
	public String logout(HttpSession session) {
		if (session.getAttribute("user")!=null) {
			session.removeAttribute("user");
		}
		return "redirect:/home";
	}
	
	@RequestMapping("/register")
	public String register(Model model) {
		Register register = new Register();
		model.addAttribute("register", register);
		
		return "/business/user/register";
	}
	
	@RequestMapping("/registers")
	public String registers(@ModelAttribute("register") Register register,
			Model model, BindingResult bindingResult) {
		registerValidation.validate(register, bindingResult);
		if (bindingResult.hasErrors()) {
			return "/business/user/register";
		}		
		User user = new User();
		user.setEmail(register.getEmail());
		user.setName(register.getName());
		user.setAddress(register.getAddress());
		user.setPhone(register.getPhone());
		user.setPassword(passwordEncoder.encode(register.getPassword()));
		HashSet<Role> roles = new HashSet<>();
		roles.add(roleDao.findByName("ROLE_MEMBER"));
		user.setRoles(roles);
		userDao.save(user);
		
		SimpleMailMessage message = new SimpleMailMessage();
		message.setTo(register.getEmail());
		message.setText("Đăng ký thành công!");
		this.emailSender.send(message);
			
		return "redirect:/login";
	}
	
	@RequestMapping("/editprofile")
	public String editProfile(Model model, HttpSession session) {
		EditProfile register = new EditProfile();
		User user = (User) session.getAttribute("user");
		register.setId(user.getId());
		register.setEmail(user.getEmail());
		register.setName(user.getName());
		register.setAddress(user.getAddress());
		register.setPhone(user.getPhone());
		register.setPassword(user.getPassword());
		register.setCfpassword(user.getPassword());
		
		model.addAttribute("register", register);
		session.removeAttribute("user");
		
		return "/business/user/editProfile";
	}
	@RequestMapping("/editprofiles")
	public String editprofiles(@ModelAttribute("register") EditProfile register,
			Model model, BindingResult bindingResult,  HttpSession session) {
		editProfileValidation.validate(register, bindingResult);
		if (bindingResult.hasErrors()) {
			return "/business/user/editProfile";
		}		
		User user = new User();
		user.setId(register.getId());
		user.setEmail(register.getEmail());
		user.setName(register.getName());
		user.setAddress(register.getAddress());
		user.setPhone(register.getPhone());
		user.setPassword(passwordEncoder.encode(register.getPassword()));
		HashSet<Role> roles = new HashSet<>();
		roles.add(roleDao.findByName("ROLE_MEMBER"));
		user.setRoles(roles);
		userDao.save(user);
		
		session.setAttribute("user", user);
			
		return "redirect:/home";
	}
	@RequestMapping("/403")
	public String erros() {
		return "/403";
	}
	
	
}
