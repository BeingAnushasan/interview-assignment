package com.anushasan.interviewassignment.controller;

import com.anushasan.interviewassignment.CSVParser;
import com.anushasan.interviewassignment.model.Person;
import com.anushasan.interviewassignment.service.PersonService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.FileNotFoundException;
import java.util.*;

@RestController("/rest")
public class PersonController {

    final PersonService personService;
    public PersonController(PersonService personService) {
        this.personService = personService;
    }

    @GetMapping("/getall")
    public List<Person> getall() throws FileNotFoundException {
        CSVParser csvParser = new CSVParser();
        List<Person> data = csvParser.parse();
        personService.saveall(data);
        return data;
    }




}

//        firstName
//        middleInitial
//        lastName
//        email
//        email2
//        eventName
//        scannedDate
//        scannedTime
//        companyName
//        jobTitle
//        address1
//        address2
//        address3
//        city
//        stateId
//        zip
//        countryId
//        phoneNumber
//        phonene2Number
//        faxNumber
//        question
//        response
//        note
//        collateral
//        qualifiedDisqualified
//        scannedBy