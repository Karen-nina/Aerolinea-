package solucion;

public class Pasajero {
	private Boolean pasaporte=false;
	private Integer vueloComprado=0;
	
	
	public Pasajero(Boolean pasaporte) {
	this.pasaporte=pasaporte;
	}


	public Boolean getPasaporte() {
		return pasaporte;
	}


	public void setPasaporte(Boolean pasaporte) {
		this.pasaporte = pasaporte;
	}


	public Integer getVueloComprado() {
		return vueloComprado;
	}


	public void setVueloComprado(Integer vueloComprado) {
		this.vueloComprado = vueloComprado;
	}

}
