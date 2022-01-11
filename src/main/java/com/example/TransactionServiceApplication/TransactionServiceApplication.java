package com.example.TransactionServiceApplication;

import com.example.TransactionServiceApplication.functions.TableFunctions;
import com.example.TransactionServiceApplication.functions.*;
import com.example.TransactionServiceApplication.services.*;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.ConfigurationPropertiesScan;

import java.util.Scanner;

import static java.lang.System.exit;

@ConfigurationPropertiesScan
@EnableAutoConfiguration

@SpringBootApplication
public class TransactionServiceApplication implements CommandLineRunner {
	private static final Logger LOGGER = LoggerFactory.getLogger(TransactionServiceApplication.class);

	private final GenderService genderService;
	private final MccCodeService mccCodeService;
	private final TransactionService transactionService;
	private final TransactionTypeService transactionTypeService;

	@Autowired
	public TransactionServiceApplication(GenderService genderService, MccCodeService mcCcodeService,
							  TransactionService transactionService, TransactionTypeService typeService) {
		this.genderService = genderService;
		this.mccCodeService = mcCcodeService;
		this.transactionService = transactionService;
		this.transactionTypeService = typeService;
	}

	public static void main(String[] args) {
		SpringApplication.run(TransactionServiceApplication.class, args);
	}



	@Override
	public void run(String... args) throws Exception {
		while (true) {
			String chosenOption;

			ShowAvailableApplicationOptions();
			chosenOption = getInput();

			switch (chosenOption) {
				case "1":
					tableTreatment(chooseTableFunction(), new GenderFunctions(genderService));
					break;
				case "2":
					tableTreatment(chooseTableFunction(), new MccCodeFunctions(mccCodeService));
					break;
				case "3":
					tableTreatment(chooseTableFunction(), new TransactionTypeFunctions(transactionTypeService));
					break;
				case "4":
					tableTreatment(chooseTableFunction(), new TransactionFunctions(transactionService));
					break;
				case "5":
					specialFunctionsTreatment(chooseSpecialFunction());
					break;
				default:
					exit(0);
			}
		}

	}

	public String getInput(){
		Scanner input = new Scanner(System.in);
		String chosenOption = input.nextLine();
		return chosenOption;
	}

	public void ShowAvailableApplicationOptions(){
		LOGGER.info("Welcome to Transaction Service Application!\n" +
				"Enter one of the following numbers to choose the table you'll be working with:\n" +
				"1: gender_train\n" +
				"2: tr_mcc_codes\n" +
				"3: tr_types\n" +
				"4: transactions\n" +
				"5: watch special functions" +
				"everything else: to end the suffering by finishing the application's work\n\n");
	}

	public void showSpecialFunctions(){
		LOGGER.info(
				"Enter one of the following numbers:\n" +
						"1: find the largest transaction amount by id\n" +
						"2: find the most seen transaction absolute amount by id\n\n");

	}

	public void showFunctionsForTable(){
		LOGGER.info(
				"Enter one of the following numbers:\n" +
						"1: look through the table\n" +
						"2: parse CSV file to the database\n" +
						"3: parse the table from the database into CSV file\n\n");
	}

	public String chooseTableFunction(){
		showFunctionsForTable();
		String chosenFunction = getInput();
		return chosenFunction;
	}

	public String chooseSpecialFunction(){
		showSpecialFunctions();
		String chosenFunction = getInput();
		return chosenFunction;
	}

	public void tableTreatment(String input, TableFunctions tableFunctions){
		switch(input){
			case "1":
				tableFunctions.showAll(tableFunctions.getService());
				break;
			case "2":
				tableFunctions.parseFromCsv(tableFunctions.getService());
				break;
			case "3":
				tableFunctions.parseToCsv(tableFunctions.getService());
				break;
			default:
				exit(0);
		}
		returnToStart();
	}

	public void returnToStart(){
		System.out.println("Press anything to return to start");
	}

	public void specialFunctionsTreatment(String input){
		switch (input){
			case "1":
				largestTransactionAmountById();
				break;
			case "2":
				mostSeenAbsoluteAmountById();
				break;
		}
	}

	public int getId(){
		LOGGER.info("Type id:");
		String id = getInput();
		return Integer.parseInt(id);
	}

	public void mostSeenAbsoluteAmountById(){
		TransactionFunctions function = new TransactionFunctions(transactionService);
		function.mostSeenTransactionAbsoluteAmount(getId(), function.getService());
	}

	public void largestTransactionAmountById(){
		TransactionFunctions function = new TransactionFunctions(transactionService);
		function.getMaxTransactionById(getId(), function.getService());
	}
}
