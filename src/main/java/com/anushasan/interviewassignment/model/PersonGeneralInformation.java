package com.anushasan.interviewassignment.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;

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



//    @OneToOne(fetch = FetchType.LAZY)
//    private  PersonDetails personDetails;
}