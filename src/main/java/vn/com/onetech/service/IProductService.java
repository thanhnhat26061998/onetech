package vn.com.onetech.service;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import vn.com.onetech.entity.Product;


public interface IProductService {
	
	List<Product> findAllProduct();
    Product findById(Integer id);
    List<Product> findAllById(Integer id);
    Product save(Product product);
    void remove(Integer id);

}
