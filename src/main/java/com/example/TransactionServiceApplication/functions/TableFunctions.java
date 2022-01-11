package com.example.TransactionServiceApplication.functions;

import java.util.Scanner;

public interface TableFunctions<T> {
    void showAll(T t);
    void findById();
    void addNewRecord();
    void parseFromCsv(T t);
    void parseToCsv(T t);
    T getService();

    default String getPath(){
        System.out.println("Type file path: ");
        return getInput();
    }

    default String getInput(){
        Scanner input = new Scanner(System.in);
        String path = input.nextLine();
        return path;
    }
}
