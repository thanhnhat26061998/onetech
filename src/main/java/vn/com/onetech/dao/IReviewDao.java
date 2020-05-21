package vn.com.onetech.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import vn.com.onetech.entity.Review;

public interface IReviewDao extends JpaRepository<Review, Integer>{

}
