package com.anushasan.interviewassignment.controller;

import com.anushasan.interviewassignment.model.Person;
import com.anushasan.interviewassignment.model.ScannedBy;
import com.anushasan.interviewassignment.service.PersonGeneralInfoService;
import com.anushasan.interviewassignment.service.PersonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;


import java.util.List;

@Controller()
public class IndexController {

    @Autowired
    PersonService personService;
    @Autowired
    PersonGeneralInfoService personGeneralInfoService;


    @GetMapping("/")
    public String getall( Model model ){
        List<Person> all = personService.getAll();
        personGeneralInfoService.savecombined(); //this will persist general and detain info of a person
        List<ScannedBy> listOfScanners = personService.getScannedByList();
        model.addAttribute( "persons", all )
                .addAttribute( "msg", "All Candidates" )
                .addAttribute( "list", listOfScanners );
        ;
        return "Index";
    }

    @GetMapping("/fromUS")
    public String fromUS( Model model ){
        List<Person> fromUS = personService.fromUS();
        List<ScannedBy> listOfScanners = personService.getScannedByList();
        model.addAttribute( "persons", fromUS )
                .addAttribute( "msg", "Candidates from US" )
                .addAttribute( "list", listOfScanners );
        return "Index";
    }

    @GetMapping("/qualified")
    public String qualified( Model model ){
        List<Person> qualified = personService.qualified();
        List<ScannedBy> listOfScanners = personService.getScannedByList();
        model.addAttribute( "persons", qualified )
                .addAttribute( "msg", "Qualified Candidates" )
                .addAttribute( "list", listOfScanners );
        ;
        return "Index";
    }

    @GetMapping("/disqualified")
    public String disqualified( Model model ){
        List<Person> disqualified = personService.disqualified();
        List<ScannedBy> listOfScanners = personService.getScannedByList();
        model.addAttribute( "persons", disqualified )
                .addAttribute( "msg", "Disqualified Candidates" )
                .addAttribute( "list", listOfScanners );
        ;
        return "Index";
    }


    @GetMapping("/scannedby/{name}")
    public String scannedBy( @PathVariable("name") String name, Model model ){
        System.out.println( "name in controller invoke:" + name );
        List<Person> listByScannerName = personService.getListByScannerName( name );
        List<ScannedBy> listOfScanners = personService.getScannedByList();
        model.addAttribute( "persons", listByScannerName )
                .addAttribute( "msg","Candidates Scanned By "+name )
                .addAttribute( "list", listOfScanners );;
        return "Index";
    }

}
