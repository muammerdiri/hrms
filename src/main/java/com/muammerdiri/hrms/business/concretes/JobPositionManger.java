package com.muammerdiri.hrms.business.concretes;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import com.muammerdiri.hrms.core.utilities.results.DataResult;
import com.muammerdiri.hrms.core.utilities.results.Result;
import com.muammerdiri.hrms.core.utilities.results.SuccessDataResult;
import com.muammerdiri.hrms.core.utilities.results.SuccessResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.muammerdiri.hrms.business.abstracts.JobPositionService;
import com.muammerdiri.hrms.business.requests.CreateJobPositionRequest;
import com.muammerdiri.hrms.business.requests.UpdateJobPositionRequest;
import com.muammerdiri.hrms.business.responses.GetJobPositionResponse;
import com.muammerdiri.hrms.dataAccess.abstracts.JobPositionRepository;
import com.muammerdiri.hrms.entites.concretes.JobPosition;

@Service
public class JobPositionManger implements JobPositionService {

	private JobPositionRepository positionRepostory;
	
	@Autowired
	public JobPositionManger(JobPositionRepository positionRepostory) {
		this.positionRepostory = positionRepostory;
	}

	@Override
	public Result add(CreateJobPositionRequest jobPositionResponse) {
		// TODO Auto-generated method stub
		JobPosition jobPosition = new JobPosition();
		jobPosition.setName(jobPositionResponse.getName());
		
		positionRepostory.save(jobPosition);
		return new SuccessResult("Data is added");
	}

	@Override
	public Result delete(int id) {
		positionRepostory.deleteById(id);
		return new SuccessResult("Data is deleted.");
	}

	
	@Override
	public Result update(int id, UpdateJobPositionRequest jobPositionResponse) {
		Optional<JobPosition> jobPosition = positionRepostory.findById(id);
		jobPosition.get().setName(jobPositionResponse.getName());
		
		positionRepostory.save(jobPosition.get());
		return new SuccessResult("Data is updated.");
		
	}

	@Override
	public DataResult<List<GetJobPositionResponse>> getAll() {
		List<JobPosition> jobPositions = positionRepostory.findAll();
		List<GetJobPositionResponse> getJobPositionResponses = new ArrayList<GetJobPositionResponse>(); 
		
		for(JobPosition jobPosition:jobPositions) {
			GetJobPositionResponse jobPositionItem=new GetJobPositionResponse();
			jobPositionItem.setId(jobPosition.getId());
			jobPositionItem.setName(jobPosition.getName());
			getJobPositionResponses.add(jobPositionItem);
		}
		
		return new SuccessDataResult<>(getJobPositionResponses, "Data Listed");
	}

}
