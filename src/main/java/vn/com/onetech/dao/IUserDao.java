package vn.com.onetech.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import vn.com.onetech.entity.User;

public interface IUserDao extends JpaRepository<User, Integer>{
	User findByEmail(String email);
}
