package vn.com.onetech.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import vn.com.onetech.entity.Product;

public interface IProductDao extends JpaRepository<Product, Integer>{

}
