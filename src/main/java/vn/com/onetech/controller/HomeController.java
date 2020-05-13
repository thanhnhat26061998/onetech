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
	
	
	@RequestMapping("/homie")
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
			@RequestParam("name") String name,  @RequestParam("price") Optional<Integer> price,
			@RequestParam("size") Optional<Integer> size) {
		final int currentPage = page.orElse(1);
        final int pageSize = size.orElse(10);
        int prices= page.orElse(0);
        if (prices!=0) {
        	int amount = productService.getAmoutByName(name);
	        model.addAttribute("amout", amount);
        	Page<Product> productPage = productService.productByName2(name, PageRequest.of(currentPage-1, pageSize), prices);
        	model.addAttribute("productPage", productPage);
    		int totalPage = productPage.getTotalPages();
    		if (totalPage>0) {
    			List<Integer> pageNumbers = IntStream.rangeClosed(1, totalPage)
    					.boxed()
    	                .collect(Collectors.toList());
    			model.addAttribute("pageNumbers", pageNumbers);
    		}
		}else {
			int amount = productService.getAmoutByName(name);
	        model.addAttribute("amout", amount);
			Page<Product> productPage = productService.productByName(name, PageRequest.of(currentPage-1, pageSize));
        	model.addAttribute("productPage", productPage);
    		int totalPage = productPage.getTotalPages();
    		if (totalPage>0) {
    			List<Integer> pageNumbers = IntStream.rangeClosed(1, totalPage)
    					.boxed()
    	                .collect(Collectors.toList());
    			model.addAttribute("pageNumbers", pageNumbers);
    		}
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
	
	
	//home
	@RequestMapping("/home")
	public String getProduct(Model model, @RequestParam("page") Optional<Integer> page, 
			@RequestParam("size") Optional<Integer> size, @RequestParam("price") Optional<Integer> prices,
			@RequestParam("name") Optional<String> names, @RequestParam("typeName") Optional<String> typeNames) {
		final int currentPage = page.orElse(1);
        final int pageSize = size.orElse(10);
        final int price = prices.orElse(0);
        final String name = names.orElse(null);
        final String typeName = typeNames.orElse(null);
        model.addAttribute("price", price);
        model.addAttribute("name", name);
        model.addAttribute("typeName", typeName);
        if (typeName==null&&name==null&&price==0) {
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
    		model.addAttribute("price", price);
            model.addAttribute("name", name);
            model.addAttribute("typeName", typeName);
			
		}
        if (typeName!=null&&name==null&&price==0) {
        	int amount = productService.getAmoutByNameMenu(typeName);
            model.addAttribute("amout", amount);
            Page<Product> productPage = productService.findPrdBynameMenu(typeName, PageRequest.of(currentPage-1, pageSize));
            model.addAttribute("productPage", productPage);
    		int totalPage = productPage.getTotalPages();
    		if (totalPage>0) {
    			List<Integer> pageNumbers = IntStream.rangeClosed(1, totalPage)
    					.boxed()
    	                .collect(Collectors.toList());
    			model.addAttribute("pageNumbers", pageNumbers);
    		}
		}
        if (typeName==null&&name==null&&price!=0) {
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
			
		}
        if (typeName==null&&name!=null&&price==0) {
			int amount = productService.getAmoutByName(name);
	        model.addAttribute("amout", amount);
			Page<Product> productPage = productService.productByName(name, PageRequest.of(currentPage-1, pageSize));
        	model.addAttribute("productPage", productPage);
    		int totalPage = productPage.getTotalPages();
    		if (totalPage>0) {
    			List<Integer> pageNumbers = IntStream.rangeClosed(1, totalPage)
    					.boxed()
    	                .collect(Collectors.toList());
    			model.addAttribute("pageNumbers", pageNumbers);
    		}
		}
        if (typeName==null&&name!=null&&price!=0) {
        	int amount = productService.getAmoutByPriceAndName(price,name);
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
			
		}
		return"business/home/shop";
	}
	
	
	
}
