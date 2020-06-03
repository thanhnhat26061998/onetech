package vn.com.onetech.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import vn.com.onetech.entity.Order;

public interface IOrderDao extends JpaRepository<Order, Integer>{

}
