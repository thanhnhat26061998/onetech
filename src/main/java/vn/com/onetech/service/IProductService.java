package vn.com.onetech.service;

import java.util.List;
import java.util.Optional;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import vn.com.onetech.entity.Product;


public interface IProductService {
	
	List<Product> findAllProduct();
    Product findById(Integer id);
    List<Product> findAllById(Integer id);
    Product save(Product product);
    void remove(Integer id);
    Page<Product> findPaginated(Pageable pageable);
    Page<Product> productByName(String name, Pageable pageable);
    int getAmoutAll();
    int getAmoutByName(String name);
    Page<Product> productByName2(String name, Pageable pageable, int price);
    Page<Product> findPrdBynameMenu(String name, Pageable pageable);
    int getAmoutByNameMenu(String name);
    Page<Product> findPrdByPrice(int price, Pageable pageable);
    int getAmoutByPrice(int price);
    int getAmoutByPriceAndName(int price, String name);

}
