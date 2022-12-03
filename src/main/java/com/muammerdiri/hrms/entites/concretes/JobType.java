package com.muammerdiri.hrms.entites.concretes;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.Set;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "job_type")
public class JobType {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private int id;

    private String typeName;

    @OneToMany(mappedBy = "jobType")
    private Set<JobAdvertisement> jobAdvertisement;


}
