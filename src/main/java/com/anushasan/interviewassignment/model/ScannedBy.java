package com.anushasan.interviewassignment.model;

import com.anushasan.interviewassignment.CSVParser;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.ArrayList;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ScannedBy {

    private  String name;
    private int noOfPeople;

}
