package com.anushasan.interviewassignment.service;

import com.anushasan.interviewassignment.CSVParser;
import com.anushasan.interviewassignment.model.Person;
import com.anushasan.interviewassignment.model.PersonDetails;
import com.anushasan.interviewassignment.model.PersonGeneralInformation;
import com.anushasan.interviewassignment.repo.PersonGeneralInfoRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.stereotype.Service;

import java.util.List;

@Service

public class PersonGeneralInfoService {
    @Autowired
    PersonGeneralInfoRepo personGeneralInfoRepo;
    @Autowired
    CSVParser csvParser;

    public void savecombined(){
        List<Person> list = csvParser.parse();
        for (Person person : list) {

            PersonGeneralInformation personGeneralInformation = new PersonGeneralInformation();
            personGeneralInformation.setFirstName( person.getFirstName() );
            personGeneralInformation.setMiddleInitial( person.getMiddleInitial() );
            personGeneralInformation.setLastName( person.getLastName() );
            personGeneralInformation.setEmail( person.getEmail() );
            personGeneralInformation.setEmail2( person.getEmail2() );

            //detail info

            PersonDetails personDetails = new PersonDetails();
            personDetails.setEventName( person.getEventName() );
            personDetails.setScannedDate( person.getScannedDate() );
            personDetails.setStatus( person.getStatus() );
            personDetails.setAddress1( person.getAddress1() );
            personDetails.setCountryId( person.getCountryId() );
            personDetails.setScannedBy( person.getScannedBy() );
            personDetails.setQuestion( person.getQuestion() );
            personDetails.setCollateral( person.getCollateral() );
            personDetails.setStateId( person.getStateId() );
            personDetails.setFaxNumber( person.getFaxNumber() );
            personDetails.setPhoneNumber( person.getPhoneNumber() );
            personDetails.setPhone2Number( person.getPhone2Number() );
            personDetails.setScannedTime( person.getScannedTime() );
            personDetails.setNote( person.getNote() );
            personDetails.setJobTitle( person.getJobTitle() );
            personDetails.setCompanyName( person.getCompanyName() );
            personDetails.setCity( person.getCity() );
            personDetails.setAddress3( person.getAddress3() );
            personDetails.setAddress2( person.getAddress2() );
            personDetails.setResponse( person.getResponse() );
            personDetails.setZip( person.getZip() );


            personGeneralInformation.setPersonDetails( personDetails );
//            personDetails.setPersonGeneralInformation( personGeneralInformation );


            personGeneralInfoRepo.save( personGeneralInformation );
        }


    }


}
