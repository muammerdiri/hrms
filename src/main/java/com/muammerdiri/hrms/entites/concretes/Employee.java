package com.muammerdiri.hrms.entites.concretes;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

import com.muammerdiri.hrms.core.concretes.User;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import org.hibernate.validator.constraints.UniqueElements;

import java.util.Set;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "employees")
@EqualsAndHashCode(callSuper=false)
public class Employee {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
	@Column(name="first_name")
	@NotNull
	private String firstName;
	
	@Column(name="last_name")
	@NotNull
	private String LastName;
	
	@Column(name="date_of_birth")
	@NotNull
	private int dateOfBirth;
	
	@Column(name="identity_number")
	@UniqueElements
	@NotNull
	private String identityNumber;
	
	@ManyToOne
    @JoinColumn(name = "user_id")
	private User user;

	@OneToMany(mappedBy = "employee")
	private Set<Cv> cv;

	@OneToMany(mappedBy = "employee")
	private Set<School> school;

	@OneToMany(mappedBy = "employee")
	private  Set<ProgrammingTechnology> programmingTechnology;

	@OneToMany(mappedBy = "employee")
	private Set<Language> language;

	@OneToMany(mappedBy = "employee")
	private Set<Image> image;

	@OneToMany(mappedBy = "employee")
	private Set<JobExperience> jobExperience;






}
