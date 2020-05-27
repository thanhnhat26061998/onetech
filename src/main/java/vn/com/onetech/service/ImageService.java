package vn.com.onetech.service;



import javax.servlet.http.HttpServletRequest;

import org.springframework.web.multipart.MultipartFile;

import vn.com.onetech.entity.Images;

public interface ImageService {
	Images uploadImage(MultipartFile[] files, HttpServletRequest request);
}
