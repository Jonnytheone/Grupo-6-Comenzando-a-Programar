package retoComenzandoAProgramar;

import java.util.Scanner;

public class CalculadoraDiariaDeCo2 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Scanner sc = new Scanner(System.in);
		String user="default";
		double totalGroup=0.0, km=0.0, totalUser=0.0;
		int usuarios=0, opcionMenu=0, plancha=2;
		
		System.out.println(" ");
		System.out.println("Cuantas personas quieren registrar? (max. 6): ");
		usuarios = sc.nextInt();
		
		while (usuarios > 6 || usuarios < 1) {
			System.out.println(" ");
			System.out.println("Error. Solo se admite 1 a 6 usuarios:  ");
			usuarios = sc.nextInt();
		}
		
		for (int i=1; i<=usuarios; i++) {
			user = "default";
			totalUser=0.0;
			do {
				System.out.println(" ");
				System.out.println("Usuario "+i);
				System.out.println("Cual es tu nombre? ");
				user=sc.next();
			} while (user.equals("default"));
			
			do {
				System.out.println(" ");
				System.out.println("Menu de actividades");
				System.out.println("1. Transporte en coche");
				System.out.println("2. Transporte en autobus");
				System.out.println("3. Transporte en bicicleta");
				System.out.println("4. Uso de plancha");
				System.out.println("5. Uso del ordenador");
				System.out.println("6. Uso del movil");
				System.out.println("7. Finalizar actividades del dia");
				System.out.println(" ");
				System.out.println("Elige las actividades que has hecho hoy: ");
				
				opcionMenu=sc.nextInt();
				
				switch (opcionMenu) {
					case 1: 
						System.out.println(" ");
						System.out.println("Cuantos km has recorrido?: ");
						km=sc.nextDouble();
						
						while (km < 0) {
							System.out.println(" ");
							System.out.println("Error. No puedes insertar numeros negativos:  ");
							usuarios = sc.nextInt();
						}
						
						totalGroup=totalGroup+(km*0.21);
						totalUser=totalUser+(km*0.21);
						
						System.out.println(" ");
						System.out.println("Has generado "+(km*0.21)+" kg CO2 en coche");
						break;
					case 2: 
						System.out.println(" ");
						System.out.println("Cuantos km has recorrido?: ");
						km=sc.nextDouble();
						
						while (km < 0) {
							System.out.println(" ");
							System.out.println("Error. No puedes insertar numeros negativos:  ");
							usuarios = sc.nextInt();
						}
						
						totalGroup=totalGroup+(km*0.1);
						totalUser=totalUser+(km*0.1);
						
						System.out.println(" ");
						System.out.println("Has generado "+(km*0.1)+" kg CO2 en bus");
						break;
					case 3: 
						System.out.println(" ");
						System.out.println("Cuantos km has recorrido?: ");
						km=sc.nextDouble();
						
						
						while (km < 0) {
							System.out.println(" ");
							System.out.println("Error. No puedes insertar numeros negativos:  ");
							usuarios = sc.nextInt();
						}
						
						totalGroup=totalGroup+0;
						totalUser=totalUser+0;
						
						System.out.println(" ");
						System.out.println("Has generado 0 kg CO2 en bicicleta");
						break;
					case 4: 
						System.out.println(" ");
						System.out.println("Has usado la plancha? (1=si, 0=no): ");
						plancha = sc.nextInt();
						
						if (plancha == 1) {
							System.out.println(" ");
							System.out.println("Cuantos horas lo has usado?: ");
							km=sc.nextDouble();
							
							while (km < 0) {
								System.out.println(" ");
								System.out.println("Error. No puedes insertar numeros negativos:  ");
								usuarios = sc.nextInt();
							}
							
							totalGroup=totalGroup+(km*0.7);
							totalUser=totalUser+(km*0.7);
							
							System.out.println(" ");
							System.out.println("Has generado "+(km*0.7)+" kg CO2 usando la plancha");
						} else if (plancha == 0) {
							
							totalGroup=totalGroup+0;
							
							System.out.println(" ");
							System.out.println("Has generado 0 kg CO2 usando la plancha");
							
						} else {
							System.out.println(" ");
							System.out.println("Error. Has insertado una seleccion invalida.");
						}
						break;
					case 5: 
						System.out.println(" ");
						System.out.println("Cuanto tiempo has usado el ordenador?: ");
						km=sc.nextDouble();
						
						while (km < 0) {
							System.out.println(" ");
							System.out.println("Error. No puedes insertar numeros negativos:  ");
							usuarios = sc.nextInt();
						}
						
						totalGroup=totalGroup+(km*0.08);
						totalUser=totalUser+(km*0.08);
						
						System.out.println(" ");
						System.out.println("Has generado "+(km*0.08)+" kg CO2 usando el ordenador.");
						break;
					case 6: 
						System.out.println(" ");
						System.out.println("Cuanto tiempo has usado el movil?: ");
						km=sc.nextDouble();
						
						while (km < 0) {
							System.out.println(" ");
							System.out.println("Error. No puedes insertar numeros negativos:  ");
							usuarios = sc.nextInt();
						}
						
						totalGroup=totalGroup+(km*0.02);
						totalUser=totalUser+(km*0.02);
						
						System.out.println(" ");
						System.out.println("Has generado "+(km*0.02)+" kg CO2 usando el movil");
						break;
					case 7: 
						System.out.println(" ");
						System.out.println("Finalizando actividades del dia.");
						break;
					default: 
						System.out.println(" ");
						System.out.println("Error. Esta opcion no es valido. Intentalo de nuevo");
						break;
				}
				
			} while (opcionMenu != 7);
			System.out.println(" ");
			System.out.println("El total de  co2 generado por "+user+" es: "+totalUser+" kg CO2");
			
		}
		System.out.println(" ");
		System.out.println("El total de  co2 generado por el grupo es: "+totalGroup+" kg CO2");
		
		sc.close();
	}

}
