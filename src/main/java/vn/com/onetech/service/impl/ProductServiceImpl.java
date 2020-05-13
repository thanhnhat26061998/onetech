package vn.com.onetech.service.impl;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import vn.com.onetech.dao.IProductDao;
import vn.com.onetech.dao.IProductTypeDao;
import vn.com.onetech.entity.Product;
import vn.com.onetech.service.IProductService;
import vn.com.onetech.utils.ProductUtils;


@Service
public class ProductServiceImpl implements IProductService {
	
	
	
	
	@Autowired
	private IProductDao productDao;
	
	@Autowired 
	private IProductTypeDao productTypeDao;
	
	
//	final private List<Product> products = ProductUtils.buildProducts();

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
	// find all
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
	
	// find all pagination

	@Override
	public Page<Product> findPaginated(Pageable pageable) {
		int pageSize = pageable.getPageSize();
        int currentPage = pageable.getPageNumber();
        int startItem = currentPage * pageSize;
        List<Product> products = productDao.findAll();
        List<Product> list;
        if (products.size()<startItem) {
			list =Collections.emptyList();
		}else {
			int toIndex = Math.min(startItem+pageSize, products.size());
			list = products.subList(startItem, toIndex);
		}      
        Page<Product> productPage = new PageImpl<Product>(list, PageRequest.of(currentPage, pageSize), products.size());
		return productPage;
	}
	// find by name pagination
	@Override
	public Page<Product> productByName(String name, Pageable pageable) {
		int pageSize = pageable.getPageSize();
        int currentPage = pageable.getPageNumber();
        int startItem = currentPage * pageSize;
        List<Product> products = productDao.findByName(name);
        List<Product> list;
        if (products.size()<startItem) {
			list =Collections.emptyList();
		}else {
			int toIndex = Math.min(startItem+pageSize, products.size());
			list = products.subList(startItem, toIndex);
		}
        
        Page<Product> productPage = new PageImpl<Product>(list, PageRequest.of(currentPage, pageSize), products.size());
		return productPage;
	}
	
	// điếm tất cả sản phẩm trả về

	@Override
	public int getAmoutAll() {
		int amout=0;
		List<Product> prd = new ArrayList<Product>();
		prd = productDao.findAll();
		for (Product product : prd) {
			amout++;
			
		}
		return amout;
	}
	
	// điếm sản phẩm trả về theo tên
	@Override
	public int getAmoutByName(String name) {
		int amout=0;
		List<Product> prd = new ArrayList<Product>();
		prd = productDao.findByName(name);
		for (Product product : prd) {
			amout++;
			
		}
		return amout;
	}
	
	// tìm kiếm theo tên bất kì

	@Override
	public Page<Product> productByName2(String name, Pageable pageable, int price) {
		int pageSize = pageable.getPageSize();
        int currentPage = pageable.getPageNumber();
        int startItem = currentPage * pageSize;
        List<Product> products = new ArrayList<Product>();
        if (String.valueOf(price)!=null) {      	
            List<Product> ords = productDao.findAll();
            for (Product prd : ords) {
    			if (prd.getName().equals(name)&&prd.getPrice()<=price) {
    				products.add(prd);
    			}
    		}
		}else {
	        List<Product> ords = productDao.findAll();
	        for (Product prd : ords) {
				if (prd.getName().equals(name)) {
					products.add(prd);
				}
			}
			
		}
        
        List<Product> list;
        if (products.size()<startItem) {
			list =Collections.emptyList();
		}else {
			int toIndex = Math.min(startItem+pageSize, products.size());
			list = products.subList(startItem, toIndex);
		}
        
        Page<Product> productPage = new PageImpl<Product>(list, PageRequest.of(currentPage, pageSize), products.size());
		return productPage;
	}
	
	
	// tìm kiếm theo kiểu sản phẩm
	@Override
	public Page<Product> findPrdBynameMenu(String name, Pageable pageable) {
		int pageSize = pageable.getPageSize();
        int currentPage = pageable.getPageNumber();
        int startItem = currentPage * pageSize;
        List<Product> products = new ArrayList<Product>();
        List<Product> ords = productDao.findAll();
        for (Product prd : ords) {
			if (prd.getProductType().getName().equalsIgnoreCase(name)) {
				products.add(prd);
			}
		}
        List<Product> list;
        if (products.size()<startItem) {
			list =Collections.emptyList();
		}else {
			int toIndex = Math.min(startItem+pageSize, products.size());
			list = products.subList(startItem, toIndex);
		}
        
        Page<Product> productPage = new PageImpl<Product>(list, PageRequest.of(currentPage, pageSize), products.size());
		return productPage;
	}

	// điếm số sản phẩm trả về theo kiểu sản phẩm
	@Override
	public int getAmoutByNameMenu(String name) {
		int amout=0;
        List<Product> ords = productDao.findAll();
        for (Product prd : ords) {
			if (prd.getProductType().getName().equalsIgnoreCase(name)) {
				amout++;
			}
		}
		return amout;
	}
	// tìm sản phẩm theo giá
	@Override
	public Page<Product> findPrdByPrice(int price, Pageable pageable) {
		int pageSize = pageable.getPageSize();
        int currentPage = pageable.getPageNumber();
        int startItem = currentPage * pageSize;
        List<Product> products = new ArrayList<Product>();
        List<Product> ords = productDao.findAll();
        for (Product prd : ords) {
			if (prd.getPrice()<= price) {
				products.add(prd);
			}
		}
        List<Product> list;
        if (products.size()<startItem) {
			list =Collections.emptyList();
		}else {
			int toIndex = Math.min(startItem+pageSize, products.size());
			list = products.subList(startItem, toIndex);
		}
        
        Page<Product> productPage = new PageImpl<Product>(list, PageRequest.of(currentPage, pageSize), products.size());
		return productPage;
	}

	@Override
	public int getAmoutByPrice(int price) {
		int amout=0;
		List<Product> ords = productDao.findAll();
        for (Product prd : ords) {
			if (prd.getPrice()<=price) {
				amout++;
			}
		}
		return amout;
	}
	
	

	

}
