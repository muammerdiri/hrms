package com.muammerdiri.hrms.webApi.api;

import java.util.List;

import com.muammerdiri.hrms.core.utilities.results.DataResult;
import com.muammerdiri.hrms.core.utilities.results.Result;
import com.muammerdiri.hrms.core.utilities.results.SuccessResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.muammerdiri.hrms.business.abstracts.JobPositionService;
import com.muammerdiri.hrms.business.requests.CreateJobPositionRequest;
import com.muammerdiri.hrms.business.responses.GetJobPositionResponse;


@RestController
@RequestMapping("/api/jobpositions")
public class JobPositionController {

	
	private JobPositionService service;

	@Autowired
	public JobPositionController(JobPositionService service) {
		this.service = service;
	}
	
	@PostMapping("/add")
	public Result add(CreateJobPositionRequest response) {
		;
		return service.add(response);
	}
	
	@GetMapping("/getall")
	public DataResult<List<GetJobPositionResponse>> getAll(){
		return service.getAll();
	}
	
	
	
	
}
