package vn.com.onetech.controller;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.servlet.ModelAndView;

import vn.com.onetech.dto.Cart;
import vn.com.onetech.entity.Product;
import vn.com.onetech.service.IProductService;

@Controller
@SessionAttributes("carts")
public class CartController {
	@Autowired
	private IProductService productService;

	@RequestMapping("/addcart")
	public String getCart(@RequestParam(name = "productId") int id, @RequestParam(name = "quantity") int quantity,
			HttpSession session) {
		Product prd = productService.findById(id);
		Cart cart = new Cart();
		if (session.getAttribute("carts") == null) {
			cart.setProduct(prd);
			cart.setQuantity(quantity);
			List<Cart> carts = new ArrayList<Cart>();
			carts.add(cart);
			session.setAttribute("carts", carts);
		} else {
			List<Cart> carts = (List<Cart>) session.getAttribute("carts");
			cart.setProduct(prd);
			cart.setQuantity(quantity);
			carts.add(cart);
			session.setAttribute("carts", carts);
		}

		return "redirect:/cart";
	}

	@GetMapping("/addtocart")
	public String addToCart(@RequestParam(name = "productId") int id,
			HttpSession session) {
		Product prd = productService.findById(id);
		Cart cart = new Cart();
		if (session.getAttribute("carts") == null) {
			cart.setProduct(prd);
			List<Cart> carts = new ArrayList<Cart>();
			carts.add(cart);
			session.setAttribute("carts", carts);
		} else {
			List<Cart> carts = (List<Cart>) session.getAttribute("carts");
			cart.setProduct(prd);
			carts.add(cart);
			session.setAttribute("carts", carts);
		}
		return "redirect:/home";

	}

	@GetMapping("/cart")
	public ModelAndView getCarts(HttpSession session) {
		ModelAndView mav = new ModelAndView();
		if (session.getAttribute("carts") != null) {
			List<Cart> cart = (List<Cart>) session.getAttribute("carts");
			mav.addObject("carts", cart);
		}
		mav.setViewName("business/cart/cart");
		return mav;
	}

}
