package vn.com.onetech.service;





import org.springframework.web.multipart.MultipartFile;



public interface ImageService {
	String uploadImage(MultipartFile file);
}
