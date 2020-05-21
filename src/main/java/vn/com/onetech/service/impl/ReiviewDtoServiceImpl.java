package vn.com.onetech.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import vn.com.onetech.dao.IReviewDao;
import vn.com.onetech.dto.ReviewDto;
import vn.com.onetech.entity.Review;
import vn.com.onetech.service.IReviewDtoService;

@Service
public class ReiviewDtoServiceImpl implements IReviewDtoService {
	
	@Autowired 
	private IReviewDao reviewDao;
	
	@Override
	public List<ReviewDto> findAllReviewDto(int id) {
		
		List<Review> rv = reviewDao.findAll();
		List<ReviewDto> rvDtos = new ArrayList<ReviewDto>(); 
		for (Review review : rv) {
			if (review.getProduct().getId()==id) {
				ReviewDto rvDto = new ReviewDto();
				rvDto.setUserId(review.getUser().getId());
				rvDto.setProductId(review.getProduct().getId());
				rvDto.setConten(review.getContent());
				rvDto.setUserName(review.getUser().getName());
				rvDtos.add(rvDto);
			}
			
		}
		
		return rvDtos;
	}

}
