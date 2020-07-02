package com.anushasan.interviewassignment.controller;

import com.anushasan.interviewassignment.model.Person;
import com.anushasan.interviewassignment.model.ScannedBy;
import com.anushasan.interviewassignment.service.PersonGeneralInfoService;
import com.anushasan.interviewassignment.service.PersonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;


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
        return "List";
    }

    @GetMapping("/fromUS")
    public String fromUS( Model model ){
        List<Person> fromUS = personService.fromUS();
        List<ScannedBy> listOfScanners = personService.getScannedByList();
        model.addAttribute( "persons", fromUS )
                .addAttribute( "msg", "Candidates from US" )
                .addAttribute( "list", listOfScanners );
        return "List";
    }

    @GetMapping("/qualified")
    public String qualified( Model model ){
        List<Person> qualified = personService.qualified();
        List<ScannedBy> listOfScanners = personService.getScannedByList();
        model.addAttribute( "persons", qualified )
                .addAttribute( "msg", "Qualified Candidates" )
                .addAttribute( "list", listOfScanners );
        ;
        return "List";
    }

    @GetMapping("/disqualified")
    public String disqualified( Model model ){
        List<Person> disqualified = personService.disqualified();
        List<ScannedBy> listOfScanners = personService.getScannedByList();
        model.addAttribute( "persons", disqualified )
                .addAttribute( "msg", "Disqualified Candidates" )
                .addAttribute( "list", listOfScanners );
        ;
        return "List";
    }


    @GetMapping("/scannedby/{name}")
    public String scannedBy( @PathVariable("name") String name, Model model ){
        System.out.println( "name in direct invoke:" + name );
        List<Person> listByScannerName = personService.getListByScannerName( name );
        List<ScannedBy> listOfScanners = personService.getScannedByList();
        model.addAttribute( "persons", listByScannerName )
                .addAttribute( "list", listOfScanners );;
        return "List";
    }

    @PostMapping("/scannedby")
    public String scannedBy( @ModelAttribute("ScannedBy") ScannedBy scanner, Model model ){
        System.out.println( scanner.getName() );
        List<Person> scannedBy = personService.getListByScannerName( scanner.getName() );
        model.addAttribute( "persons", scannedBy );
        return "List";
    }

    @GetMapping("/scannedbyPage")
    public String scannedBy( Model model ){
        List<ScannedBy> scannedByList = personService.getScannedByList();
        model.addAttribute( "list", scannedByList );
        return "ScannedBy";
    }
}
