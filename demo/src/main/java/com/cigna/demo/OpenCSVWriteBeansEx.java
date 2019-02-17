package com.cigna.demo;

import java.io.BufferedWriter;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

import com.opencsv.CSVWriter;
import com.opencsv.bean.ColumnPositionMappingStrategy;
import com.opencsv.bean.StatefulBeanToCsv;
import com.opencsv.bean.StatefulBeanToCsvBuilder;
import com.opencsv.exceptions.CsvDataTypeMismatchException;
import com.opencsv.exceptions.CsvRequiredFieldEmptyException;

public class OpenCSVWriteBeansEx {
	
	
	public static void main(String[] args) {
		String s = "6102359486";
		boolean valid =
			    s.length() == 10 &&
			    s.chars().allMatch(Character::isDigit);
		
		System.out.println(valid);
		
		String[] CSV_HEADER = { "id", "name", "price" };


        String fileName = "src/main/resources/cars.csv";
        Path myPath = Paths.get(fileName);

       
        List<PatientProfile> patientProfiles = new ArrayList<>();
        
        
        for (int i = 0; i < 1; i++) {
			patientProfiles.add(new PatientProfile(1, "Audi#!", 52642, "Morris|", "6102359486"));
			patientProfiles.add(new PatientProfile(2, "Mercedes#", 57127, "Morris@", "6102359486"));
			patientProfiles.add(new PatientProfile(3, "Skoda|", 9000, "Morris", "6102359486"));
			patientProfiles.add(new PatientProfile(4, "Volvo@", 29000, "Morris", "6102359486"));

		}

        try (BufferedWriter writer = Files.newBufferedWriter(myPath,
                StandardCharsets.UTF_8)) {
        	
        	// write List of Objects
        	ColumnPositionMappingStrategy<PatientProfile> mappingStrategy = 
        			new ColumnPositionMappingStrategy<PatientProfile>();
        	 
        	mappingStrategy.setType(PatientProfile.class);
        	mappingStrategy.setColumnMapping(CSV_HEADER);

            StatefulBeanToCsv<PatientProfile> beanToCsv = new StatefulBeanToCsvBuilder<PatientProfile>(writer)
                    .withQuotechar(CSVWriter.NO_QUOTE_CHARACTER)
            		.withMappingStrategy(mappingStrategy)
                    .withSeparator('|')
                    .build();
                    
            beanToCsv.write(patientProfiles);

        } catch (CsvDataTypeMismatchException | CsvRequiredFieldEmptyException |
                IOException ex) {
           
        }
    }

}
