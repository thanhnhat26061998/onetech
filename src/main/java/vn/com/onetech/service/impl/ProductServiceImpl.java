package vn.com.onetech.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import vn.com.onetech.dao.IProductDao;
import vn.com.onetech.entity.Product;
import vn.com.onetech.service.IProductService;


@Service
public class ProductServiceImpl implements IProductService {
	
	@Autowired IProductDao productDao;

	@Override
	public List<Product> findAllProduct() {
		return productDao.findAll();
	}

	@Override
	public Product findById(Integer id) {
		return productDao.findById(id).get();
	}

	@Override
	public Product save(Product product) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void remove(Integer id) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public List<Product> findAllById(Integer id) {
		List<Product> prd = productDao.findAll();
		List<Product> prds= new ArrayList<Product>();
		for (Product product : prd) {
			if (product.getId()==id) {
				prds.add(product);
			}
		}
		return prds;
	}

}
