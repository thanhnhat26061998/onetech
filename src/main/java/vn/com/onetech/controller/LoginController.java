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
import vn.com.onetech.dto.Register;
import vn.com.onetech.entity.Role;
import vn.com.onetech.entity.User;
import vn.com.onetech.validation.RegisterValidation;

@Controller
public class LoginController {
	@Autowired 
	private IUserDao userDao;
	
	@Autowired 
	private PasswordEncoder passwordEncoder;
	
	@Autowired
	private IRoleDao roleDao;
	
	@Autowired 
	RegisterValidation registerValidation;
	
	@Autowired
	JavaMailSender emailSender;
	
	@RequestMapping("/login")
	public String login() {
		return "/business/login/login";
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
		
		return "/business/login/register";
	}
	
	@RequestMapping("/registers")
	public String registers(@ModelAttribute("register") Register register,
			Model model, BindingResult bindingResult) {
		registerValidation.validate(register, bindingResult);
		if (bindingResult.hasErrors()) {
			return "/business/login/register";
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
		message.setText("http://localhost:8888/login");
		this.emailSender.send(message);
			
		return "redirect:/login";
	}
	
}
