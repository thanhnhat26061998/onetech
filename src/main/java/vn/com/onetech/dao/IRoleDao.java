package vn.com.onetech.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import vn.com.onetech.entity.Role;

public interface IRoleDao extends JpaRepository<Role, Integer>{
	Role findByName(String name);

}
