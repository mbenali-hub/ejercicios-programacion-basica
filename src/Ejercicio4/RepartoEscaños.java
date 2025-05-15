package Ejercicio4;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

public class RepartoEscaños {

	public static void main(String[] args) {
		List<Thread> hilos = new ArrayList<Thread>();
		Scanner sc = new Scanner(System.in);
		System.out.println("Introduce la cantidad de partidos.");
		int partidos = sc.nextInt();
		Datos datos = new Datos(partidos);
		Random g = new Random();
		for (int i = 0; i < partidos; i++) {
			//System.out.println("Introduce el numero de votos para el partido "+i);
			long votos=sc.nextInt();
			System.out.println(votos);
			Thread hilo = new Thread(new Partido(datos,votos,i));
			hilos.add(hilo);
		}
		
		for (Thread thread : hilos) {
			thread.start();
		}
		
		
	}

}
