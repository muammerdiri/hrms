package com.muammerdiri.hrms.entites.concretes;

import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "job_advertisements")
public class JobAdvertisement {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "title")
    private String title;

    @Column(name = "salary")
    private double salary;

    @Column(name = "number_of_position")
    private short numberOfPosition;

    @Column(name = "last_date")
    private LocalDate lastDate;

    @Column(name = "release_date")
    private LocalDate releaseDate;

    @Column(name="status")
    private boolean status;
    @ManyToOne
    @JoinColumn(name = "city_id")
    private City city;

    @ManyToOne
    @JoinColumn(name = "job_position_id")
    private JobPosition jobPosition;

    @ManyToOne
    @JoinColumn(name = "job_type_id")
    private JobType jobType;






}
