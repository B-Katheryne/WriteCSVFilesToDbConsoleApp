package com.example.TransactionServiceApplication.entities;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.text.MessageFormat;

@Entity
@Table (name = "tr_types")
public class TransactionType {
    @Id
    private int tr_type;

    private String tr_description;

    protected TransactionType() {}

    public TransactionType(int type, String description) {
        this.tr_type = type;
        this.tr_description = description;
    }

    public TransactionType setType(int type) {
        this.tr_type = type;
        return this;
    }

    public TransactionType setDescription(String description) {
        this.tr_description = description;
        return this;
    }

    public int getType() {
        return tr_type;
    }

    public String getDescription() {
        return tr_description;
    }

    @Override
    public String toString() {
        return MessageFormat.format(
                "TransactionType[tr_type = {0}, tr_description = {1}]",
                tr_type, tr_description);
    }
}
