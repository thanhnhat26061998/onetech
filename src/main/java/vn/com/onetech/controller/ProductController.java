package vn.com.onetech.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import vn.com.onetech.entity.Product;
import vn.com.onetech.service.IProductService;

@RestController
public class ProductController {
	
	@Autowired
	private IProductService productService;
	
	
	@GetMapping("getAllProduct")
		public ResponseEntity<?> getAllProduct(){
			List<Product> prd = productService.findAllProduct();
			return new ResponseEntity<List<Product>>(prd, HttpStatus.OK);
		}
	

}
