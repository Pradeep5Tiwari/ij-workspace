package com.microservice.VaccinationCenter.Controller;

import com.microservice.VaccinationCenter.Entity.VaccinationCenter;
import com.microservice.VaccinationCenter.Model.Citizen;
import com.microservice.VaccinationCenter.Model.ResultsOfCitizenWithVaccinationCenter;
import com.microservice.VaccinationCenter.Repository.VaccinationCenterRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

import java.util.List;

@RestController
@RequestMapping("/vaccinationcenter")
public class VaccinationCenterController {
    @Autowired
    private VaccinationCenterRepository vaccinationCenterRepository;

    @Autowired
    private RestTemplate restTemplate;

    @PostMapping(path = "/add")
    public ResponseEntity<VaccinationCenter> addVaccinationCenter(@RequestBody VaccinationCenter newVaccinationCenter) {
        VaccinationCenter vaccinationCenter = vaccinationCenterRepository.save(newVaccinationCenter);
        return new ResponseEntity<>(vaccinationCenter, HttpStatus.CREATED);
    }

    @GetMapping(path = "/id/{id}")
    public ResponseEntity<ResultsOfCitizenWithVaccinationCenter> findListOfCitizenWithCenter(@PathVariable Integer id) {
        ResultsOfCitizenWithVaccinationCenter resultsOfCitizenWithVaccinationCenter = new ResultsOfCitizenWithVaccinationCenter();
        // Get the vaccination center name
        VaccinationCenter vaccinationCenter = vaccinationCenterRepository.findById(id).get();
        resultsOfCitizenWithVaccinationCenter.setCenter(vaccinationCenter);

        // Get the list if citizen from another CitizenService microservice through rest template
        //List<Citizen> listOfCitizen = restTemplate.getForObject("http://localhost:8081/citizen/id/" + id, List.class); // This is not recommended when we put this into cloud. It is good only for local machine.
        List<Citizen> listOfCitizen = restTemplate.getForObject("http://CITIZEN-SERVICE/citizen/id/" + id, List.class); // This is recommended as we don't need to modify the url in properties file everytime.
        resultsOfCitizenWithVaccinationCenter.setCitizenList(listOfCitizen);
        return new ResponseEntity<ResultsOfCitizenWithVaccinationCenter>(resultsOfCitizenWithVaccinationCenter, HttpStatus.OK);
    }
}
