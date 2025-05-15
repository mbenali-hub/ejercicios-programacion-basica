package Ejercicio5;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class BusquedaPareja {

	public static void main(String[] args) {
		Datos datos= new Datos();
		Scanner sc = new Scanner(System.in);
		
		System.out.println("Introduce nuemro de hilos evaluadores...");
		int nHilosConsumidores=sc.nextInt();
		
		Thread hiloP= new Thread(new HiloProductor(datos));
		hiloP.start();
		List<Thread> hilosConsumidores = new ArrayList<Thread>();
		Thread hiloC=null;
		
		for (int i = 0; i < nHilosConsumidores; i++) {
			hiloC = new Thread(new HiloConsumidor(datos,i));
			hilosConsumidores.add(hiloC);
		}
		
		for (Thread h : hilosConsumidores) {
			h.start();
		}
		
		for (Thread h : hilosConsumidores) {
			try {
				h.join();
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
	}

}
