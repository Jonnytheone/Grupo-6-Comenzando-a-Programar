package retoComenzandoAProgramar;

import java.util.Scanner;

public class Ejercicio6VideojuegosReto {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Scanner sc = new Scanner(System.in);
		String user="default", userMasPuntos="default";
		int usuarios=0, partidas=0, puntos=0, enemigos=0, enemigosTotal=0;
		double puntosTotal=0, masPuntos=0, puntosTotalTodos=0, enemigosTotalTodos=0;
		
		System.out.println("Cuantos jugadores van a registrar? (max. 6): ");
		usuarios = sc.nextInt();
		
		while (usuarios > 6 || usuarios < 1) {
			System.out.println(" ");
			System.out.println("Error. Solo se admite 1 a 6 jugadores:  ");
			usuarios = sc.nextInt();
		}
		
		for (int i=1; i<=usuarios; i++) {
			puntos=0;
			enemigos=0;
			user = "default";
			do {
				System.out.println(" ");
				System.out.println("Usuario "+i);
				System.out.println("Cual es tu usuario? ");
				user=sc.next();
			} while (user.equals("default"));
			
			System.out.println(" ");
			System.out.println("Hola "+user);
			
			System.out.println(" ");
			System.out.println("Cuntas partidas has jugado?: ");
			partidas=sc.nextInt();
			
			while (partidas > 10 || partidas < 1) {
				System.out.println(" ");
				System.out.println("Error. Este programa solo permite un maximo de 10 partidas:  ");
				partidas = sc.nextInt();
			}
			
			for (int j=1; j<=partidas; j++) {
				System.out.println(" ");
				System.out.println("Partida "+j);
				System.out.println("Cuantos puntos has conseguido?: ");
				puntos=sc.nextInt();
				
				if (masPuntos<puntos) {
					masPuntos=masPuntos + puntos;
					userMasPuntos=user;
				}
				
				puntosTotal=puntosTotal + puntos;
				
				System.out.println(" ");
				System.out.println("Cuantos enemigos has derrotado?: ");
				enemigos=sc.nextInt();
				
				enemigosTotal=enemigosTotal + enemigos;
				
				enemigosTotalTodos=enemigosTotalTodos + enemigos;
			}
			
			if (puntosTotal>1000) {
				puntosTotal=puntosTotal + 100;
			}
			
			puntosTotalTodos=puntosTotalTodos + puntosTotal;
			
			System.out.println(" ");
			System.out.println("Total de puntos conseguidos: "+puntosTotal+" puntos.");
			
			System.out.println(" ");
			System.out.println("Total de enemigos derrotados: "+enemigosTotal+" enemigos derrotados.");
			
			System.out.println(" ");
			System.out.println("La media de puntos por partida: "+(puntosTotal/partidas)+" puntos.");
			
		}
		
		System.out.println(" ");
		System.out.println(" ");
		System.out.println(" ");
		System.out.println("El jugador con mas puntuacion es: "+userMasPuntos+" con "+masPuntos+" puntos.");
		
		System.out.println(" ");
		System.out.println("En total, todos los usuarios han conseguido "+puntosTotalTodos+" puntos.");
		
		System.out.println(" ");
		System.out.println("Se ha derrotado "+enemigosTotalTodos+" enemigos totales.");
		
		sc.close();
		
	}

}
