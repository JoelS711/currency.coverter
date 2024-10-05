package currencyConverter;

import java.util.Map;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		SearchCurrency consult = new SearchCurrency();
		int option = 0;
		double amount, rate, userInput;
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
				String base_code = "USD";
				String target_code = "COP";
				Currency currency = consult.consultCurrency(base_code);
				Map<String, Double> rates = currency.conversion_rates();
				System.out.println("Enter amount to convert in "+base_code+": ");
				userInput = keyboard.nextDouble();
				rate = rates.get(target_code);
				amount = userInput * rate;
				System.out.println("Converted amount: " + amount +" "+ target_code);
				break;
			case 2:
				base_code = "COP";
				target_code = "USD";
				currency = consult.consultCurrency(base_code);
				rates = currency.conversion_rates();
				System.out.println("Enter amount to convert in "+base_code+": ");
				userInput = keyboard.nextDouble();
				rate = rates.get(target_code);
				amount = userInput * rate;
				System.out.println("Converted amount: " + amount +" "+ target_code);
				break;
			case 3:
				base_code = "USD";
				target_code = "EUR";
				currency = consult.consultCurrency(base_code);
				rates = currency.conversion_rates();
				System.out.println("Enter amount to convert in "+base_code+": ");
				userInput = keyboard.nextDouble();
				rate = rates.get(target_code);
				amount = userInput * rate;
				System.out.println("Converted amount: " + amount +" "+ target_code);
				break;
			case 4:
				base_code = "EUR";
				target_code = "USD";
				currency = consult.consultCurrency(base_code);
				rates = currency.conversion_rates();
				System.out.println("Enter amount to convert in "+base_code+": ");
				userInput = keyboard.nextDouble();
				rate = rates.get(target_code);
				amount = userInput * rate;
				System.out.println("Converted amount: " + amount +" "+ target_code);
				break;
			case 5:
				base_code = "COP";
				target_code = "JPY";
				currency = consult.consultCurrency(base_code);
				rates = currency.conversion_rates();
				System.out.println("Enter amount to convert in "+base_code+": ");
				userInput = keyboard.nextDouble();
				rate = rates.get(target_code);
				amount = userInput * rate;
				System.out.println("Converted amount: " + amount +" "+ target_code);
				break;
			case 6:
				base_code = "JPY";
				target_code = "COP";
				currency = consult.consultCurrency(base_code);
				rates = currency.conversion_rates();
				System.out.println("Enter amount to convert in "+base_code+": ");
				userInput = keyboard.nextDouble();
				rate = rates.get(target_code);
				amount = userInput * rate;
				System.out.println("Converted amount: " + amount +" "+ target_code);
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

}
