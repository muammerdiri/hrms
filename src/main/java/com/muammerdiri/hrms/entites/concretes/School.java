package com.muammerdiri.hrms.entites.concretes;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.time.LocalDate;
import java.util.Set;

@Data
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "schools")
public class School {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @NotNull
    @NotBlank
    @Column(name = "name")
    private String name;

    @NotNull
    @NotBlank
    @Column(name = "department")
    private String department;

    @NotNull
    @NotBlank
    @Column(name = "enter_date")
    private LocalDate enterDate;

    @Column(name = "graduate_date")
    private LocalDate graduateDate;

    @OneToMany(mappedBy = "school")
    private Set<Cv> cv;

    @ManyToOne
    @JoinColumn(name = "employee_id")
    private Employee employee;


}
