package com.anushasan.interviewassignment.controller;

import com.anushasan.interviewassignment.CSVParser;
import com.anushasan.interviewassignment.model.Person;
import com.anushasan.interviewassignment.model.PersonGeneralInformation;
import com.anushasan.interviewassignment.service.PersonGeneralInfoService;
import com.anushasan.interviewassignment.service.PersonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.FileNotFoundException;
import java.util.*;

@RestController
public class PersonController {

    @Autowired
     PersonService personService;
    @Autowired
    PersonGeneralInfoService personGeneralInfoService;




    @GetMapping("/getall")
    public List<Person> getall()  {
        CSVParser csvParser = new CSVParser();
        List<Person> data = csvParser.parse();
        personService.saveall(data);
        return data;
    }

    @GetMapping("/savecombined")
    public void saveCombined(){
        personGeneralInfoService.savecombined();
    }



}
