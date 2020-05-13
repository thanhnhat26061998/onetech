package vn.com.onetech.controller;


import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;


import vn.com.onetech.entity.Product;
import vn.com.onetech.service.IProductService;

@Controller

public class HomeController {
	@Autowired 
	private IProductService productService;
	
	
	@RequestMapping("/home")
	public String listProducts(Model model, @RequestParam("page") Optional<Integer> page, @RequestParam("size") Optional<Integer> size) {
		final int currentPage = page.orElse(1);
        final int pageSize = size.orElse(10);
        int amount = productService.getAmoutAll();
        model.addAttribute("amout", amount);
        Page<Product> productPage = productService.findPaginated(PageRequest.of(currentPage-1, pageSize));
        model.addAttribute("productPage", productPage);
		int totalPage = productPage.getTotalPages();
		if (totalPage>0) {
			List<Integer> pageNumbers = IntStream.rangeClosed(1, totalPage)
					.boxed()
	                .collect(Collectors.toList());
			model.addAttribute("pageNumbers", pageNumbers);
		}
		return "business/home/shop";
	}
	
	
	@RequestMapping("/search")
	public String listProductsBymane(Model model, @RequestParam("page") Optional<Integer> page,
			@RequestParam("name") String name,  @RequestParam("price") int price,
			@RequestParam("size") Optional<Integer> size) {
		final int currentPage = page.orElse(1);
        final int pageSize = size.orElse(10);
        int amount = productService.getAmoutByName(name);
        model.addAttribute("amout", amount);
        Page<Product> productPage = productService.productByName2(name, PageRequest.of(currentPage-1, pageSize), price);
        model.addAttribute("productPage", productPage);
		int totalPage = productPage.getTotalPages();
		if (totalPage>0) {
			List<Integer> pageNumbers = IntStream.rangeClosed(1, totalPage)
					.boxed()
	                .collect(Collectors.toList());
			model.addAttribute("pageNumbers", pageNumbers);
		}
		return "business/home/shop";
	}
	
	@RequestMapping("/homes")
	public String listProductsByNameMenu(Model model, @RequestParam("page") Optional<Integer> page, @RequestParam("name") String name,
			@RequestParam("size") Optional<Integer> size) {
		final int currentPage = page.orElse(1);
        final int pageSize = size.orElse(10);
        int amount = productService.getAmoutByNameMenu(name);
        model.addAttribute("amout", amount);
        Page<Product> productPage = productService.findPrdBynameMenu(name, PageRequest.of(currentPage-1, pageSize));
        model.addAttribute("productPage", productPage);
		int totalPage = productPage.getTotalPages();
		if (totalPage>0) {
			List<Integer> pageNumbers = IntStream.rangeClosed(1, totalPage)
					.boxed()
	                .collect(Collectors.toList());
			model.addAttribute("pageNumbers", pageNumbers);
		}
		return "business/home/shop";
	}
	
	
	@RequestMapping("/homee")
	public String listProductsByNamePirce(Model model, @RequestParam("page") Optional<Integer> page, @RequestParam("price") int price,
			@RequestParam("size") Optional<Integer> size) {
		final int currentPage = page.orElse(1);
        final int pageSize = size.orElse(10);
        int amount = productService.getAmoutByPrice(price);
        model.addAttribute("amout", amount);
        Page<Product> productPage = productService.findPrdByPrice(price, PageRequest.of(currentPage-1, pageSize));
        model.addAttribute("productPage", productPage);
		int totalPage = productPage.getTotalPages();
		if (totalPage>0) {
			List<Integer> pageNumbers = IntStream.rangeClosed(1, totalPage)
					.boxed()
	                .collect(Collectors.toList());
			model.addAttribute("pageNumbers", pageNumbers);
		}
		return "business/home/shop";
	}
	
	
	
}
