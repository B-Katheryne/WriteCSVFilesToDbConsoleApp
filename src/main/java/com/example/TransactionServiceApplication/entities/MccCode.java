package com.example.TransactionServiceApplication.entities;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.text.MessageFormat;

@Entity
@Table (name = "tr_mcc_codes")
public class MccCode {
    @Id
    private int mcc_code;

    private String mcc_description;

    protected MccCode () {};

    public MccCode(int mccCode, String description) {
        this.mcc_code = mccCode;
        this.mcc_description = description;
    }

    public MccCode setMccCode(int mccCode) {
        this.mcc_code = mccCode;
        return this;
    }

    public MccCode setDescription(String description) {
        this.mcc_description = description;
        return this;
    }

    public int getMccCode(){
        return mcc_code;
    }

    public String getDescription(){
        return mcc_description;
    }


    @Override
    public String toString() {
        return MessageFormat.format(
                "Transaction mcc code[mcc_code = {0}, mcc_description = {1}]",
                mcc_code, mcc_description);
    }

}
