package vn.com.onetech.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import vn.com.onetech.dao.IProductDao;
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

}
