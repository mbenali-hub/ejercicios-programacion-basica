package Ejercicio3;

public class Ecosistema {

	public static void main(String[] args) {
		Datos datos = new Datos();
		Thread hiloConsumidor = new Thread(new HiloConsumidor(datos));
		hiloConsumidor.start();
		Thread hiloproductor = new Thread(new HiloProductor(datos));
		hiloproductor.start();
		Thread hiloMonitor = new Thread(new HiloMonitor(datos));
		hiloMonitor.start();

	}

}
