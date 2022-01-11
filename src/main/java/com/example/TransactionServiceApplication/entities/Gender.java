package com.example.TransactionServiceApplication.entities;

import javax.persistence.*;
import java.text.MessageFormat;

@Entity
@Table(name = "gender_train")
public class Gender {
    @Id
    private int customer_id;

    private int gender;

    protected Gender() {}

    public Gender(int customerId, int gender) {
        this.customer_id = customerId;
        this.gender = gender;
    }

    public int getCustomerId() {
        return customer_id;
    }

    public Gender setCustomer_id(int customerId) {
        this.customer_id = customerId;
        return this;
    }

    public int getGender() {
        return gender;
    }

    public Gender setGender(int gender) {
        this.gender = gender;
        return this;
    }


    @Override
    public String toString() {
        return MessageFormat.format(
                "Gender[customer_id = {0}, gender = {1}]",
                customer_id, gender);
    }

}
