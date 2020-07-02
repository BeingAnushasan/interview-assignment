package com.anushasan.interviewassignment.service;

import com.anushasan.interviewassignment.CSVParser;
import com.anushasan.interviewassignment.model.Person;
import com.anushasan.interviewassignment.repo.PersonRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Iterator;
import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Collectors;

@Service
public class PersonService {
    @Autowired
    PersonRepo personRepo;
    @Autowired
    CSVParser csvParser;

    public void saveall(List<Person> list) {

        for (Iterator<Person> it = list.iterator(); it.hasNext(); ) {
            personRepo.save(it.next());
        }


    }


    public List<Person> getAll() {
        List<Person> list = csvParser.parse();
        return list;
    }

    public List<Person> fromUS() {
        List<Person> fromUS = csvParser.parse()
                .stream()
                .filter(person -> person.getCountryId().contentEquals("United States"))
                .collect(Collectors.toList());
        return fromUS;
    }

    public List<Person> qualified() {
        List<Person> qualified = csvParser.parse()
                .stream()
                .filter(person -> person.getStatus().contentEquals("qualified"))
                .collect(Collectors.toList());
        return qualified;
    }

    public List<Person> disqualified() {
        List<Person> disqualified = csvParser.parse()
                .stream()
                .filter(Predicate.not(person -> person.getStatus().contentEquals("qualified")))
                .collect(Collectors.toList());
        return disqualified;
    }

    public List<Person> scannedBy(String name) {
        List<Person> scannedBy = csvParser.parse()
                .stream()
                .filter(person -> person.getScannedBy().contentEquals(name))
                .collect(Collectors.toList());
        return scannedBy;
    }


}
