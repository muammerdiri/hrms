package com.muammerdiri.hrms.core.concretes;


import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import com.muammerdiri.hrms.entites.concretes.Employee;
import com.muammerdiri.hrms.entites.concretes.Employer;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.validator.constraints.UniqueElements;

import java.util.Set;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "users")
@Entity
public class User {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
	@NotNull
	@Email
	@NotBlank
	@Column(name = "email")
	private String email;
	
	@NotNull
	@NotBlank
	@Column(name="password")
	private String password;
	
	
	@OneToMany(mappedBy = "user")
	private Set<Employee> employee;
	
	@OneToMany(mappedBy = "user", cascade = {CascadeType.ALL})
    @PrimaryKeyJoinColumn
    private Set<Employer> employer;
	
	
}
