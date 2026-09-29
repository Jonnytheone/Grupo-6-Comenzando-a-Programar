package retoIntermodularPgrSos;
import java.util.Scanner;

public class Ejercicio5Reto {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Scanner sc = new Scanner(System.in);
		String user="default", userMasMinutos="default";
		int usuarios=0, diasGymSemana=0, horaOMas=0, diasTotales=0;
		double minutosDiaria=0, minutosTotal=0, masMinutos=0, minutosTotalTodos=0;
		
		System.out.println("Cuantos usuarios van a registrar? (max. 6): ");
		usuarios = sc.nextInt();
		
		while (usuarios > 6 || usuarios < 1) {
			System.out.println(" ");
			System.out.println("Error. Solo se admite 1 a 6 usuarios:  ");
			usuarios = sc.nextInt();
		}
		
		for (int i=1; i<=usuarios; i++) {
			horaOMas=0;
			minutosTotal=0;
			user = "default";
			
			do {
				System.out.println(" ");
				System.out.println("Usuario "+i);
				System.out.println("Cual es tu nombre? ");
				user=sc.next();
			} while (user.equals("default"));
			
			System.out.println(" ");
			System.out.println("Hola "+user);
			
			System.out.println(" ");
			System.out.println("Cuntas dias has ido al gimnasio durante la semana?: ");
			diasGymSemana=sc.nextInt();
			
			while (diasGymSemana > 7 || diasGymSemana < 1) {
				System.out.println(" ");
				System.out.println("Error, solo puede introducir 1 a 7 dias. Intentalo de nuevo:  ");
				diasGymSemana = sc.nextInt();
			}
			diasTotales=diasTotales + diasGymSemana;
			
			for (int j=1; j<=diasGymSemana; j++) {
				System.out.println(" ");
				System.out.println("Dia "+j);
				System.out.println("Cuantos minutos has realizado ejercicio?: ");
				minutosDiaria=sc.nextDouble();
				
				while (minutosDiaria> 1440 || minutosDiaria < 1) {
					System.out.println(" ");
					System.out.println("Error, has puesto un valor invalido. Intentalo de nuevo:  ");
					minutosDiaria = sc.nextDouble();
				}
				
				minutosTotal=minutosTotal + minutosDiaria;
				
				minutosTotalTodos=minutosTotalTodos + minutosTotal;
				
				if (masMinutos<minutosDiaria) {
					masMinutos=masMinutos + minutosDiaria;
					userMasMinutos=user;
				}
				
				if (minutosDiaria > 60) {
					horaOMas++;
				}
			}
			
			System.out.println(" ");
			System.out.println("El numero de minutos total realizados son: "+minutosTotal+" minutos.");
			if (minutosTotal>=300) {
				System.out.println("Felicidades, has conseguido tu objetivo semanal de 300 minutos o mas!");
			}
			
			System.out.println(" ");
			System.out.println("La media de minutos diaria es: "+(minutosTotal/diasGymSemana)+" minutos.");
			
			System.out.println(" ");
			System.out.println("El numero de dias que has hecho mas de 60 minutos de ejercicio es: "+horaOMas+" dias.");
			
			
		}
		
		System.out.println(" ");
		System.out.println(" ");
		System.out.println(" ");
		System.out.println("El usuario que realizo mas minutos de ejercicio es: "+userMasMinutos+" con "+masMinutos+" minutos.");
		
		System.out.println(" ");
		System.out.println("En total, todos los usuarios han hecho " +minutosTotalTodos+" minutos de ejercicio.");
		
		System.out.println(" ");
		System.out.println("Se ha registrado "+diasTotales+" dias de entrenamiento totales.");
		
		sc.close();
		
	

	}
}
