package currencyConverter;

import java.util.InputMismatchException;
import java.util.Map;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		SearchCurrency consult = new SearchCurrency();
		int option = 0;
		String menu = """
				\n***WELCOME TO CURRENCY CONVERTER ***
				\n***Choose the option ***
				1. Dolar(USD) ===> Colombian Peso(COP)
				2. Colombian Peso(COP) ===> Dolar(USD)
				3. Euro(EUR) ===> Colombian Peso(COP)
				4. Colombian Peso ===> Euro(EUR)
				5. Dolar(USD) ===> Euro(EUR)
				6. Euro(EUR) ===> Dolar(USD)
				7. Colombian Peso(COP) ===>	Japan Yen(JPY)
				8. Japan Yen(JPY) ===> Colombian Peso(COP)
				9. Exit
				\n""";
		
		Scanner keyboard = new Scanner(System.in);
		while (option != 9) {
			System.out.println(menu);
			option = keyboard.nextInt();

			switch (option) {
			case 1:
				convertCurrency(consult, "USD", "COP", keyboard);
				break;
			case 2:
				convertCurrency(consult, "COP", "USD", keyboard);
				break;
			case 3:
				convertCurrency(consult, "EUR", "COP", keyboard);
				break;
			case 4:
				convertCurrency(consult, "COP", "EUR", keyboard);
				break;
			case 5:
				convertCurrency(consult, "USD", "EUR", keyboard);
				break;
			case 6:
				convertCurrency(consult, "EUR", "USD", keyboard);
				break;
			case 7:
				convertCurrency(consult, "COP", "JPY", keyboard);
				break;
			case 8:
				convertCurrency(consult, "JPY", "COP", keyboard);
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
	
	public static void convertCurrency(SearchCurrency consult, String baseCode, String targetCode, Scanner keyboard) {
		Currency currency = consult.consultCurrency(baseCode);
		Map<String, Double> rates = currency.conversion_rates();
		double userInput = getValidUserInput(keyboard, baseCode);
		double rate = rates.get(targetCode);
		double amount = userInput * rate;
		System.out.println("Converted amount: " + amount +" "+ targetCode);
	}

}
