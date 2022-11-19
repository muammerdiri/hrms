package com.muammerdiri.hrms.entites.concretes;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import com.muammerdiri.hrms.core.concretes.User;

import lombok.*;
import org.hibernate.validator.constraints.UniqueElements;

import java.util.List;
import java.util.Set;


@Entity
@NoArgsConstructor
@AllArgsConstructor
@Data
@Table(name="employers")
@EqualsAndHashCode(callSuper=false)
public class Employer  {
	
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;

	@NotNull
	@NotBlank
	@Column(name = "company_name")
	private String companyName;

	@NotNull
	@Column(name="website")
	private String website;
	
	@NotNull
	@UniqueElements
	@Column(name="phone_number")
	private String phoneNumber;


	@ManyToOne
    @JoinColumn(name = "user_id")
	private User user;






}
