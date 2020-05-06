package vn.com.onetech.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class BusinessController {
	@RequestMapping("/index")
	public String index() {
		return "business/index/index";
	}
	
}
