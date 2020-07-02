package com.anushasan.interviewassignment.controller;

import com.anushasan.interviewassignment.CSVParser;
import com.anushasan.interviewassignment.model.Person;
import com.anushasan.interviewassignment.repo.PersonDetailsRepo;
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
    PersonDetailsRepo personDetailsRepo;


    @GetMapping("/showall")
    public String  getall(Model model) {
        List<Person> all = personService.getAll();
        model.addAttribute("persons", all);
        return "list";
    }

    @GetMapping("/fromUS")
    public  String fromUS(Model model){
        List<Person> fromUS = personService.fromUS();
        model.addAttribute("persons",fromUS);
        return "list";
    }

    @GetMapping("/qualified")
    public  String qualified(Model model){
        List<Person> qualified = personService.qualified();
        model.addAttribute("persons", qualified);
        return "list";
    }

    @GetMapping("/scannedby/(name)")
    public  String scannedBy(@PathVariable("name") String name, Model model){
        List<Person> scannedBy = personService.scannedBy(name);
        model.addAttribute("persons", scannedBy);
        return "list";
    }
}
