package com.example.TransactionServiceApplication.functions;

import com.example.TransactionServiceApplication.Parser;
import com.example.TransactionServiceApplication.entities.Transaction;
import com.example.TransactionServiceApplication.services.TransactionService;
import com.opencsv.exceptions.CsvValidationException;

import java.io.IOException;
import java.math.BigInteger;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import static org.hibernate.tool.schema.SchemaToolingLogging.LOGGER;

public class TransactionFunctions implements TableFunctions<TransactionService>{
    TransactionService service;

    public TransactionFunctions(TransactionService service){
        this.service = service;
    }

    public TransactionService getService(){
        return this.service;
    }

    public void showAll(TransactionService transactionService) {
        List<Transaction> transactions;
        switch(chooseOrder()){
            case "1":
                transactions = transactionService.findByOrderByAmount();
                break;
            default:
                transactions = transactionService.findByOrderByAmountDesc();
                break;
        }
        for (Transaction transaction : transactions) {
            LOGGER.info(transaction.toString());
        }
    }

    public String chooseOrder(){
        showOrderOptions();
        return getInput();
    }

    public void showOrderOptions(){
        LOGGER.info(
                "\n\nEnter one of the following numbers:\n" +
                        "1: in ascending order by transaction amount\n" +
                        "everything else: in descending order by transaction amount\n\n");
    }


    public void findById() {

    }

    public void addNewRecord() {

    }

    public void parseFromCsv(TransactionService transactionService) {
        List<List<String>> strings = null;
        try {
            strings = Parser.parseFromCSV(getPath(), ',');
        } catch (IOException e) {
            e.printStackTrace();
        } catch (CsvValidationException e) {
            e.printStackTrace();
        }
        for (int i = 1; i < strings.size(); i++) {
            transactionService.save(new Transaction(Integer.parseInt(strings.get(i).get(0)), strings.get(i).get(1),
                    Integer.parseInt(strings.get(i).get(2)), Integer.parseInt(strings.get(i).get(3)),
                    Double.parseDouble(strings.get(i).get(4)), strings.get(i).get(5)));
        }

    }

    public void parseToCsv(TransactionService transactionService) {
        String[] headers = {"customer_id", "tr_datetime", "mcc_code", "tr_type", "amount", "term_id"};
        try {
            Parser.writeTransactionToCSV(getPath(), headers, transactionService.findAll());
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
    public void mostSeenTransactionAbsoluteAmount(int customer_id, TransactionService transactionService){

        Double mostSeenAbsoluteAmount;
        BigInteger mostSeenAbsoluteAmountCount;
        List<Object[]> set = transactionService.mostSeenTransactionAbsoluteAmount(customer_id);
        if (set.isEmpty()){
            System.out.println("The customer_id does not exist");
        }
        for (Object[] object : set){
            mostSeenAbsoluteAmount = (Double) object[0];
            mostSeenAbsoluteAmountCount = (BigInteger) object[1];
            System.out.println("Transaction amount: " + mostSeenAbsoluteAmount
                    + "\n" +"Count: " + mostSeenAbsoluteAmountCount + "\n\n");

        }
    }

    public void getMaxTransactionById(int customer_id, TransactionService transactionService){
        Double maxTransaction;
        List<Object[]> set = transactionService.getMaxTransaction(customer_id);
        if (set.isEmpty()){
            System.out.println("The customer_id does not exist");
        }
        for (Object[] object : set){
            maxTransaction = (Double) object[0];
            System.out.println("Customer_id: " + customer_id
                    + "\n" + "Transaction amount: " + maxTransaction + "\n\n");

        }
    }
}
