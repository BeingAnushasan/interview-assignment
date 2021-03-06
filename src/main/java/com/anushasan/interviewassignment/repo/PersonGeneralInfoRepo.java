package com.anushasan.interviewassignment.repo;

import com.anushasan.interviewassignment.model.PersonGeneralInformation;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PersonGeneralInfoRepo extends JpaRepository<PersonGeneralInformation, Integer> {
}
