package Ejercicio1;

import java.util.Random;

public class Datos {
	private int[][] matriz1;
	private int[][] matriz2;
	public static int[][] resultado;
	
	public Datos(int orden) {
		matriz1= crearMatrizAleatoria(orden);
		matriz2= crearMatrizAleatoria(orden);
	}
	
	public void mostrarMatriz(int numero) {
		if(numero==1) {
			imprimirMatriz(matriz1);
		}
		else if(numero==2) {
			imprimirMatriz(matriz2);
		}
		else {
			imprimirMatriz(resultado);
		}
	}

	private void imprimirMatriz(int[][] m) {
		for (int i = 0; i < m.length; i++) {
			for (int j = 0; j < m[i].length; j++) {
				System.out.print(m[i][j]+" ");
			}
			System.out.print("\n");
		}
	}
	public int[][] crearMatrizAleatoria(int orden){
		Random r = new Random();
		int[][] matriz= new int[orden][orden];
		
		for (int i = 0; i < matriz.length; i++) {
			for (int j = 0; j < matriz[i].length; j++) {
				matriz[i][j]= r.nextInt(-100, 100);
			}
		}
		return matriz;
	}

	
	public synchronized void setResultado(int[][] matriz3){
		for (int i = 0; i < resultado.length; i++) {
			for (int j = 0; j < resultado[i].length; j++) {
				resultado[i][j]+=matriz3[i][j];
			}
		}
	}
	
	public synchronized int[][] getMatriz(int numero) {
		int[][] matriz;
		if(numero==1) {
			matriz=matriz1;
		}
		else if(numero==2) {
			matriz=matriz2;
		}
		else {
			matriz=resultado;
		}
		return matriz;
	}
	
	public synchronized int getValorFila(int fila, int[][] matriz) {
		int valor=0;
		boolean devuelto=false;
		for (int i = 0; i < matriz.length && !devuelto; i++) {
			for (int j = 0; j < matriz[i].length && !devuelto; j++) {
				 if(i==fila) {
					 valor=matriz[i][j];
					 devuelto=true;
				 }
			}
		}
		return valor;
	}
	
	public synchronized int getValorColumna(int columna,int fila, int[][] matriz) {
		int valor=0;
		boolean devuelto=false;
		for (int i = 0; i < matriz.length && !devuelto; i++) {
			for (int j = 0; j < matriz[i].length && !devuelto; j++) {
				 if(i==fila&&j==columna) {
					 valor=matriz[i][j];
					 devuelto=true;
				 }
			}
		}
		return valor;
	}
	
	public synchronized int[] getColumna(int columna,int[][] matriz) {
		int[] valoresColumna= new int[matriz.length];
		for (int i = 0; i < matriz.length; i++) {
			for (int j = 0; j < matriz[i].length; j++) {
				if(j==columna) {
					valoresColumna[i]=matriz[i][j];
				}
			}
		}
		return valoresColumna;
	}
	
	public synchronized int[] getFila(int fila, int[][] matriz) {
		int[] valoresFila=new int[matriz.length];
		for (int i = 0; i < matriz.length; i++) {
			for (int j = 0; j < matriz[i].length; j++) {
				if(i==fila) {
					valoresFila[j]=matriz[i][j];
				}
			}
		}
		return valoresFila;
	}
}
