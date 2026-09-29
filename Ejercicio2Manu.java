package retoIntermodularPgrSos;

import java.util.Scanner;

public class Ejercicio2Manu {

    public static void main(String[] args) {
        Scanner teclado = new Scanner(System.in);

        
        int totalParticipantes = 0;
        int contadorMenos60Min = 0;
        int contadorMas3Carreras = 0;
        int sumaTiempoSegundos = 0;
        int mejorTiempoSegundos = 0;

        char continuar;//Char(1 caracter)S/N continuar porque solo es 1 letra.

       
        System.out.println(" GESTIÓN DE CARRERA POPULAR AYUNTAMIENTO DE ERANDIO   ");

        do {
            //do while para que el programa se ejecute al menos 1 vez
            System.out.println("¿Qué tipo de inscripción deseas realizar?");
            System.out.println("1.- Individual");
            System.out.println("2.- Por Parejas");
            System.out.print("Selecciona una opción (1 o 2): ");
            int tipoParticipacion = teclado.nextInt();

            while (tipoParticipacion != 1 && tipoParticipacion != 2) {//Si la opcion que el usuario elije es distinta a 1 o distinta a 2 va a repetirse el bucle hasta que lo presione bien.
                System.out.print("Opción inválida. Introduce 1 (Individual) o 2 (Parejas): ");
                tipoParticipacion = teclado.nextInt();
            }
            //Creamos un switch case para el menu de 2 opciones
            switch (tipoParticipacion) {

                case 1: // Participacion individual
                    totalParticipantes++;
                    System.out.println("\n--- REGISTRO PARTICIPANTE N° " + totalParticipantes + " (INDIVIDUAL) ---");

                    // DNI, usamos length para que tenga 9 caracteres.
                    String dni = "";
                    while (dni.length() != 9) {
                        System.out.print("Introduce el DNI del participante (9 caracteres): ");
                        dni = teclado.next();
                        if (dni.length() != 9) {
                            System.out.println("Error: Debe tener exactamente 9 caracteres.");
                        }
                    }

                    // Carreras anteriores, si intenta poner un numero negativo no le va a dejar.
                    System.out.print("Número de carreras populares anteriores: ");
                    int carrerasAnteriores = teclado.nextInt();
                    while (carrerasAnteriores < 0) {
                        System.out.print("Error. No puede ser negativo: ");
                        carrerasAnteriores = teclado.nextInt();
                    }

                    // Tiempo en minutos
                    System.out.print("Introduce el tiempo en minutos: ");
                    int minutos = teclado.nextInt();
                    while (minutos < 0) {
                        System.out.print("Error. Los minutos no pueden ser negativos: ");
                        minutos = teclado.nextInt();
                    }
                    //Tiempo en segundos
                    System.out.print("Introduce el tiempo en segundos (0-59): ");
                    int segundos = teclado.nextInt();
                    while (segundos < 0 || segundos >= 60) {
                        System.out.print("Error. Los segundos deben estar entre 0 y 59: ");
                        segundos = teclado.nextInt();
                    }

                    int tiempoSegundos = (minutos * 60) + segundos;

                    // Si el tiempo en Segundos menor a 3600s=1 hora saldra este mensaje
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
                    //Cada vez que una persona se registre(individual o pareja) y calcula sus segundos totales en tiempoSegundos esto se ejecuta.
                    //Al ser el 1er participante nadie le gana asique es el record.
                    //Si tiempoSegundos es menor a mejor tiempoSegundos se va a sobre escribir si no es menor se queda como esta.
                    if (totalParticipantes == 1 || tiempoSegundos < mejorTiempoSegundos) {
                        mejorTiempoSegundos = tiempoSegundos;
                    }
                    break;

                case 2: // PArticipacion de las parejas
                    System.out.println("REGISTRO DE PAREJA ");

                    // Int empieza en 1 y si es menor o igual a 2 da una vuelta.A la 3era vuelta al darse cuenta que es mayor que 2 no lo ejecuta.
                    for (int i = 1; i <= 2; i++) {
                        totalParticipantes++;
                        System.out.println("\n-> Datos del Integrante " + i + " (Participante total N° " + totalParticipantes + ")");

                        // DNI integrante que lo vuelve a pedir creamos variable de la pareja
                        String dniPareja = "";
                        while (dniPareja.length() != 9) {
                            System.out.print("Introduce el DNI (9 caracteres): ");
                            dniPareja = teclado.next();
                            if (dniPareja.length() != 9) {
                                System.out.println(" Error: Debe tener exactamente 9 caracteres.");
                            }
                        }
                        // Carreras anteriores de cada intregante
                        System.out.print("Número de carreras populares anteriores: ");
                        int carrerasPareja = teclado.nextInt();
                        while (carrerasPareja < 0) {
                            System.out.print("Error. No puede ser negativo: ");
                            carrerasPareja = teclado.nextInt();
                        }

                        //Tiempo en minutos
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

                        // Si el tiempo de la pareja es menor a 1h=3600s sale este mensaje
                        if (tiempoParejaSegundos < 3600) {
                            System.out.println(" ¡El integrante " + i + " terminó en MENOS de 60 minutos!");
                            contadorMenos60Min++;
                        } else {
                            System.out.println("El integrante " + i + " completó en 60 minutos o más.");
                        }

                        if (carrerasPareja > 3) {
                            contadorMas3Carreras++;
                        }

                        sumaTiempoSegundos += tiempoParejaSegundos;
                        //Cada vez que una persona se registre(individual o pareja) y calcula sus segundos totales en tiempoSegundos esto se ejecuta.
                        //Al ser el 1er participante nadie le gana asique es el record.
                        //Si tiempoSegundos es menor a mejor tiempoSegundos se va a sobre escribir si no es menor se queda como esta.

                        if (totalParticipantes == 1 || tiempoParejaSegundos < mejorTiempoSegundos) {
                            mejorTiempoSegundos = tiempoParejaSegundos;
                        }
                    }
                    break;
            }

            // Preguntar si se desea registrar más inscripciones
            System.out.print("¿Desea registrar otra inscripción/participante? (S/N): ");
            continuar = teclado.next().charAt(0);
            
           
            // Aqui se muestran los resultados cuando le das a la S, el do while del principio acaba aqui abajo.
        } while (continuar == 's' || continuar == 'S');

      
        System.out.println("              RESUMEN DE LA CARRERA               ");
     
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
