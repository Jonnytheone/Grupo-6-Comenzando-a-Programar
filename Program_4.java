package exercise;
import java.util.Scanner;
public class Program_4 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub


			Scanner sc = new Scanner(System.in);
			String user="default", userMasEntradas="default";
			int usuarios=0, entradasAdult=0, entradasInfant=0, entradasAdultTot=0, entradasInfantTot=0, masEntradas=0;
			double precioTotal=0, dineroRecaudado=0;
			
			System.out.println("Cuantas clientes quieren registrar? (max. 6): ");
			usuarios = sc.nextInt();
			
			while (usuarios > 6 || usuarios < 1) {
				System.out.println(" ");
				System.out.println("Error. Solo se admite 1 a 6 usuarios:  ");
				usuarios = sc.nextInt();
			}
			
			for (int i=1; i<=usuarios; i++) {
				user = "default";
				
				do {
					System.out.println(" ");
					System.out.println("Cliente "+i);
					System.out.println("Cual es tu nombre? ");
					user=sc.next();
				} while (user.equals("default"));
				
				System.out.println(" ");
				System.out.println("Hola "+user);
				
				System.out.println(" ");
				System.out.println("Cuantas entradas de adulto quieres comprar?: ");
				entradasAdult=sc.nextInt();
				
				while (entradasAdult > 100 || entradasAdult < 1) {
					System.out.println(" ");
					System.out.println("Error. No hay suficinetes huecos (max. 100), Intentalo de nuevo:  ");
					entradasAdult = sc.nextInt();
				}
				
				entradasAdultTot= entradasAdultTot + entradasAdult;
					
				System.out.println(" ");
				System.out.println("Cuantas entradas infantil quieres comprar?: ");
				entradasInfant=sc.nextInt();
				
				while (entradasInfant > 100 || entradasInfant < 1) {
					System.out.println(" ");
					System.out.println("Error. No hay suficinetes huecos (max. 100), Intentalo de nuevo:  ");
					entradasInfant = sc.nextInt();
				}
				
				entradasInfantTot= entradasInfantTot + entradasInfant;
				
				System.out.println(" ");
				System.out.println("Numero de entradas: " +(entradasAdult+entradasInfant));
				
				if ((entradasAdult+entradasInfant)>masEntradas) {
					masEntradas= (entradasAdult+entradasInfant);
					userMasEntradas=user;
				}
				
				
				if ((entradasAdult+entradasInfant)>=5){
					precioTotal=((entradasAdult*9)+(entradasInfant*6))*0.9;
					System.out.println(" ");
					System.out.println("Precio de las entradas (con descuento 10%): "+precioTotal);
				}
				else {
					precioTotal=(entradasAdult*9)+(entradasInfant*6);
					System.out.println(" ");
					System.out.println("Precio de las entradas: "+precioTotal);
				}
				
				dineroRecaudado=dineroRecaudado + precioTotal;
				
			}
			
			System.out.println(" ");
			System.out.println("Dinero total recaudado: " +dineroRecaudado);
			
			System.out.println(" ");
			System.out.println("Numero total de entradas Adulto: " +entradasAdultTot);
			
			System.out.println(" ");
			System.out.println("Numero total de entradas Infantil: " +entradasInfantTot);
			
			System.out.println(" ");
			System.out.println("El cliente que compro mas entradas: "+userMasEntradas+" con "+masEntradas+" entradas.");
			
			sc.close();
			
		}

	}


