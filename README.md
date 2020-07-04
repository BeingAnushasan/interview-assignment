# interview-assignment

##Problems:
1) List all the person information in a nice displaying webpage.(don't include persons who are not from United States)
```
just build and run the jar and goto localhost:8080. the index page will list all the people. Click @ US-Only to view the candidates from us only.
```



2) Create a mapping between person general information and person details in database using hibernate's relations.
	-PersonGeneralInformation.java
		-first name,last name,middle initial,email,email2
	-PersonDetails.java
		- rest of the fields come under this class.
```
for easier the data in required state with mappings will be persisted as soon as you load the page, goto H2-Console for viewing the data in H2 database.
```


    
3) Create a page where admin can sort/filter records whether qualified or disqualified.
```
Click @ Qualified or Disqualified in the index page to view the candidated sorted based on their state i.e  qualified/disqualified.
```



4) Categorize records based on scannedBy field and display in a webpage.
	(for eg. Pam Fink('999'show count of all records belonging to him)
		 -when i click on Pam Fink(999), i need to see persons belonging to him.)
```
you can click on the name on the top of table to view the candidates belonging to that name.
```

##P.S : all these data is populated directly from CSV file and NOT from database.
