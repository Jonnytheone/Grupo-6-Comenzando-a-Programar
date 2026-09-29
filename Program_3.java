package exercise;

import java.util.Scanner;
import java.time.LocalDate;
import java.time.Period;

public class Program_3 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("        Bienvenido a Bizi Tartanga       ");
        System.out.println("========================================");
        System.out.println();

        // 1. Request the current date
        System.out.println("--- Introduce el dia de hoy ---");
        System.out.print("Dia: ");
        int currentDay = scanner.nextInt();
        System.out.print("Mes: ");
        int currentMonth = scanner.nextInt();
        System.out.print("Año: ");
        int currentYear = scanner.nextInt();

        LocalDate currentDate = LocalDate.of(currentYear, currentMonth, currentDay); //Java local date library is used to get local time

        // Initialize counters
        int needServiceCount = 0;
        int noServiceCount = 0;

        // 2. Loop to register bicycles
        while (true) {
            System.out.println("\nDeseas registrar otro bicicleta? Responde S o N: ");
            char response = scanner.next().charAt(0);

            // Exit loop if user answers 'N' or 'n'
            if (response == 'N' || response == 'n') {
                break;
            }

            // Process bicycle if user answers 'Y' or 'y'
            if (response == 'S' || response == 's') {
                System.out.print("Introduce codigo indentificador de la bicicleta: ");
                String idNumber = scanner.next();

                System.out.println("--- Introduce fecha de la ultima revision ---");
                System.out.print("Dia: ");
                int revDay = scanner.nextInt();
                System.out.print("Mes: ");
                int revMonth = scanner.nextInt();
                System.out.print("Año: ");
                int revYear = scanner.nextInt();

                LocalDate revisionDate = LocalDate.of(revYear, revMonth, revDay);

                // 3. Compare dates
                Period age = Period.between(revisionDate, currentDate);

                // Check if strictly more than a year has passed
                if (age.getYears() > 1 || (age.getYears() == 1 && (age.getMonths() > 0 || age.getDays() > 0))) {
                    System.out.println("Este bicicleta necesita una revision");
                    needServiceCount++;
                } else {
                    System.out.println("Este bicicleta No necesita una revision.");
                    noServiceCount++;
                }
            } else {
                System.out.println("Opcion invalida, por favor inserta S o N.");
            }
        }

        // 4. Display final summary
        System.out.println("\n--- Resumen Final ---");
        System.out.println("Bicicletas que necesitan revision: " + needServiceCount);
        System.out.println("Bicicletas que no necesitan revision: " + noServiceCount);

        scanner.close();
    }
}
