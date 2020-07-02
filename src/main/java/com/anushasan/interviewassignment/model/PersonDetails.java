package com.anushasan.interviewassignment.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class PersonDetails {

    @Id
    @GeneratedValue
    private int id;
    private String eventName;
    private String scannedDate;
    private String scannedTime;
    private String companyName;
    private String jobTitle;
    private String address1;
    private String address2;
    private String address3;
    private String city;
    private String stateId;
    private String zip;
    private String countryId;
    private String phoneNumber;
    private String phone2Number;
    private String faxNumber;
    private String question;
    private String response;
    private String note;
    private String collateral;
    private String status;
    private String scannedBy;

//    @OneToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
//    private PersonGeneralInformation personGeneralInformation;


}
