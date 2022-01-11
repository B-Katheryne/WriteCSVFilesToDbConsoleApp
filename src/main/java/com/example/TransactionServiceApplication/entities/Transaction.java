package com.example.TransactionServiceApplication.entities;

import javax.persistence.*;
import java.text.MessageFormat;

@Entity
@Table (name = "transactions")
public class Transaction {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private int customer_id;
    private String tr_datetime;
    private int MCC_code;
    private int tr_type;
    private double amount;
    private String term_id;

    protected Transaction () {}

    public Transaction(int customer_id, String tr_datetime, int MCC_code, int tr_type, double amount, String term_id) {
        this.customer_id = customer_id;
        this.tr_datetime = tr_datetime;
        this.MCC_code = MCC_code;
        this.tr_type = tr_type;
        this.amount = amount;
        this.term_id = term_id;
    }

    public int getId(){
        return customer_id;
    }

    public String getDatetime(){
        return tr_datetime;
    }

    public int getMccCode(){
        return MCC_code;
    }

    public int getType(){
        return tr_type;
    }

    public double getAmount(){
        return amount;
    }

    public String getTermId(){
        return term_id;
    }

    @Override
    public String toString() {
        return MessageFormat.format(
                "Transaction[customer_id = {0}, datetime = {1}, mcc_code = {2}, tr_type = {3}, amount = {4}, term_id = {5}]",
                customer_id, tr_datetime, MCC_code, tr_type, amount, term_id);
    }

}
