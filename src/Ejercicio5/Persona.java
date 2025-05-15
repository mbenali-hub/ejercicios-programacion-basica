package Ejercicio5;



public class Persona {
	
	private String sexo;
	//private Datos datos=new Datos();
	private int edad;
	private int estatura;
	private int nivelEstudios;
	private int nivelIngresos;
	private int puntuacionFinal;
	
	public Persona(String sexo, int edad, int estatura,int nivelEstudios, int nivelIngresos) {
		this.sexo = sexo;
		this.edad = edad;
		this.estatura = estatura;
		this.nivelEstudios=nivelEstudios;
		this.nivelIngresos = nivelIngresos;
		puntuacionFinal=0;
	}
	

	private String correspondenciaANivelEstudio(int nivelEstudios) {
		String nvl="";
		switch(nivelEstudios) {
			case 0:
				nvl="Sin estudios";
				break;
			case 1:
				nvl="ESO";
				break;
			case 2:
				nvl="Bachillerato/grado superior";
				break;
			case 3:
				nvl="Grado universitario";
				break;
			case 4:
				nvl="Master";
				break;
			case 5:
				nvl="Doctor";
				break;
		}
		return nvl;
	}

	@Override
	public String toString() {
		return "Persona [sexo=" + sexo + ", edad=" + edad + ", estatura=" + estatura +" nivelEstudio="+correspondenciaANivelEstudio(nivelEstudios)+", nivelIngresos="
				+ nivelIngresos + ", Puntuacion= "+puntuacionFinal+"]";
	}

	public String getSexo() {
		return sexo;
	}

	public void setSexo(String sexo) {
		this.sexo = sexo;
	}

	public int getEdad() {
		return edad;
	}

	public void setEdad(int edad) {
		this.edad = edad;
	}

	public int getEstatura() {
		return estatura;
	}

	public void setEstatura(int estatura) {
		this.estatura = estatura;
	}

	public int getNivelEstudios() {
		return nivelEstudios;
	}

	public void setNivelEstudios(int nivelEstudios) {
		this.nivelEstudios = nivelEstudios;
	}

	public int getNivelIngresos() {
		return nivelIngresos;
	}

	public void setNivelIngresos(int nivelIngresos) {
		this.nivelIngresos = nivelIngresos;
	}
	
	
	public int getPuntuacion() {
		return puntuacionFinal;
	}
	
	public void setPuntuacion(int puntuacion) {
		puntuacionFinal=puntuacion;
	}
}
