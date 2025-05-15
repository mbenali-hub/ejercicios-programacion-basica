package Ejercicio3;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.Random;

public class Datos {
	private List<Float> presas;
	private Random generador;
	private boolean noHayMasPresas;
	private float siguientePresa;
	private float promedio;
	private final float MAX_PRESAS=1000;
	
	public Datos() {
		noHayMasPresas=false;
		generador= new Random();
		presas= new ArrayList<Float>();
		promedio=calcularPromedio();
		generarPresas();

	}
	public synchronized void consumir() {
		
		if(!presas.isEmpty()) {
			
			float menor= calcularValorMenor();
			float mayor = calcularValorMayor();
			presas.remove(menor);
			presas.remove(mayor);

			promedio=calcularPromedio();
			//System.out.println("El depredaddor ha devorado a dos presas: "+menor+"/ "+mayor);
		}
		
	}
	
	public synchronized float getPromedio() {
		return promedio;
	}

	public synchronized void producir() {
//		while(presas.size()<500) {
//			try {
//				wait();
//			} catch (InterruptedException e) {
//				// TODO Auto-generated catch block
//				e.printStackTrace();
//			}
//		}
		 if (presas.size() < 500) {
	            generarNuevasPresas();
	            //System.out.println(presas.size()+"Presas. Generando mas:");
	        }
		//noHayMasPresas=true;
		notifyAll();
	}
	
	private float calcularValorMenor() {

		float valorMenor=presas.get(0);
		for (Float presa : presas) {
			if(presa<valorMenor) {
				valorMenor=presa;
			}
		}
		return valorMenor;
	}
	
	private float calcularValorMayor() {
		float valorMayor=presas.get(0);;
		for (Float presa : presas) {
			if(presa>valorMayor) {
				valorMayor=presa;
			}
		}
		return valorMayor;
	}
	
	public synchronized int getPresas() {
		return presas.size();
	}

	private void generarPresas() {
		for (int i = 0; i < MAX_PRESAS; i++) {
			presas.add(generador.nextFloat(0, 99));
		}
	}
	
	private void generarNuevasPresas() {
		for (int i = presas.size(); i < MAX_PRESAS; i++) {
			presas.add(generador.nextFloat(promedio-10, promedio+10));
		}
		promedio=calcularPromedio();
		
	}
	
	private float calcularPromedio() {
		float promedioNuevo=0;
		float suma=0;
		
		for (Float presa : presas) {
			suma+=presa;
		}
		
		promedioNuevo=suma/presas.size();
		return promedioNuevo;
	}
}
