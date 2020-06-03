package vn.com.onetech.service.impl;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import vn.com.onetech.dao.IOrderDao;
import vn.com.onetech.dto.ProductDto;
import vn.com.onetech.entity.Order;
import vn.com.onetech.entity.ProductDetail;

@Service
public class OrderServiceImpl {
	
	@Autowired
	private IOrderDao orderDao;
	
	
	public List<Order> searchPrd( String status, Date begin, Date end){
		List<Order> or = orderDao.findAll();
		List<Order> order = new ArrayList<Order>();
		for (Order o : or) {
			if (o.getStatus().equals(status)
					&& end.after(o.getCreationTime())&& begin.before(o.getCreationTime())) {
					order.add(o);
			}
		}
		return order;
	}
	
	
	public Page<Order> findPaginated(Pageable pageable) {
		int pageSize = pageable.getPageSize();
        int currentPage = pageable.getPageNumber();
        int startItem = currentPage * pageSize;
        List<Order> or = orderDao.findAll();

        List<Order> list;
        if (or.size()<startItem) {
			list =Collections.emptyList();
		}else {
			int toIndex = Math.min(startItem+pageSize, or.size());
			list = or.subList(startItem, toIndex);
		}      
        Page<Order> productPage = new PageImpl<Order>(list, PageRequest.of(currentPage, pageSize), or.size());
		return productPage;
	}
}
