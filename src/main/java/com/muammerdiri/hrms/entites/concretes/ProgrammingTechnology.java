package com.muammerdiri.hrms.entites.concretes;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.Set;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "programming_technology")
@Entity
public class ProgrammingTechnology {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @Column(name = "name")
    private String name;

    @ManyToOne
    @JoinColumn(name = "programming_language_id")
    private ProgrammingLanguage programmingLanguage;

    @OneToMany(mappedBy = "programmingTechnology")
    private Set<Cv> cv;

    @ManyToOne
    @JoinColumn(name = "employee_id")
    private Employee employee;


}
