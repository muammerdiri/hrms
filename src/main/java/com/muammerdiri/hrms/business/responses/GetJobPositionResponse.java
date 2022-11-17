package com.muammerdiri.hrms.business.responses;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class GetJobPositionResponse {
	private int id;
	private String name;
}
