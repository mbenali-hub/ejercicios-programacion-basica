package Ejercicio5;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Datos {
	
	private Persona personaIdeal;
	private Random r;
	private List<Persona> personas = new ArrayList<Persona>();
	private enum NivelEstudios{CERO,UNO,DOS,TRES,CUATRO,CINCO};
	private NivelEstudios[] niveles;
	private int suficientesCandidatos;
	private int puntuacionFinal;
	
	
	public Datos() {
		r= new Random();
		niveles=NivelEstudios.values();
		suficientesCandidatos=0;
		personaIdeal= new Persona("Mujer",23, 177, pasarAInt(NivelEstudios.TRES), 14000);
		puntuacionFinal=0;
		
	}
	
	public synchronized int calcularPuntuacion(Persona candidato,Persona pIdeal) {
		

		if(!candidato.getSexo().equals(pIdeal.getSexo())) {
			puntuacionFinal=0;
		}
		else {
			

			double diferenciaEdad = candidato.getEdad() - pIdeal.getEdad();
			double porcentajeEdad = (diferenciaEdad / pIdeal.getEdad()) * 100;

			// Calcula la diferencia y el porcentaje para la estatura
			double diferenciaEstatura = candidato.getEstatura() - pIdeal.getEstatura();
			double porcentajeEstatura = (diferenciaEstatura / pIdeal.getEstatura()) * 100;

			// Calcula la diferencia y el porcentaje para el nivel de estudios
			double diferenciaNivelEstudios = candidato.getNivelEstudios() - pIdeal.getNivelEstudios();
			double porcentajeNivelEstudios = (diferenciaNivelEstudios / pIdeal.getNivelEstudios()) * 100;

			// Calcula la diferencia y el porcentaje para el nivel de ingresos
			double diferenciaNivelIngresos = candidato.getNivelIngresos() - pIdeal.getNivelIngresos();
			double porcentajeNivelIngresos = (diferenciaNivelIngresos / pIdeal.getNivelIngresos()) * 100;

			// Calcula la puntuación para cada característica
			int puntuacion1 = 10 - (int) (2 * (porcentajeEdad / 5));
			int puntuacion2 = 10 - (int) (2 * (porcentajeEstatura / 5));
			int puntuacion3 = 10 - (int) (2 * (porcentajeNivelEstudios / 5));
			int puntuacion4 = 10 - (int) (2 * (porcentajeNivelIngresos / 5));
			
			// Calcula la puntuación final
			 puntuacionFinal = (puntuacion1 + puntuacion2 + puntuacion3 + puntuacion4) / 4;
			 
			 if (puntuacionFinal < 0) {
				    puntuacionFinal = 0;
				} else if (puntuacionFinal > 10) {
				    puntuacionFinal = 10;
				}

			// Imprime la puntuación final
			System.out.println("Puntuación final: " + puntuacionFinal);
			
		}
		//System.out.println(puntuacionFinal);
		
		return puntuacionFinal;
	}
	
	public synchronized void resesetearPuntuacion() {
		puntuacionFinal=0;
	}
	public synchronized Persona getPersonaIdeal() {
		return personaIdeal;
	}

	public synchronized void producir() {
		Persona p=null;
		while(!personas.isEmpty()) {
			try {
				wait();
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		p=generarPersonaAleatoria();
		personas.add(p);
		notifyAll();
		
	}
	
	public synchronized Persona consumir() {
		while(personas.isEmpty()) {
			try {
				wait();
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		Persona aux= personas.get(0);
		personas.remove(aux);
		notifyAll();
		return aux;
	}
	
	public synchronized void escribirEnArchivo(Persona p) {
		try {
			FileWriter fw = new FileWriter("candidatos.txt",true);
			BufferedWriter bw = new BufferedWriter(fw);
			bw.write(p.toString()+"\n");
			bw.flush();		
			suficientesCandidatos++;
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	public synchronized boolean terminarEvaluaciones() {
		boolean terminar=false;
		if(suficientesCandidatos>=50) {
			//notifyAll();
			terminar=true;
		}
		return terminar;
	}
	public Persona generarPersonaAleatoria() {
		String sexo=elegirSexo();
		int edad=r.nextInt(18,36);
		int estatura = r.nextInt(140, 211);
		NivelEstudios nivelesEs= (NivelEstudios) elegirNivelEstudios();
		int nivelIngesos= elegirNivelIngresos();
		
		Persona persona = new Persona(sexo, edad, estatura,pasarAInt(nivelesEs), nivelIngesos);
		return persona;
				
	}
	
	private String elegirSexo() {
		String sexo="";
		int x= r.nextInt(0, 2);
		if(x==0) {
			sexo="Hombre";
		}
		else {
			sexo="Mujer";
		}
		return sexo;
	}
	private NivelEstudios elegirNivelEstudios() {
		//String nivelEs="";
		int x = r.nextInt(0, 6);
		
		return niveles[x];
	}
	
	private int elegirNivelIngresos() {
		int nivelIng=0;
		List<Integer> nivelesValidos = new ArrayList<Integer>();
		for (int i = 0; i <= 50000; i++) {
			if(i%100==0) {
				nivelesValidos.add(i);
			}
		}
		int x= r.nextInt(0,nivelesValidos.size());
		nivelIng=nivelesValidos.get(x);
		return nivelIng;
	}
	
	private int pasarAInt(NivelEstudios nivel) {
		int nivelInt=0;
		switch(nivel) {
			case CERO:
				nivelInt=0;
				break;
			case UNO:
				nivelInt=1;
				break;
			case DOS:
				nivelInt=2;
				break;
			case TRES:
				nivelInt=3;
				break;
			case CUATRO:
				nivelInt=4;
				break;
			case CINCO:
				nivelInt=5;
				break;
		}
		return nivelInt;
	}
}
