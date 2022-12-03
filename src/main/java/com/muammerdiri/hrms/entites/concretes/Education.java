package com.muammerdiri.hrms.entites.concretes;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

import com.fasterxml.jackson.annotation.JsonIgnore;

import java.time.LocalDate;


@Entity
@Table(name="educations")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Education {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "score")
    private float score;

    @Column(name = "date_of_entry")
    private LocalDate dateOfEntry;

    @Column(name = "graduate_date")
    private LocalDate graduateDate;

//    @OneToMany(mappedBy = "education")
//    private Set<Cv> cv;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "department_id")
    @JsonIgnore
    private Department department;





}
