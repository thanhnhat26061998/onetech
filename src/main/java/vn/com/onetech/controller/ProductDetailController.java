package vn.com.onetech.controller;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import vn.com.onetech.dao.IProductDao;
import vn.com.onetech.entity.Product;
import vn.com.onetech.service.IProductService;

@Controller
public class ProductDetailController {
	
	@Autowired
	private IProductService productService;
	
	@GetMapping("/product")
	public ModelAndView product(@RequestParam(name="id") int id) {
		ModelAndView mav = new ModelAndView();
		Product prd = productService.findById(id);
		mav.addObject("prd", prd);
		mav.setViewName("business/product/productDetail");
		return mav;
	}

}
