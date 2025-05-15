package Ejercicio3;

public class HiloMonitor implements Runnable {
	private Datos datos;
	public HiloMonitor(Datos datos) {
		this.datos=datos;
	}
	@Override
	public void run() {
		while(true) {
			try {
				Thread.sleep(1);
				System.out.println("Presas actuales: "+datos.getPresas());
				System.out.println("Promedio actual: "+datos.getPromedio());
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}

	}

}
