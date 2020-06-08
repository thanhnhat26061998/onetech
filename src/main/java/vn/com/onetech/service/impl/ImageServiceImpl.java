package vn.com.onetech.service.impl;


import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;


import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import vn.com.onetech.service.ImageService;

@Service
public class ImageServiceImpl implements ImageService {

	

	@Override
	public String uploadImage(MultipartFile file) {
		String imgPath = null;
		
		try {
			
			byte[] bytes = file.getBytes();						
			java.nio.file.Path path = Paths.get("uploads/img/" + file.getOriginalFilename());
			Files.write(path, bytes);
			imgPath = "/uploads/img/" + file.getOriginalFilename().toString();

			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return imgPath;

	}

}
