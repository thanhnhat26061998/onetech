package vn.com.onetech.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import vn.com.onetech.entity.ProductDetail;

public interface IProductDetailDao extends JpaRepository<ProductDetail, Integer> {

}
