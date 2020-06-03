package vn.com.onetech.service;

import java.util.List;

import vn.com.onetech.dto.ProductAdminDto;
import vn.com.onetech.entity.Product;

public interface IProductService {
	Product findById(int id);
	List<Product> findAllProduct();
    void save(Product product);
    void remove(Product product);
    
    List<ProductAdminDto> findAllProductDto(); 
    

}
