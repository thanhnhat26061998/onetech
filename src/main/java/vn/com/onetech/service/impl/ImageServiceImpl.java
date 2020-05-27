package vn.com.onetech.service.impl;

import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;


import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;



import vn.com.onetech.entity.Images;
import vn.com.onetech.service.ImageService;

@Service
public class ImageServiceImpl implements ImageService {

	@Override
	public Images uploadImage(MultipartFile[] files, HttpServletRequest request) {
		Images images = new Images();
		for (int i = 0; i < files.length; i++) {
			MultipartFile file = files[i];
            try {
                byte[] bytes = file.getBytes();  
                ServletContext context = request.getServletContext();
                String pathUrl = context.getRealPath("/img");
                int index = pathUrl.indexOf("target");
                String pathFolder = pathUrl.substring(0, index)+"src\\main\\resources\\static\\business\\img";
                Path path = Paths.get(pathFolder + file.getOriginalFilename());
                Files.write(path, bytes);
                // get file name
                String name = "business/img/"+file.getOriginalFilename();   
                Images img =new Images();
                img.setImage1(name);       
                images = img;
            } catch (Exception e) {
                System.out.println(e);
            }
        
		
		}
		return images;
	}
}
