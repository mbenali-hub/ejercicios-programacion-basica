package Ejercicio4;



public class Datos {
	private int eschanos=200;
	private long partidos;
	private long[] masVotosPorPartido;
	private boolean recogidos=false;
	private int partidovotados;
	

	public Datos(int partidos) {
		this.partidos=partidos;
		masVotosPorPartido=new long[partidos];

	}
	public synchronized void registrarVotosPorPartido(int id, long votos) {
		if(masVotosPorPartido[id]==0) {
			masVotosPorPartido[id]=votos;
			partidovotados++;
		}		
	 }
	 
	
	public synchronized boolean verificarVotos(long votos, int partido) {
	    boolean haGanado = false; 
	    long mVotos=0;
	    	for (int i = 0; i < masVotosPorPartido.length; i++) {
	    		if(masVotosPorPartido[i]>mVotos) {
	    			mVotos=masVotosPorPartido[i];
	    		}
	    	}
	    	//System.out.println(mVotos);
	    	if(votos==mVotos) {
	    		haGanado=true;
	    	}
	    return haGanado;
	}

	public synchronized boolean seHanRecogidoTodosLosVotos() {
		if(partidovotados>=partidos) {
			recogidos=true;
		}
		return recogidos;
		
	}
	
	public synchronized int recibirEscanho() {
		int eschano=0;
		if(eschanos!=0) {
			eschanos-=1;
			eschano=1;
		}
		return eschano;
	}
	
	public synchronized int getEschanos() {
		return eschanos;
	}
	
	public synchronized void resetearVotos() {
		for (int i = 0; i < masVotosPorPartido.length; i++) {
			masVotosPorPartido[i]=0;
		}
	}


}
