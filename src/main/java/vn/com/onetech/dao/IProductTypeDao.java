package vn.com.onetech.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import vn.com.onetech.entity.ProductType;

public interface IProductTypeDao extends JpaRepository<ProductType, Integer>{
	List<ProductType> findByName(String name);
}
