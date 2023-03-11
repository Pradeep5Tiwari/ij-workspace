package com.microservice.CitizenService.Controller;

import com.microservice.CitizenService.Entity.Citizen;
import com.microservice.CitizenService.Repository.CitizenRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/citizen")
public class CitizenController {
    @Autowired
    private CitizenRepository citizenRepository;

    @RequestMapping(path = "/test")
    public ResponseEntity<String> testController() {
        return new ResponseEntity<>("Hello", HttpStatus.OK);
    }

    @RequestMapping(path = "/id/{id}")
    public ResponseEntity<Citizen> getById(@PathVariable Integer id) {
        List<Citizen> listOfCitizen = citizenRepository.findByVaccinationCenterId(id);
        return new ResponseEntity(listOfCitizen, HttpStatus.OK);
    }

    @PostMapping(path = "/add")
    public ResponseEntity<Citizen> addCitizen(@RequestBody Citizen newCitizen) {
        Citizen citizen = citizenRepository.save(newCitizen);
        return new ResponseEntity<>(citizen, HttpStatus.CREATED);
    }
}

/* What is difference between @Controller and @RestController?
// @RestController = @Controller + @ResponseBody
* @Controller is used to create web controllers that return views, which is further resolved by view resolver,
* while @RestController is used to create web services that return JSON or XML data. It's also worth noting.

@RequestMapping - It simply tells that identify / map the - "CitizenController" when there is a request with path "/citizen"

Note: This is not the way to access or auto-wire  the repository directly into controller because the repository must have to go
through the service layers. Since we don't have service layer we are injecting / Auto-wiring here.
*/

