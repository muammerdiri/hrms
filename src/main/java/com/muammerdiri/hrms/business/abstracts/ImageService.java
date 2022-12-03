package com.muammerdiri.hrms.business.abstracts;


import java.io.IOException;

import com.muammerdiri.hrms.core.utilities.results.Result;
import com.muammerdiri.hrms.entites.concretes.Image;

public interface ImageService {
	Image findById(int id);
	Result saveImage(Image image) throws IOException ;
}
