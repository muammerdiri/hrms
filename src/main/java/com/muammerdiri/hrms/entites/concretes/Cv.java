package com.muammerdiri.hrms.entites.concretes;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.awt.*;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "cvs")
public class Cv {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    @Column(name = "cover_letter")
    private String coverLetter;

    @Column(name = "linkedIn_account")
    private String linkedInAccount;

    @Column(name = "github_account")
    private String githubAccount;


    @ManyToOne
    @JoinColumn(name = "school_id")
    private School school;

    @ManyToOne
    @JoinColumn(name = "job_experience_id")
    private JobExperience jobExperience;

    @ManyToOne
    @JoinColumn(name = "language_id")
    private Language language;

    @ManyToOne
    @JoinColumn(name = "programming_technology_id")
    private  ProgrammingTechnology programmingTechnology;

    @ManyToOne
    @JoinColumn(name = "image_id")
    private Image image;


    @ManyToOne
    @JoinColumn(name = "employee_id")
    private Employee employee;

}

