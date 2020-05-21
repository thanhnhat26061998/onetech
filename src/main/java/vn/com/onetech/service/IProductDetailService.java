package vn.com.onetech.service;

import java.util.List;
import java.util.Optional;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import vn.com.onetech.dto.ProductDto;
import vn.com.onetech.entity.Product;
import vn.com.onetech.entity.ProductDetail;

public interface IProductDetailService {

	List<ProductDetail> findAll();
	
	List<ProductDto> findAllPrd();
	
	 Page<ProductDto> findPaginated(Pageable pageable) ;
	 
	 ProductDetail findById(int id);
	 
	 ProductDto findProductDtoById(int id);
	 
	 List<ProductDto> findListProductById(int id);

}
