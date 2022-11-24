package com.muammerdiri.hrms.entites.concretes;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.Set;


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

    @OneToMany(mappedBy = "education")
    private Set<Cv> cv;

    @ManyToOne
    @JoinColumn(name = "department_id")
    private Department department;

    @ManyToOne
    @JoinColumn(name = "faculity_id")
    private Faculity faculity;

    @ManyToOne
    @JoinColumn(name = "school_id")
    private School school;

}
