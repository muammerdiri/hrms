package com.muammerdiri.hrms.entites.dtos;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
@AllArgsConstructor
@NoArgsConstructor
@Data
public class GetJobAdvertisementDetailsDto {
    private String title;
    private String jobPosition;
    private String jobType;
    private short numberOfPosition;
    private LocalDate lastDate;
    private LocalDate releaseDate;
    private String city;
}
