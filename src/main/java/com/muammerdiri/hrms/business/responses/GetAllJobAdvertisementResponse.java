package com.muammerdiri.hrms.business.responses;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
@Data
@AllArgsConstructor
@NoArgsConstructor
public class GetAllJobAdvertisementResponse {

    private String title;
    private String jobPosition;
    private short numberOfPosition;
    private LocalDate lastDate;
    private LocalDate releaseDate;
}
