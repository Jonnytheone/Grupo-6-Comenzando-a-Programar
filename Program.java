package exercise;

import java.util.Scanner;

public class Program {

	public static void main(String[] args) {
		Scanner obj = new Scanner(System.in);
		int n;
		double groupTotalCO2 = 0.0; // Cumulative total for all registered people

		System.out.println("****Welcome to Daily CO2 Calculator ****"); 
		System.out.println("\nHow many persons are going to register? : "); 
		n = obj.nextInt();

		while (n <= 0) { // will check condition if the value is less then 0, ask for number again
			System.out.println("Invalid Input, Please enter a correct number");
			System.out.println("How many persons are going to register?: ");
			n = obj.nextInt();
		}

		// Outer loop: Iterates through each person from 1 to n
		for (int i = 1; i <= n; i++) {
			obj.nextLine(); // Clear leftover newline buffer
			System.out.println("\n========================================");
			System.out.println("Registering Person #" + i + " of " + n);
			System.out.print("Please enter name: ");
			String name = obj.nextLine();

			double personTotalCO2 = 0.0; // Tracks daily total CO2 for the current person
			int opc;

			do { 
				System.out.println("                        ");
				System.out.println("********MENU (" + name + ")******** ");
				System.out.println("                        ");
				System.out.println("1.Car transport");
				System.out.println("2.Bus transport");
				System.out.println("3.Bicycle transport");
				System.out.println("4.Use of Iron");
				System.out.println("5.Computer usage");
				System.out.println("6.mobile phone Usage");
				System.out.println("7.End of Activity for " + name);
				System.out.println("                        ");
				System.out.println("******************** ");

				System.out.println("Select an option: ");
				opc = obj.nextInt();

				while (opc <= 0 || opc > 7) {
					System.out.println("Invalid Input");
					System.out.println("Select an option: ");
					opc = obj.nextInt();
				}

				switch (opc) {

				case 1: 
					System.out.println("**** Car CO2 Calculator ***");
					System.out.println("Please enter the KiloMeters(km) car traveled: ");
					double car = obj.nextDouble();
					while (car < 0) {
						System.out.println("Invalid input! Negative values are not allowed.");
						System.out.println("Please enter the KiloMeters(km) car traveled: ");
						car = obj.nextDouble();
					}
					double carEmitted = car * 0.21;
					personTotalCO2 += carEmitted;
					System.out.println("CO2 Emitted by car traveled " + car + "kms : " + carEmitted + "kg");
					break;

				case 2: 
					System.out.println("**** Bus CO2 Calculator ***");
					System.out.println("Please enter the KiloMeters(km) bus traveled: ");
					double bus = obj.nextDouble();
					while (bus < 0) {
						System.out.println("Invalid input! Negative values are not allowed.");
						System.out.println("Please enter the KiloMeters(km) bus traveled: ");
						bus = obj.nextDouble();
					}
					double busEmitted = bus * 0.10;
					personTotalCO2 += busEmitted;
					System.out.println("CO2 Emitted by bus traveled " + bus + "kms : " + busEmitted + "kg");
					break;

				case 3:
					System.out.println("**** Bicycle CO2 Calculator ***");
					System.out.println("Please enter the KiloMeters(km) bicycle traveled: ");
					double cycle = obj.nextDouble();
					while (cycle < 0) {
						System.out.println("Invalid input! Negative values are not allowed.");
						System.out.println("Please enter the KiloMeters(km) bicycle traveled: ");
						cycle = obj.nextDouble();
					}
					System.out.println("CO2 Emitted by bicycle traveled " + cycle + "kms : 0.0kg");
					break;

				case 4:
					System.out.println("**** Iron CO2 Calculator ***");
					System.out.println("Is the iron used?: ");
					System.out.println("1. Yes ");
					System.out.println("2. No ");
					int ironuse = obj.nextInt();
					while (ironuse != 1 && ironuse != 2) {
						System.out.println("Invalid choice! Please choose 1 or 2.");
						ironuse = obj.nextInt();
					}
					if (ironuse == 1) {
						System.out.println("Please enter the hours iron used: ");
						double iron = obj.nextDouble();
						while (iron < 0) {
							System.out.println("Invalid input! Negative values are not allowed.");
							System.out.println("Please enter the hours iron used: ");
							iron = obj.nextDouble();
						}
						double ironEmitted = iron * 0.70;
						personTotalCO2 += ironEmitted;
						System.out.println("CO2 Emitted by iron used in " + iron + " hours : " + ironEmitted + "kg");
					} else {
						System.out.println("No CO2 Emitted!");
					}
					break;

				case 5:
					System.out.println("**** Computer CO2 Calculator ***");
					System.out.println("Please enter the hours computer used: ");
					double comp = obj.nextDouble();
					while (comp < 0) {
						System.out.println("Invalid input! Negative values are not allowed.");
						System.out.println("Please enter the hours computer used: ");
						comp = obj.nextDouble();
					}
					double compEmitted = comp * 0.08;
					personTotalCO2 += compEmitted;
					System.out.println("CO2 Emitted by Computer used in " + comp + " hours : " + compEmitted + "kg");
					break;

				case 6:
					System.out.println("**** Mobile CO2 Calculator ***");
					System.out.println("Please enter the hours Mobile used: ");
					double mob = obj.nextDouble();
					while (mob < 0) {
						System.out.println("Invalid input! Negative values are not allowed.");
						System.out.println("Please enter the hours Mobile used: ");
						mob = obj.nextDouble();
					}
					double mobEmitted = mob * 0.08;
					personTotalCO2 += mobEmitted;
					System.out.println("CO2 Emitted by Mobile used in " + mob + " hours : " + mobEmitted + "kg");
					break;

				case 7:
					System.out.println("**** Registration finished for " + name + " ****");
					break;

				default: 
					System.out.println("Invalid data");
				}

			} while (opc != 7); // Exits the menu loop for this person when option 7 is selected

			// Show total for the individual person
			System.out.printf("\n>>> Total CO2 emitted today by %s: %.2f kg <<<\n", name, personTotalCO2);
			
			// Accumulate into the group total
			groupTotalCO2 += personTotalCO2;
		}

		// Display total for the entire group after all registrations finish
		System.out.println("\n========================================");
		System.out.printf(">>> GRAND TOTAL CO2 EMITTED BY THE GROUP: %.2f kg <<<\n", groupTotalCO2);
		System.out.println("========================================");
		System.out.println("**** Thank you for using the CO2 Calculator ****");

		obj.close();
	}
}
