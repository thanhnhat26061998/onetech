package vn.com.onetech.controller;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import vn.com.onetech.dao.IProductDao;
import vn.com.onetech.dao.IReviewDao;
import vn.com.onetech.dto.ColorDto;
import vn.com.onetech.dto.ProductDto;
import vn.com.onetech.dto.ReviewDto;
import vn.com.onetech.entity.Product;
import vn.com.onetech.entity.ProductDetail;
import vn.com.onetech.entity.Review;
import vn.com.onetech.entity.User;
import vn.com.onetech.service.IProductDetailService;
import vn.com.onetech.service.IProductService;
import vn.com.onetech.service.IReviewDtoService;

@Controller
public class ProductDetailController {
	
	@Autowired
	private IProductService productService;
	
	@Autowired 
	private IProductDetailService productDetailService;
	
	@Autowired
	private IReviewDtoService reviewDto;
	
	@Autowired
	private IReviewDao reviewDao;
	
	
	@RequestMapping("/productdetail")
	public String productDetail(Model model, @RequestParam("id") int id, HttpSession session) {
		
		if (session.getAttribute("user")!=null) {
			User user = (User) session.getAttribute("user");
			model.addAttribute("user", user);
		}
		
		ProductDto productDto = productDetailService.findProductDtoById(id);
		model.addAttribute("productDto", productDto);
		
		
		List<ReviewDto> review = reviewDto.findAllReviewDto(productDto.getProductId());
		model.addAttribute("review", review);
		
		List<ProductDto> listProductDto = productDetailService.findListProductById(productDto.getProductId());
		model.addAttribute("listProductDto", listProductDto);
		List<ColorDto> color = new ArrayList<ColorDto>();
		for (ProductDto productDto2 : listProductDto) {
			if (productDto2.getRom().equals(productDto.getRom())) {
				ColorDto cl = new ColorDto();
				cl.setId(productDto2.getProductDetailId());
				cl.setColor(productDto2.getColor());
				color.add(cl);
				model.addAttribute("color", color);
			}
		}
		ProductDetail prDt = productDetailService.findById(id);
		model.addAttribute("prDt", prDt);
		return "business/product/productDetail";
	}
	
	
	
	
	@RequestMapping("/review")
	public String review(Model model,  HttpSession session, @RequestParam("prddtid") int prdDetailId, @RequestParam("prdid") int prdId,
			@RequestParam("content") String  content) {
		
		if (session.getAttribute("user")==null) {
			return "redirect:/login";
		}else {
			Product prd = productService.findById(prdId);
			User user = (User) session.getAttribute("user");
			Review rv = new Review();
			rv.setContent(content);
			rv.setProduct(prd);
			rv.setUser(user);
			reviewDao.save(rv);
			
		}
		return "redirect:/productdetail?id="+prdDetailId;
	}
}
