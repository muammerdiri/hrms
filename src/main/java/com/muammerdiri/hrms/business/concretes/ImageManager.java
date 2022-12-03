package com.muammerdiri.hrms.business.concretes;

import java.io.File;
import java.io.IOException;
import java.util.Map;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.muammerdiri.hrms.adapters.clouldinaryAdapter.CloudinaryService;
import com.muammerdiri.hrms.business.abstracts.ImageService;
import com.muammerdiri.hrms.core.utilities.results.Result;
import com.muammerdiri.hrms.core.utilities.results.SuccessResult;
import com.muammerdiri.hrms.dataAccess.abstracts.ImageRepository;
import com.muammerdiri.hrms.entites.concretes.Image;

@Service
public class ImageManager implements ImageService {

	private ImageRepository imageRepository;
	

	   @Autowired
	public ImageManager(ImageRepository imageRepository) {
		super();
		this.imageRepository = imageRepository;
	   }

	@Override
	public Image findById(int id) {
		Optional<Image> foundImage = imageRepository.findById(id);
		Image image = foundImage.get();
		return image;
	}

	@Override
	public Result saveImage(Image image) throws IOException {
		CloudinaryService cloudinaryService= new CloudinaryService();
		File file = new File(image.getPath());
		cloudinaryService.upload(file);
		image.setPath(cloudinaryService.uploadResult.get("url").toString());
		
		imageRepository.save(image);
		return new SuccessResult("Image saved");
	}
	
	
}
