package currencyConverter;

import java.util.InputMismatchException;
import java.util.Map;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		SearchCurrency consult = new SearchCurrency();
		int option = 0;
		double userInput = 0;
		String menu = """
				\n***Welcome to currency converter ***
				\n***Choose the option ***
				1. Dolar(USD) ===> Colombian Peso(COP)
				2. Colombian Peso(COP) ===> Dolar(USD)
				3. Dolar(USD) ===> Euro(EUR)
				4. Euro(EUR) ===> Dolar(USD)
				5. Colombian Peso(COP) ===>	Japan Yen(JPY)
				6. Japan Yen(JPY) ===> Colombian Peso(COP)
				9. Exit
				\n""";
		
		Scanner keyboard = new Scanner(System.in);
		while (option != 9) {
			System.out.println(menu);
			option = keyboard.nextInt();

			switch (option) {
			case 1:
				userInput = getValidUserInput(keyboard, "USD");
				convertCurrency(consult, "USD", "COP", userInput);
				break;
			case 2:
				userInput = getValidUserInput(keyboard, "COP");
				convertCurrency(consult, "COP", "USD", userInput);
				break;
			case 3:
				userInput = getValidUserInput(keyboard, "USD");
				convertCurrency(consult, "USD", "EUR", userInput);
				break;
			case 4:
				userInput = getValidUserInput(keyboard, "EUR");
				convertCurrency(consult, "EUR", "USD", userInput);
				break;
			case 5:
				userInput = getValidUserInput(keyboard, "COP");
				convertCurrency(consult, "COP", "JPY", userInput);
				break;
			case 6:
				userInput = getValidUserInput(keyboard, "JPY");
				convertCurrency(consult, "JPY", "COP", userInput);
				break;
			case 9:
				System.out.println("Thanks for using our services");
				break;
			default:
				System.out.println("Not valid option");
				break;

			}
		}
		keyboard.close();

	}
	
	private static double getValidUserInput(Scanner keyboard, String baseCode) {
		double userInput =0;
		while(true) {
			System.out.print("Enter amount to convert in " + baseCode + ": ");
			try {
				userInput = keyboard.nextDouble();
				if(userInput > 0) {
					break;
				}else {
					System.out.println("Amount must be greater than zero. Please try again.");
				}
			}catch(InputMismatchException e) {
				System.out.println("Invalid input. Please enter a valid number.");
                keyboard.next();
			}
		}
		return userInput;
	}
	
	public static void convertCurrency(SearchCurrency consult, String baseCode, String targetCode, double userInput) {
		Currency currency = consult.consultCurrency(baseCode);
		Map<String, Double> rates = currency.conversion_rates();
		double rate = rates.get(targetCode);
		double amount = userInput * rate;
		System.out.println("Converted amount: " + amount +" "+ targetCode);
	}

}
