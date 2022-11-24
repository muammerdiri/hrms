package com.muammerdiri.hrms.entites.concretes;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Table(name="departments") 
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Department {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "name")
    private String name;

    @Column(name = "time")
    private int time;

    @Column(name = "type")
    private String type;

    @Column(name = "status")
    private int status;

    @ManyToOne
    @JoinColumn(name = "faculity_id")
    private Faculity faculity;



}
