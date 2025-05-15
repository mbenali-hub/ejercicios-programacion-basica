package Ejercicio4;

import java.util.ArrayList;
import java.util.List;

public class Partido implements Runnable {

	private Datos datos;
	private long votosIniciales;
	private long votos;
	private int id;
	//private List<Integer> escanhos = new ArrayList<Integer>();
	private int eschanos;
	
	public Partido(Datos datos, long votos, int id) {
		this.datos=datos;
		this.votos=votos;
		votosIniciales=votos;
		this.id=id;
		eschanos=0;
	}
	@Override
	public void run() {
		while(datos.getEschanos()>0) {
			datos.registrarVotosPorPartido(id,votos);
			try {
				Thread.sleep(4000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			if(datos.seHanRecogidoTodosLosVotos()) {
				
				boolean haGanado=datos.verificarVotos( votos,id);
				
				if(haGanado) {
					//System.out.println("El partido: "+id+" ha ganado el escaño por que tiene mas votos "+votos);
					eschanos+=datos.recibirEscanho();
					System.out.println("El partido "+id+" (votos:"+votos+") ha ganado el escaño, nº escanhos :"+eschanos);
					votos=igualarVotos();
					datos.resetearVotos();
					
				}
//				else {
//					System.out.println("El partido: "+id+" no ha ganado el escaño por que no es el que mas votos tiene "+votos);
//				}
			}
						
		}

	}
	
	private long igualarVotos() {
		long v=0;
		v= (votosIniciales/eschanos)+1;
		return v;
	}
}
