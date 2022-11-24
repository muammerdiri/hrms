package com.muammerdiri.hrms.entites.concretes;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Table(name="cvs")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Cv {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "cover_letter")
    private String coverLetter;

    @Column(name = "github_account")
    private String githubAccount;

    @Column(name = "linkedin_account")
    private String linkedInAccount;


    @ManyToOne
    @JoinColumn(name = "education_id")
    private Education education;

    @ManyToOne
    @JoinColumn(name = "job_experience_id")
    private JobExperience jobExperience;

    @ManyToOne
    @JoinColumn(name="language_id")
    private Language language;

    @OneToOne
    @JoinColumn(name = "image_id")
    private Image image;

    @ManyToOne
    @JoinColumn(name = "programming_technology_id")
    private ProgrammingTechnology programmingTechnology;

}
