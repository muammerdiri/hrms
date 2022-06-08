package com.muammerdiri.hrms.entities.concrete;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;


@Data
@Table(name = "employers")
@NoArgsConstructor
@AllArgsConstructor
public class Employer extends User{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "user_id")
    private int userId;

    @Column(name="company_name")
    private String companyName;

    @Column(name = "phone")
    private String phone;

    @Column(name = "webiste")
    private String webiste;
}
