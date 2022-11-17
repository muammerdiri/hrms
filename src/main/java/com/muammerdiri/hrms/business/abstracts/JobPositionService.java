package com.muammerdiri.hrms.business.abstracts;

import java.util.List;

import com.muammerdiri.hrms.business.requests.CreateJobPositionRequest;
import com.muammerdiri.hrms.business.requests.UpdateJobPositionRequest;
import com.muammerdiri.hrms.business.responses.GetJobPositionResponse;

public interface JobPositionService {
	void add(CreateJobPositionRequest jobPositionResponse);
	void delete(int id);
	void update(int id,UpdateJobPositionRequest jobPositionResponse);
	List<GetJobPositionResponse> getAll();
}
