package Ejercicio1;

import java.util.Iterator;
import java.util.Random;
import java.util.Scanner;

public class ProductoM2 {

	public static void main(String[] args) {
//		Realizar un programa que haga productos de matrices cuadradas. El usuario introduce dos 
//		números, el orden de las matrices y el número de hilos a utilizar. El programa crea dos 
//		matrices de ese orden con elementos aleatorios, y mediante hilos realiza el producto. 
//		Finalmente, se muestra el resultado y el tiempo que ha llevado el cálculo.
		
		Scanner sc = new Scanner(System.in);
		
		System.out.println("Introduce el orden: ");		
		int orden = sc.nextInt();
		Datos datos= new Datos(orden);
		Datos.resultado= new int[orden][orden];
		
		System.out.println("Introduce el numero de hilos: ");
		int numeroHilos = sc.nextInt();
		
		Thread[] hilos = new Thread[numeroHilos];
		int partePorHilo= orden/numeroHilos;
		int inicio=0;
		int fin;
		
		for (int i = 0; i < hilos.length; i++) {
			fin=inicio+partePorHilo;
			if(i==numeroHilos-1) {
				fin=orden;
			}
			hilos[i]= new Thread(new HiloCalculadorProducto(inicio, fin, orden, datos));
			hilos[i].start();
			inicio=fin;
		}
		
		try {
			for(Thread hilo: hilos) {
				hilo.join();
			}
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		System.out.println("Matriz A:");
        datos.mostrarMatriz(1);
        System.out.println("Matriz B:");
        datos.mostrarMatriz(2);
        System.out.println("Resultado:");
        datos.mostrarMatriz(3);

	}
	

}
