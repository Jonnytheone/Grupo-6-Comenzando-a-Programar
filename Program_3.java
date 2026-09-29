package exercise;

import java.util.Scanner;
import java.time.LocalDate;
import java.time.Period;

public class Program_3 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("        Welcome to Bizi Tartanga       ");
        System.out.println("========================================");
        System.out.println("Initiating Maintenance Check..... Hold on...");
        System.out.println();

        // 1. Request the current date
        System.out.println("--- Enter Current Date ---");
        System.out.print("Day: ");
        int currentDay = scanner.nextInt();
        System.out.print("Month: ");
        int currentMonth = scanner.nextInt();
        System.out.print("Year: ");
        int currentYear = scanner.nextInt();

        LocalDate currentDate = LocalDate.of(currentYear, currentMonth, currentDay); //Java local date library is used to get local time

        // Initialize counters
        int needServiceCount = 0;
        int noServiceCount = 0;

        // 2. Loop to register bicycles
        while (true) {
            System.out.println("\nDo you want to register another bicycle? Answer Y or N");
            char response = scanner.next().charAt(0);

            // Exit loop if user answers 'N' or 'n'
            if (response == 'N' || response == 'n') {
                break;
            }

            // Process bicycle if user answers 'Y' or 'y'
            if (response == 'Y' || response == 'y') {
                System.out.print("Enter bicycle identification number: ");
                String idNumber = scanner.next();

                System.out.println("--- Enter Date of Last Revision ---");
                System.out.print("Day: ");
                int revDay = scanner.nextInt();
                System.out.print("Month: ");
                int revMonth = scanner.nextInt();
                System.out.print("Year: ");
                int revYear = scanner.nextInt();

                LocalDate revisionDate = LocalDate.of(revYear, revMonth, revDay);

                // 3. Compare dates
                Period age = Period.between(revisionDate, currentDate);

                // Check if strictly more than a year has passed
                if (age.getYears() > 1 || (age.getYears() == 1 && (age.getMonths() > 0 || age.getDays() > 0))) {
                    System.out.println("This bike needs servicing.");
                    needServiceCount++;
                } else {
                    System.out.println("This bicycle does NOT need servicing.");
                    noServiceCount++;
                }
            } else {
                System.out.println("Invalid input. Please enter Y or N.");
            }
        }

        // 4. Display final summary
        System.out.println("\n--- Final Summary ---");
        System.out.println("Bicycles that need servicing: " + needServiceCount);
        System.out.println("Bicycles that do not need servicing: " + noServiceCount);

        scanner.close();
    }
}