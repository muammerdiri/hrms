package com.muammerdiri.hrms.entites.dtos;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CreateCvDto {
	 
	private String coverLetter;
	private String githubAccount;
	private String linkedInAccount;
	private int employeeId;
	private int educationId;
	private int jobExperienceId;
	private int languageId;
	private int imageId;
	private int programmingTechnologyId;

}
