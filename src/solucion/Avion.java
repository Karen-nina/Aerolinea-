package solucion;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

public class Avion {
	Integer nroDeAvion;
	String modelo;
	String fabricante;
	Integer capacidad;
	Integer id = 0;
	Integer huveosLlenos=0;

	// MAPA ES COMO UN ARRAYLIST PERO TOMA DOS VALORES. 
	Map<Integer, Pasajero> capacidadAsientos;

	public Avion(Integer nroDeAvion, String modelo, String fabricante, Integer capacidad) {
		this.nroDeAvion = nroDeAvion;
		this.modelo = modelo;
		this.fabricante = fabricante;
		this.capacidad = capacidad;
		this.id++;
		this.capacidadAsientos = new HashMap<>();
	}

	public void contarAsientos() {
		Integer asientoNumero=1;

		for (int i = 0; i < this.capacidad; i++) {
			this.capacidadAsientos.put(asientoNumero,null);
			asientoNumero++;
		}

	}

	public Boolean ocuparAsiento(Integer numeroAsiento, Pasajero pasajero) {
		
//		if(numeroAsiento<=this.capacidad) {
//			if(this.capacidadAsientos.get(numeroAsiento) ==null) {
//				this.capacidadAsientos.put(numeroAsiento, pasajero);
//				return true;
//			}
//			
//		}
//		return false;
		
		
		
		// ESTO SIRVE PARA RECORRER UN MAP. ENTRY ALMACENADA CADA UNO DE LOS VALORES DEL
		// MAPA. PERO EN EL MAPA PONGO .ENTRYSET() PORQUE ASI SE PODRA VER TODO LO QUE
		// TIENE EL MAPA
		// ES UNA VISTA QUE A SU VEZ ES UNA COLLECION
		
		
		for (Map.Entry<Integer, Pasajero> asiento : capacidadAsientos.entrySet()) {

			Integer nroAsiento = asiento.getKey();
			Pasajero ocupado = asiento.getValue();

			if (nroAsiento.equals(numeroAsiento) && ocupado== null) {
				
				this.capacidadAsientos.put(nroAsiento, pasajero);
				return true;
			}

	}
		return false;

	}

	public Integer getNroDeAvion() {
		return nroDeAvion;
	}

	public void setNroDeAvion(Integer nroDeAvion) {
		this.nroDeAvion = nroDeAvion;
	}

	public String getModelo() {
		return modelo;
	}

	public void setModelo(String modelo) {
		this.modelo = modelo;
	}

	public String getFabricante() {
		return fabricante;
	}

	public void setFabricante(String fabricante) {
		this.fabricante = fabricante;
	}

	public Integer getCapacidad() {
		return capacidad;
	}

	public void setCapacidad(Integer capacidad) {
		this.capacidad = capacidad;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Integer getId() {
		return this.id;
	}

	@Override
	public int hashCode() {
		return Objects.hash(id);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Avion other = (Avion) obj;
		return Objects.equals(id, other.id);
	}

}
