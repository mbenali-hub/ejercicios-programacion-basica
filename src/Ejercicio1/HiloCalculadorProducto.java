package Ejercicio1;

import java.util.Iterator;

public class HiloCalculadorProducto implements Runnable {

	private Datos datos;
	private int[][] matriz1;
	private int[][] matriz2;
	private int orden;
	private int inicio;
	private int fin;
	private int[][] resultado;
	
	public HiloCalculadorProducto(int inicio,int fin,int orden,Datos datos) {
		this.datos = datos;
		this.matriz1=datos.getMatriz(1);
		this.matriz2=datos.getMatriz(2);
		this.resultado= datos.getMatriz(3);
		this.orden=orden;
		this.inicio=inicio;
		this.fin=fin;
	}
	@Override
	public void run() {

		for (int i =inicio; i < fin; i++) {
			for (int j = 0; j < orden; j++) {
				for (int k = 0; k < orden; k++) {
					Datos.resultado[i][j]+=matriz1[i][k]*matriz2[k][j];
					//datos.setResultado(resultado);
				}
			}
		}
		
//		int valor1=0;
//		int valor2=0;
//		for (int i = 0; i < valoresFila.length; i++) {
//			System.out.println("Los valores de la fila de la matriz1:" +valoresFila[i]);
//			
//			
//		}
//		int[] valoresColumna= datos.getColumna(1, matriz2);
//		for (int i = 0; i < valoresColumna.length; i++) {
//			System.out.println("Los valores de la columna de la amtriz2:" +valoresColumna[i]);
//			
//		}
	}

}
