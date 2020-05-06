package vn.com.onetech.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import vn.com.onetech.entity.Product;
import vn.com.onetech.service.IProductService;

@Controller

public class HomeController {
	@Autowired 
	private IProductService productService;
	
	
	@RequestMapping("/home")
	public ModelAndView home() {
		ModelAndView mav = new ModelAndView();
		List<Product> listProduct =  productService.findAllProduct();
		mav.addObject("listProducts", listProduct);
		mav.setViewName("business/home/home");
		return mav;
	}
}
