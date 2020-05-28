package vn.com.onetech.controller;

import java.awt.Image;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;


import vn.com.onetech.dao.IColorDao;
import vn.com.onetech.dao.IConfigDao;
import vn.com.onetech.dao.IImageDao;
import vn.com.onetech.dao.IProductDao;
import vn.com.onetech.dao.IProductDetailDao;
import vn.com.onetech.dto.MyUploadForm;
import vn.com.onetech.dto.ProductAdminDto;
import vn.com.onetech.dto.ProductDetailAdminDto;
import vn.com.onetech.entity.Color;
import vn.com.onetech.entity.Configurator;
import vn.com.onetech.entity.Images;
import vn.com.onetech.entity.Product;
import vn.com.onetech.entity.ProductDetail;
import vn.com.onetech.entity.User;
import vn.com.onetech.service.IProductService;
import vn.com.onetech.service.ImageService;
import vn.com.onetech.validation.productAdminValidation;

@Controller
public class AdminController {
	
	@Autowired 
	private IProductService productService;
	
	@Autowired
	private IProductDao productDao;
	
	@Autowired
	private IConfigDao configDao;
	
	@Autowired
	private IColorDao colorDao;
	
	@Autowired
	private productAdminValidation prdValidation;
	
	@Autowired
	private IProductDetailDao productDetaiDao;
	
	@Autowired
	private IImageDao imageDao;
	
	@Autowired
	private ImageService imageService;
	

	
	
	@RequestMapping("/admin")
	public String admin(HttpSession sesion, Model model) {
		User user = (User) sesion.getAttribute("user");
		model.addAttribute("user", user);
		return "system/index/index";
	}
	
	@RequestMapping("/admin/product")
	public String product(HttpSession session, Model model) {	
		User user = (User) session.getAttribute("user");
		model.addAttribute("user", user);
		
		List<ProductAdminDto> prd = productService.findAllProductDto();
		model.addAttribute("product", prd);
		return "system/products/product/product";
	}
	
	@RequestMapping("/admin/productdetail")
	public String productDetail( HttpSession session, Model model, @RequestParam("id") int id) {
		
		User user = (User) session.getAttribute("user");
		model.addAttribute("user", user);
		
		Product prd = productService.findById(id);
		model.addAttribute("prd", prd);
		List<ProductDetail> prdDt = prd.getProductDetail();
		model.addAttribute("prdDt", prdDt);
		return "system/products/productDetail/productDetail";
	}
	
	@RequestMapping("/admin/addproductDt")
	public String addProductDetail( HttpSession session, Model model, @RequestParam("id") int id) {
		
		User user = (User) session.getAttribute("user");
		model.addAttribute("user", user);		
		List<Configurator> config = configDao.findAll();
		model.addAttribute("config", config);		
		List<Color> color = colorDao.findAll();
		model.addAttribute("color", color);		
		ProductDetailAdminDto prdDT = new ProductDetailAdminDto();
		prdDT.setProductId(id);
		model.addAttribute("prdDT", prdDT);
		return "system/products/productDetail/addPrd";
	}
	
	@PostMapping("admin/save")
	public String savePrd(Model model, 
		@ModelAttribute("prdDT") ProductDetailAdminDto prdDto,BindingResult bindingResult
		, HttpSession session, @RequestParam("file") MultipartFile file,
		@RequestParam("file2") MultipartFile file2) {		
		prdValidation.validate(prdDto, bindingResult);
		if (bindingResult.hasErrors()) {
			User user = (User) session.getAttribute("user");
			model.addAttribute("user", user);			
			List<Configurator> config = configDao.findAll();
			model.addAttribute("config", config);			
			List<Color> color = colorDao.findAll();
			model.addAttribute("color", color);			
			ProductDetailAdminDto prdDT = new ProductDetailAdminDto();
			prdDT.setProductId(prdDto.getProductId());
			model.addAttribute("prdDT", prdDT);
			return "system/products/productDetail/addPrd";
		}
		Images img = new Images();       
        img.setImage1(imageService.uploadImage(file));
        img.setImage2(imageService.uploadImage(file2));
		
		imageDao.save(img);
		ProductDetail prdDt = new ProductDetail();
		prdDt.setAmount(prdDto.getAmount());
		prdDt.setPrice(prdDto.getPrice());
		prdDt.setColor(colorDao.findById(prdDto.getColorId()).get());
		prdDt.setConfigurator(configDao.findById(prdDto.getConfigId()).get());
		prdDt.setProduct(productService.findById(prdDto.getProductId()));
		prdDt.setImages(img);
		if (prdDto.getId() !=0) {
			prdDt.setId(prdDto.getId());
		}
		prdDt = productDetaiDao.save(prdDt);
		return "redirect:/admin/productdetail?id="+prdDto.getProductId();
	}
	
	
	//delete detail product
	
	@GetMapping("/admin/deletedt")
	public String deleteDetailProduct(@RequestParam("id") int id) {
		
		ProductDetail prds = productDetaiDao.findById(id).get();
		int ids = prds.getProduct().getId();
		productDetaiDao.deleteById(id);
		
		return "redirect:/admin/productdetail?id="+ids;
		
	}
	
	// delete product
	
	@GetMapping("/admin/delete")
	public String deleteProduct(@RequestParam("id") int id) {
		
		Product prd = productService.findById(id);
		List<ProductDetail> prdDt = prd.getProductDetail();
		for (ProductDetail productDetail : prdDt) {
			productDetaiDao.deleteById(productDetail.getId());
		}
		productDao.deleteById(id);
		return "redirect:/admin/product";
	}
	
}
