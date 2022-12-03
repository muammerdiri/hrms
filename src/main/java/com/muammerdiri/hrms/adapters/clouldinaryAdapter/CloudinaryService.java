package com.muammerdiri.hrms.adapters.clouldinaryAdapter;

import java.io.File;
import java.io.IOException;
import java.util.Map;

import com.cloudinary.Cloudinary;
import com.cloudinary.utils.ObjectUtils;

public class CloudinaryService {
	public Map uploadResult;
	Cloudinary cloudinary = new Cloudinary(ObjectUtils.asMap(
			"cloud_name", "dzbfyctnl",
			"api_key", "889241294518331",
			"api_secret", "cPsraHhCf5u2Ynia3frRG_fNlkM",
			"secure", true));
	
	public void upload(File file) throws IOException {
		
		 uploadResult = cloudinary.uploader().upload(file,ObjectUtils.emptyMap());
	}
	
}
