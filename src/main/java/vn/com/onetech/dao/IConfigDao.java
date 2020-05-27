package vn.com.onetech.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import vn.com.onetech.entity.Configurator;

public interface IConfigDao extends JpaRepository<Configurator, Integer>{

}
