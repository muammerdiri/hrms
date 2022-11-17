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
@Table(name = "cities")
public class City {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    @Column(name = "code")
    private int code;

    @Column(name = "name")
    private String name;

    @OneToMany(mappedBy = "city")
    private Set<JobAdvertisement> jobAdvertisement;
}
