package com.anushasan.interviewassignment.repo;

import com.anushasan.interviewassignment.model.Person;
import com.anushasan.interviewassignment.model.PersonGeneralInformation;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PersonDetailsRepo  extends JpaRepository<Person, Integer> {
}
