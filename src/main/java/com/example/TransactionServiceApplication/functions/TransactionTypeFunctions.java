package com.example.TransactionServiceApplication.functions;

import com.example.TransactionServiceApplication.Parser;
import com.example.TransactionServiceApplication.entities.Transaction;
import com.example.TransactionServiceApplication.entities.TransactionType;
import com.example.TransactionServiceApplication.services.TransactionTypeService;
import com.opencsv.exceptions.CsvValidationException;

import java.io.IOException;
import java.util.List;
import java.util.Scanner;

import static org.hibernate.tool.schema.SchemaToolingLogging.LOGGER;

public class TransactionTypeFunctions implements TableFunctions<TransactionTypeService>{
    TransactionTypeService service;

    public TransactionTypeFunctions(TransactionTypeService service){
        this.service = service;
    }

    public void showAll(TransactionTypeService transactionTypeService) {
        for (TransactionType transactionType : transactionTypeService.findAll()) {
            LOGGER.info(transactionType.toString());
        }
    }

    public void findById() {

    }

    public void addNewRecord() {

    }

    public void parseFromCsv(TransactionTypeService transactionTypeService) {
        List<List<String>> strings = null;
        try {
            strings = Parser.parseFromCSV(getPath(), ';');
        } catch (IOException e) {
            e.printStackTrace();
        } catch (CsvValidationException e) {
            e.printStackTrace();
        }
        for (int i = 1; i < strings.size(); i++) {
            //TransactionTypeService.save(new TransactionType(Integer.parseInt(strings.get(i).get(0)), strings.get(i).get(1)));
        }

    }

    public void parseToCsv(TransactionTypeService transactionTypeService) {
        /*
        String[] headers = {"tr_type", "tr_description"};
        try {
            Parser.writeTypeToCSV(getPath(), headers, TransactionTypeService.findAll());
        } catch (IOException e) {
            e.printStackTrace();
        } */

    }

    public TransactionTypeService getService() {
        return service;
    }

}
