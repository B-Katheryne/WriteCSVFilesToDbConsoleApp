package com.example.TransactionServiceApplication;

import com.example.TransactionServiceApplication.entities.*;
import com.opencsv.*;
import com.opencsv.CSVParserBuilder;
import com.opencsv.exceptions.CsvValidationException;

import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Parser {
    public static List<List<String>> parseFromCSV(String path, char separator) throws IOException, CsvValidationException {
        File convFile = new File(path);
        List<List<String>> records = new ArrayList<>();
        CSVParser parser = new CSVParserBuilder().withSeparator(separator).build();
        try (CSVReader csvReader = new CSVReaderBuilder(new FileReader(convFile)).withCSVParser(parser).build()) {
            String[] values;
            while ((values = csvReader.readNext()) != null) {
                records.add(Arrays.asList(values));
            }
        }
        return records;
    }



    public static void writeGenderToCSV(String writer, String[] headerRecord, List<Gender> rows) throws IOException {
        ICSVWriter csvWriter = new CSVWriterBuilder(new FileWriter(writer))
                .withSeparator(CSVWriter.DEFAULT_SEPARATOR)
                .withQuoteChar(CSVWriter.NO_QUOTE_CHARACTER)
                .withEscapeChar(CSVWriter.DEFAULT_ESCAPE_CHARACTER)
                .withLineEnd(CSVWriter.DEFAULT_LINE_END)
                .build();
        csvWriter.writeNext(headerRecord);

        for (Gender gender : rows) {
            String[] data = {
                    String.valueOf(gender.getCustomerId()),
                    String.valueOf(gender.getGender())
            };
            csvWriter.writeNext(data);
        }
        csvWriter.close();
    }

    public static void writeMCCToCSV(String writer, String[] headerRecord, List<MccCode> rows) throws IOException {
        ICSVWriter csvWriter = new CSVWriterBuilder(new FileWriter(writer))
                .withSeparator(';')
                .withQuoteChar(CSVWriter.NO_QUOTE_CHARACTER)
                .withEscapeChar(CSVWriter.DEFAULT_ESCAPE_CHARACTER)
                .withLineEnd(CSVWriter.DEFAULT_LINE_END)
                .build();
        csvWriter.writeNext(headerRecord);

        for (MccCode mcc : rows) {
            String[] data = {
                    String.valueOf(mcc.getMccCode()),
                    mcc.getDescription()
            };
            csvWriter.writeNext(data);
        }
        csvWriter.close();
    }

    public static void writeTransactionToCSV(String writer, String[] headerRecord, List<Transaction> rows) throws IOException {
        ICSVWriter csvWriter = new CSVWriterBuilder(new FileWriter(writer))
                .withSeparator(';')
                .withQuoteChar(CSVWriter.NO_QUOTE_CHARACTER)
                .withEscapeChar(CSVWriter.DEFAULT_ESCAPE_CHARACTER)
                .withLineEnd(CSVWriter.DEFAULT_LINE_END)
                .build();
        csvWriter.writeNext(headerRecord);

        for (Transaction transaction : rows) {
            String[] data = {
                    String.valueOf(transaction.getId()),
                    transaction.getDatetime(),
                    String.valueOf(transaction.getMccCode()),
                    String.valueOf(transaction.getAmount()),
                    transaction.getTermId()
            };
            csvWriter.writeNext(data);
        }
        csvWriter.close();
    }

    public static void writeTypeToCSV (String writer, String[] headerRecord, List<TransactionType> rows) throws IOException {
        ICSVWriter csvWriter = new CSVWriterBuilder(new FileWriter(writer))
                .withSeparator(';')
                .withQuoteChar(CSVWriter.NO_QUOTE_CHARACTER)
                .withEscapeChar(CSVWriter.DEFAULT_ESCAPE_CHARACTER)
                .withLineEnd(CSVWriter.DEFAULT_LINE_END)
                .build();
        csvWriter.writeNext(headerRecord);

        for (TransactionType type : rows) {
            String[] data = {
                    String.valueOf(type.getType()),
                    type.getDescription()

            };
            csvWriter.writeNext(data);
        }
        csvWriter.close();
    }


}
