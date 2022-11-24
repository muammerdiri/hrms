package com.muammerdiri.hrms.entites.concretes;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.Set;

@Data
@Table(name = "faculties")
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Faculity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name ="name")
    private String name;

    @Column(name = "status")
    private int status;

    @OneToMany(mappedBy = "faculity")
    private Set<Department> department;
    @ManyToOne
    @JoinColumn(name = "school_id")
    private School school;
}
