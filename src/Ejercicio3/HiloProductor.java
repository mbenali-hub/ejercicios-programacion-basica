package Ejercicio3;

public class HiloProductor implements Runnable {
	
	private Datos datos;
	
	public HiloProductor(Datos datos) {
		this.datos=datos;
	}
	@Override
	public void run() {
		while(true) {
			//System.out.println(datos.getPresas());
			if(datos.getPresas()<500) {
				datos.producir();
				
			}
		}

	}

}
