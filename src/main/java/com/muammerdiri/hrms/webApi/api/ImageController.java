package com.muammerdiri.hrms.webApi.api;

import java.io.IOException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.muammerdiri.hrms.business.abstracts.ImageService;
import com.muammerdiri.hrms.core.utilities.results.Result;
import com.muammerdiri.hrms.entites.concretes.Image;

@RestController
@RequestMapping("/api/images")
public class ImageController {
	
	private ImageService imageService;

	@Autowired
	public ImageController(ImageService imageService) {
		super();
		this.imageService = imageService;
	}
	
	@PostMapping()
	public Result saveImage(Image image) throws IOException {
		return imageService.saveImage(image);
	}
	
}
