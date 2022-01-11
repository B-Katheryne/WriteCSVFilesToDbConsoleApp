package com.example.TransactionServiceApplication.functions;

import com.example.TransactionServiceApplication.Parser;
import com.example.TransactionServiceApplication.entities.Gender;
import com.example.TransactionServiceApplication.entities.Transaction;
import com.example.TransactionServiceApplication.services.GenderService;
import com.opencsv.exceptions.CsvValidationException;

import java.io.IOException;
import java.util.List;
import java.util.Scanner;

import static org.hibernate.tool.schema.SchemaToolingLogging.LOGGER;

public class GenderFunctions implements TableFunctions<GenderService>{
    GenderService service;

    public GenderFunctions(GenderService service){
        this.service = service;
    }

    public GenderService getService() {
        return service;
    }

    public void showAll(GenderService genderService) {
        for (Gender gender : genderService.findAll()) {
            LOGGER.info(gender.toString());
        }

    }

    public void findById() {

    }

    public void addNewRecord() {

    }

    public void parseFromCsv(GenderService genderService) {
        List<List<String>> strings = null;
        try {
            strings = Parser.parseFromCSV(getPath(), ',');
        } catch (IOException e) {
            e.printStackTrace();
        } catch (CsvValidationException e) {
            e.printStackTrace();
        }
        for (int i = 1; i < strings.size(); i++) {
            genderService.save(new Gender(Integer.parseInt(strings.get(i).get(0)), Integer.parseInt((strings.get(i).get(1)))));
        }


    }

    public void parseToCsv(GenderService genderService) {
        String[] headers = {"customer_id", "gender"};
        try {
            Parser.writeGenderToCSV(getPath(), headers, genderService.findAll());
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

}
