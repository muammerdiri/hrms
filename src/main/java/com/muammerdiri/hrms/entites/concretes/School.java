package com.muammerdiri.hrms.entites.concretes;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Set;

import javax.persistence.*;

@Entity
@Table(name="schools")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class School {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "school_name")
    private String schoolName;
    
    @OneToMany(mappedBy = "school")
    private Set<Department> department;


}
