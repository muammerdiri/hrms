package com.muammerdiri.hrms.business.abstracts;

import java.util.List;

import com.muammerdiri.hrms.business.requests.CreateJobPositionRequest;
import com.muammerdiri.hrms.business.requests.UpdateJobPositionRequest;
import com.muammerdiri.hrms.business.responses.GetJobPositionResponse;
import com.muammerdiri.hrms.core.utilities.results.DataResult;
import com.muammerdiri.hrms.core.utilities.results.Result;

public interface JobPositionService {
	Result add(CreateJobPositionRequest jobPositionResponse);
	Result delete(int id);
	Result update(int id,UpdateJobPositionRequest jobPositionResponse);
	DataResult<List<GetJobPositionResponse>> getAll();
}
