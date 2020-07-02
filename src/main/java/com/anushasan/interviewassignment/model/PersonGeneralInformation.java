package com.anushasan.interviewassignment.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Component;

import javax.persistence.*;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class PersonGeneralInformation {

    @Id
    @GeneratedValue
    private int id;
    private String firstName;
    private String middleInitial;
    private String lastName;
    private String email;
    private String email2;

    @OneToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private PersonDetails personDetails;



}

//
//            this.id=person.getId();
//           this.firstName=person.getFirstName();
//           this.middleInitial=person.getMiddleInitial();
//           this.lastName=person.getLastName();
//           this.email=person.getEmail();
//           this.email2=person.getEmail2();
//        this.personDetails.setAddress1( person.getAddress1() );
//        this.personDetails.setAddress2( person.getAddress2() );
//        this.personDetails.setAddress3( person.getAddress3() );
//        this.personDetails.setCity( person.getCity() );
//        this.personDetails.setCollateral( person.getCollateral() );
//        this.personDetails.setCompanyName( person.getCompanyName() );
//        this.personDetails.setCountryId( person.getCountryId() );
//        this.personDetails.setEventName( person.getEventName() );
//        this.personDetails.setFaxNumber( person.getFaxNumber() );
//        this.personDetails.setJobTitle( person.getJobTitle() );
//        this.personDetails.setNote( person.getNote() );
//        this.personDetails.setStatus( person.getStatus() );
//        this.personDetails.setScannedBy( person.getScannedBy() );
//        this.personDetails.setScannedDate( person.getScannedDate() );
//        this.personDetails.setScannedTime( person.getScannedTime() );
//        this.personDetails.setPhone2Number( person.getPhone2Number() );
//        this.personDetails.setPhoneNumber( person.getPhoneNumber() );
//        this.personDetails.setFaxNumber( person.getFaxNumber() );
//        this.personDetails.setResponse( person.getResponse() );
//        this.personDetails.setStateId( person.getStateId() );
//        this.personDetails.setQuestion( person.getQuestion() );