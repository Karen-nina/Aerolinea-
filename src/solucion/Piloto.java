package solucion;

public class Piloto extends Personal {
	private String tipoDeAvion="";


	public Piloto(String nombre, String apellido, Integer legajo, String tipoDeAvion) {
		super(nombre, apellido, legajo);
		this.tipoDeAvion=tipoDeAvion;
	}


	public String getTipoDeAvion() {
		return tipoDeAvion;
	}


	public void setTipoDeAvion(String tipoDeAvion) {
		this.tipoDeAvion = tipoDeAvion;
	}

	
	
	
}
