package vn.com.onetech.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import vn.com.onetech.dao.IProductDao;
import vn.com.onetech.dto.ProductAdminDto;
import vn.com.onetech.entity.Product;
import vn.com.onetech.service.IProductService;

@Service
public class ProductServiceImpl implements IProductService{
	
	@Autowired
	private IProductDao productDao;

	@Override
	public Product findById(int id) {
		return productDao.findById(id).get();
	}

	@Override
	public List<Product> findAllProduct() {

		return productDao.findAll();
	}

	@Override
	public void save(Product product) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void remove(Product product) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public List<ProductAdminDto> findAllProductDto() {
		List<Product> prd = productDao.findAll();
		List<ProductAdminDto> prdDto = new ArrayList<ProductAdminDto>();
		for (Product product : prd) {
			ProductAdminDto prdAdmin = new ProductAdminDto();
			prdAdmin.setId(product.getId());
			prdAdmin.setName(product.getName());
			prdAdmin.setPromotion(product.getPromotion().getName());
			prdAdmin.setTrademark(product.getTrademark().getName());
			prdDto.add(prdAdmin);
		}
		return prdDto;
	}
	
	

}
