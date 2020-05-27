package vn.com.onetech.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import vn.com.onetech.entity.Color;

public interface IColorDao extends JpaRepository<Color, Integer>{
	
}
