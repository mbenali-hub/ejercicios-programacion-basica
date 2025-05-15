package Ejercicio5;

public class HiloProductor implements Runnable {
	
	private Datos datos;

	public HiloProductor(Datos datos) {
		this.datos = datos;
	}


	@Override
	public void run() {
		
		//false
		while(!datos.terminarEvaluaciones()) {
			datos.producir();
		}
		
	}

}
