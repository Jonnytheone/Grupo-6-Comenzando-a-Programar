package retoIntermodularPgrSos;

import java.util.Scanner;

public class Ejercicio2Manu {

    public static void main(String[] args) {
        Scanner teclado = new Scanner(System.in);

        // Contadores y acumuladores globales
        int totalParticipantes = 0;
        int contadorMenos60Min = 0;
        int contadorMas3Carreras = 0;
        int sumaTiempoSegundos = 0;
        int mejorTiempoSegundos = 0;

        char continuar;

        System.out.println("==================================================");
        System.out.println("   GESTIÓN DE CARRERA POPULAR - AYTO DE ERANDIO   ");
        System.out.println("==================================================");

        do {
            // Preguntamos primero el tipo de participación
            System.out.println("\n¿Qué tipo de inscripción deseas realizar?");
            System.out.println("1.- Individual");
            System.out.println("2.- Por Parejas");
            System.out.print("Selecciona una opción (1 o 2): ");
            int tipoParticipacion = teclado.nextInt();

            while (tipoParticipacion != 1 && tipoParticipacion != 2) {
                System.out.print("Opción inválida. Introduce 1 (Individual) o 2 (Parejas): ");
                tipoParticipacion = teclado.nextInt();
            }

            switch (tipoParticipacion) {

                case 1: // --- PARTICIPACIÓN INDIVIDUAL ---
                    totalParticipantes++;
                    System.out.println("\n--- REGISTRO PARTICIPANTE N° " + totalParticipantes + " (INDIVIDUAL) ---");

                    // DNI
                    String dni = "";
                    while (dni.length() != 9) {
                        System.out.print("Introduce el DNI del participante (9 caracteres): ");
                        dni = teclado.next();
                        if (dni.length() != 9) {
                            System.out.println("Error: Debe tener exactamente 9 caracteres.");
                        }
                    }

                    // Carreras anteriores
                    System.out.print("Número de carreras populares anteriores: ");
                    int carrerasAnteriores = teclado.nextInt();
                    while (carrerasAnteriores < 0) {
                        System.out.print("Error. No puede ser negativo: ");
                        carrerasAnteriores = teclado.nextInt();
                    }

                    // Tiempo
                    System.out.print("Introduce el tiempo en minutos: ");
                    int minutos = teclado.nextInt();
                    while (minutos < 0) {
                        System.out.print("Error. Los minutos no pueden ser negativos: ");
                        minutos = teclado.nextInt();
                    }

                    System.out.print("Introduce el tiempo en segundos (0-59): ");
                    int segundos = teclado.nextInt();
                    while (segundos < 0 || segundos >= 60) {
                        System.out.print("Error. Los segundos deben estar entre 0 y 59: ");
                        segundos = teclado.nextInt();
                    }

                    int tiempoSegundos = (minutos * 60) + segundos;

                    // Evaluaciones y estadísticas
                    if (tiempoSegundos < 3600) {
                        System.out.println(">> ¡Ha terminado en MENOS de 60 minutos!");
                        contadorMenos60Min++;
                    } else {
                        System.out.println(">> Ha completado la carrera en 60 minutos o más.");
                    }

                    if (carrerasAnteriores > 3) {
                        contadorMas3Carreras++;
                    }

                    sumaTiempoSegundos += tiempoSegundos;

                    if (totalParticipantes == 1 || tiempoSegundos < mejorTiempoSegundos) {
                        mejorTiempoSegundos = tiempoSegundos;
                    }
                    break;

                case 2: // --- PARTICIPACIÓN POR PAREJAS ---
                    System.out.println("\n--- REGISTRO DE PAREJA ---");

                    // Bucle para pedir datos de cada integrante de la pareja
                    for (int i = 1; i <= 2; i++) {
                        totalParticipantes++;
                        System.out.println("\n-> Datos del Integrante " + i + " (Participante total N° " + totalParticipantes + ")");

                        // DNI integrante
                        String dniPareja = "";
                        while (dniPareja.length() != 9) {
                            System.out.print("Introduce el DNI (9 caracteres): ");
                            dniPareja = teclado.next();
                            if (dniPareja.length() != 9) {
                                System.out.println(" Error: Debe tener exactamente 9 caracteres.");
                            }
                        }
                        // Carreras anteriores integrante
                        System.out.print("Número de carreras populares anteriores: ");
                        int carrerasPareja = teclado.nextInt();
                        while (carrerasPareja < 0) {
                            System.out.print("Error. No puede ser negativo: ");
                            carrerasPareja = teclado.nextInt();
                        }

                        // Tiempo integrante
                        System.out.print("Introduce el tiempo en minutos: ");
                        int minP = teclado.nextInt();
                        while (minP < 0) {
                            System.out.print("Error. Los minutos no pueden ser negativos: ");
                            minP = teclado.nextInt();
                        }

                        System.out.print("Introduce el tiempo en segundos (0-59): ");
                        int segP = teclado.nextInt();
                        while (segP < 0 || segP >= 60) {
                            System.out.print("Error. Los segundos deben estar entre 0 y 59: ");
                            segP = teclado.nextInt();
                        }

                        int tiempoParejaSegundos = (minP * 60) + segP;

                        // Evaluaciones para cada integrante de la pareja
                        if (tiempoParejaSegundos < 3600) {
                            System.out.println(">> ¡El integrante " + i + " terminó en MENOS de 60 minutos!");
                            contadorMenos60Min++;
                        } else {
                            System.out.println(">> El integrante " + i + " completó en 60 minutos o más.");
                        }

                        if (carrerasPareja > 3) {
                            contadorMas3Carreras++;
                        }

                        sumaTiempoSegundos += tiempoParejaSegundos;

                        if (totalParticipantes == 1 || tiempoParejaSegundos < mejorTiempoSegundos) {
                            mejorTiempoSegundos = tiempoParejaSegundos;
                        }
                    }
                    break;
            }

            // Preguntar si se desea registrar más inscripciones
            System.out.print("\n¿Desea registrar otra inscripción/participante? (S/N): ");
            continuar = teclado.next().toUpperCase().charAt(0);

        } while (continuar == 'S');

        // MUESTRA DE RESULTADOS FINALES
        System.out.println("\n==================================================");
        System.out.println("              RESUMEN DE LA CARRERA               ");
        System.out.println("==================================================");

        System.out.println("1. Número total de participantes registrados: " + totalParticipantes);
        System.out.println("2. Participantes que terminaron en menos de 60 minutos: " + contadorMenos60Min);
        System.out.println("3. Participantes que han participado en más de 3 carreras: " + contadorMas3Carreras);

        if (totalParticipantes > 0) {
            int tiempoMedioSegundos = sumaTiempoSegundos / totalParticipantes;
            int minMedio = tiempoMedioSegundos / 60;
            int segMedio = tiempoMedioSegundos % 60;
            System.out.println("4. Tiempo medio de todos los participantes: " + minMedio + " min " + segMedio + " seg");

            int minMejor = mejorTiempoSegundos / 60;
            int segMejor = mejorTiempoSegundos % 60;
            System.out.println("5. Mejor tiempo registrado: " + minMejor + " min " + segMejor + " seg");
        }

        teclado.close();
    }
}