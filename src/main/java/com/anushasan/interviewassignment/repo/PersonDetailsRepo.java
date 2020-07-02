package com.anushasan.interviewassignment.repo;

import com.anushasan.interviewassignment.model.PersonDetails;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PersonDetailsRepo extends JpaRepository<PersonDetails, Integer> {
}
