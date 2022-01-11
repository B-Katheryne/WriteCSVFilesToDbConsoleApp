package com.example.TransactionServiceApplication.functions;

import com.example.TransactionServiceApplication.Parser;
import com.example.TransactionServiceApplication.entities.MccCode;
import com.example.TransactionServiceApplication.entities.Transaction;
import com.example.TransactionServiceApplication.services.MccCodeService;
import com.opencsv.exceptions.CsvValidationException;

import java.io.IOException;
import java.util.List;
import java.util.Scanner;

import static org.hibernate.tool.schema.SchemaToolingLogging.LOGGER;

public class MccCodeFunctions implements TableFunctions<MccCodeService>{
    MccCodeService service;

    public MccCodeFunctions(MccCodeService service){
        this.service = service;
    }

    public void showAll(MccCodeService mccCodeService) {
        for (MccCode mccCode : mccCodeService.findAll()) {
            LOGGER.info(mccCode.toString());
        }

    }

    public void findById() {

    }

    public void addNewRecord() {

    }

    public void parseFromCsv(MccCodeService mccCodeService) {

        List<List<String>> strings = null;
        try {
            strings = Parser.parseFromCSV(getPath(), ';');
        } catch (IOException e) {
            e.printStackTrace();
        } catch (CsvValidationException e) {
            e.printStackTrace();
        }
        for (int i = 1; i < strings.size(); i++) {
            mccCodeService.save(new MccCode(Integer.parseInt(strings.get(i).get(0)), (strings.get(i).get(1))));
        }

    }

    public void parseToCsv(MccCodeService mccCodeService) {
        String[] headers = {"mcc_code", "mcc_description"};
        try {
            Parser.writeMCCToCSV(getPath(), headers, mccCodeService.findAll());
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    public MccCodeService getService() {
        return service;
    }

}
