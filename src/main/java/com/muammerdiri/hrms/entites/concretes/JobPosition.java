package com.muammerdiri.hrms.entites.concretes;

import javax.persistence.*;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.validator.constraints.UniqueElements;

import java.util.Set;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name="job_positions")
public class JobPosition {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;

	@Column(name="name")
	@UniqueElements
	private String name;

	@OneToMany(mappedBy = "jobPosition")
	private Set<JobAdvertisement> jobAdvertisement;

	@OneToMany(mappedBy = "jobPosition")
	private Set<JobExperience> jobExperience;
	
	
}
