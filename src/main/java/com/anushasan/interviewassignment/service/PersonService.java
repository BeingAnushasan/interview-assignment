package com.anushasan.interviewassignment.service;

import com.anushasan.interviewassignment.model.Person;
import com.anushasan.interviewassignment.model.PersonGeneralInformation;
import com.anushasan.interviewassignment.repo.PersonDetailsRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Iterator;
import java.util.List;

@Service
public class PersonService {
    @Autowired
    PersonDetailsRepo personDetailsRepo;

    public void saveall(List<Person> list){

        for(Iterator<Person> it = list.iterator(); it.hasNext();){
            personDetailsRepo.save(it.next());
        }

    }

}
