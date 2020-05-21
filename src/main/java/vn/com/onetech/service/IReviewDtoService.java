package vn.com.onetech.service;

import java.util.List;

import vn.com.onetech.dto.ReviewDto;

public interface IReviewDtoService {
	
	List<ReviewDto> findAllReviewDto(int id);

}
