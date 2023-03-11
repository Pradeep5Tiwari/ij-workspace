package com.microservice.VaccinationCenter.Model;

import com.microservice.VaccinationCenter.Entity.VaccinationCenter;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ResultsOfCitizenWithVaccinationCenter {

    private VaccinationCenter center;
    private List<Citizen> citizenList;

}
