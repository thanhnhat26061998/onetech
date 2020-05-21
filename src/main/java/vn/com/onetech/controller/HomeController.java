package vn.com.onetech.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import vn.com.onetech.dto.ProductDto;
import vn.com.onetech.entity.ProductDetail;
import vn.com.onetech.entity.User;
import vn.com.onetech.service.IProductDetailService;


@Controller
public class HomeController {
	
	@Autowired
	private IProductDetailService productDetailService;
	

	
	@GetMapping("/home")
	public String listProducts(Model model, @RequestParam("page") Optional<Integer> page,
			@RequestParam("size") Optional<Integer> size, HttpSession session) {
		final int currentPage = page.orElse(1);
        final int pageSize = size.orElse(8);
        Page<ProductDto> productPage = productDetailService.findPaginated(PageRequest.of(currentPage-1, pageSize));
        model.addAttribute("productPage", productPage);
		int totalPage = productPage.getTotalPages();
		if (totalPage>0) {
			List<Integer> pageNumbers = IntStream.rangeClosed(1, totalPage)
					.boxed()
	                .collect(Collectors.toList());
			model.addAttribute("pageNumbers", pageNumbers);
		}
		if (session.getAttribute("user")!=null) {
			User user = (User) session.getAttribute("user");
			model.addAttribute("user", user);
		}
		return "business/home/shop";
	}
	
	@GetMapping("/search")
	public String search(@RequestParam("name") String name, Model model,HttpSession session) {
		List<ProductDto> product = productDetailService.findAllPrd();
		List<ProductDto> productPage = new ArrayList<ProductDto>();
		for (ProductDto productDto : product) {
			if (productDto.getProductName().equals(name)) {
				productPage.add(productDto);
				model.addAttribute("productPage", productPage);
			}
			
		}
		
		if (session.getAttribute("user")!=null) {
			User user = (User) session.getAttribute("user");
			model.addAttribute("user", user);
		}
		
		return "business/home/shop";
	}
	@GetMapping("/filterByBrand")
	public String filterByBrand(@RequestParam("name") String name, Model model, HttpSession session) {
		List<ProductDto> product = productDetailService.findAllPrd();
		List<ProductDto> productPage = new ArrayList<ProductDto>();
		for (ProductDto productDto : product) {
			if (productDto.getBrandName().equals(name)) {
				productPage.add(productDto);
				model.addAttribute("productPage", productPage);
			}
			
		}
		
		if (session.getAttribute("user")!=null) {
			User user = (User) session.getAttribute("user");
			model.addAttribute("user", user);
		}
		
		return "business/home/shop";
	}
	
	@GetMapping("/filterByPrice")
	public String filterByPrice(@RequestParam("price") double price, Model model, HttpSession session) {
		List<ProductDto> product = productDetailService.findAllPrd();
		List<ProductDto> productPage = new ArrayList<ProductDto>();
		for (ProductDto productDto : product) {
			if (productDto.getPriceAfter() <= price) {
				productPage.add(productDto);
				model.addAttribute("productPage", productPage);
			}
			
		}
		
		if (session.getAttribute("user")!=null) {
			User user = (User) session.getAttribute("user");
			model.addAttribute("user", user);
		}
		
		return "business/home/shop";
	}

	

}
