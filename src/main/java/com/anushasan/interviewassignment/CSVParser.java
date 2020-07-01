package com.anushasan.interviewassignment;


import com.anushasan.interviewassignment.model.Person;
import com.anushasan.interviewassignment.model.PersonGeneralInformation;
import com.opencsv.CSVReader;
import com.opencsv.bean.CsvToBean;
import com.opencsv.bean.HeaderColumnNameTranslateMappingStrategy;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class CSVParser {

    public List<Person> parse(){

        Map<String, String> mapping = new HashMap<String, String>();
        mapping.put("First Name", "firstName");
        mapping.put("Middle Initial", "middleInitial");
        mapping.put("Last Name", "lastName");
        mapping.put("Email", "email");
        mapping.put("Email 2", "email2");
        mapping.put("Event Name", "eventName");
        mapping.put("Scanned Date", "scannedDate");
        mapping.put("Scanned Time", "scannedTime");
        mapping.put("Company Name", "companyName");
        mapping.put("Job Title", "jobTitle");
        mapping.put("Address 1", "address1");
        mapping.put("Address 2", "address2");
        mapping.put("Address 3 ", "address3");
        mapping.put("City", "city");
        mapping.put("State Id", "stateId");
        mapping.put("Zip", "zip");
        mapping.put("Country Id", "countryId");
        mapping.put("Phone Number", "phoneNumber");
        mapping.put("Phone 2 Number", "phone2Number");
        mapping.put("Fax Number", "faxNumber");
        mapping.put("Question", "question");
        mapping.put("Response", "response");
        mapping.put("Note", "note");
        mapping.put("Collateral", "collateral");
        mapping.put("Qualified/Disqualified", "qualifiedDisqualified");
        mapping.put("ScannedBy", "scannedBy");

        // HeaderColumnNameTranslateMappingStrategy
        // for general info class
        HeaderColumnNameTranslateMappingStrategy<Person> strategy = new HeaderColumnNameTranslateMappingStrategy<Person>();
        strategy.setType(Person.class);
        strategy.setColumnMapping(mapping);

        CSVReader csvReader = null;
        try {
            csvReader = new CSVReader(new FileReader
                    ("/home/tiger/WorkSpace/IdeaProjects/interview-assignment/interview-assignment/persons.csv"));
        } catch (FileNotFoundException e) {

            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        CsvToBean csvToBean = new CsvToBean();

        // call the parse method of CsvToBean
        // pass strategy, csvReader to parse method

        List<Person> list = csvToBean.parse(strategy, csvReader);

        List<Person> filteredList = list.stream().filter(Predicate.not(information -> information.getFirstName().isEmpty())).collect(Collectors.toList());
        return  filteredList;

    }

}
