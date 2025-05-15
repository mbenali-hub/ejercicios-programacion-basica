package Ejercicio5;

public class HiloConsumidor implements Runnable {
	
	private Datos datos;
	private int id;
	public HiloConsumidor(Datos datos,int id) {
		this.datos = datos;
		this.id=id;
	}

	@Override
	public void run() {
		while(!datos.terminarEvaluaciones()) {
			Persona p = datos.consumir();
			int puntuacion = datos.calcularPuntuacion(p,datos.getPersonaIdeal());
			System.out.println(id+" ha consumido: "+p.toString());
			
			if(puntuar(puntuacion)) {
				p.setPuntuacion(puntuacion);
				datos.escribirEnArchivo(p);			
				
			}
			datos.resesetearPuntuacion();
		}
		System.out.println("El hilo "+id+" ha terminado");
	}
	
	private boolean puntuar(int p) {
		boolean esCandidato=false;
		
		if(p>=5) {
			esCandidato=true;
		}
		
		return esCandidato;
	}
}
