package Ejercicio3;

public class HiloConsumidor implements Runnable {

private Datos datos;
	
	public HiloConsumidor(Datos datos) {
		this.datos=datos;
	}
	@Override
	public void run() {
		while(true) {
			try {
			Thread.sleep(10);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
			datos.consumir();
			//System.out.println(datos.getPresas());
		}
	}

}
