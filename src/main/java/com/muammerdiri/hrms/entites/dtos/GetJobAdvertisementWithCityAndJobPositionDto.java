package com.muammerdiri.hrms.entites.dtos;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
@Data
@NoArgsConstructor
@AllArgsConstructor
public class GetJobAdvertisementWithCityAndJobPositionDto {
    private String title;
    private String jobPosition;
    private short numberOfPosition;
    private LocalDate lastDate;
    private LocalDate releaseDate;
    private String city;
}
