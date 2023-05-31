package solucion;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;

public class Vuelo {

	private String origen = "";
	private String destino = "";
	private Integer nro = 12;
	private LocalDate fecha;
	private LocalTime hora;
	private Avion avion;
	private Integer id = 0;
	private List<Personal> personal;
	
	// COSAS LISTAS SIRVE PARA SABER SI EN EL VUELO SE INGRESARON LOS PASAJEROS, PERSONAL Y AVION. ASI PUEDE FUNCIONAR EL METODO (EN AEROLINEA) DESPEGAR()
	private Integer cosasListas = 0;

	public Integer getCosasListas() {
		return cosasListas;
	}

	public void setCosasListas(Integer cosasListas) {
		this.cosasListas = cosasListas;
	}

	public Vuelo(Integer nro, LocalDate fecha, LocalTime hora, String origen, String destino) {
		this.origen = origen;
		this.destino = destino;
		this.nro = nro;
		this.fecha = fecha;
		this.hora = hora;
		this.id++;
		this.personal = new ArrayList<>();

	}

	public Avion getAvion() {
		return this.avion;
	}

	public Integer getId() {
		return this.id;
	}

	public void setAvion(Avion avion) {
		this.avion = avion;
	}

	public void agregarPesonalAlVuelo(Personal personal) {
		this.personal.add(personal);

	}

	public Integer getCantDePersonal() {

		return personal.size();

	}

	public Boolean asientoDisponible(Pasajero pasajero, Integer asiento) {

		if (this.avion.ocuparAsiento(asiento, pasajero)) {

			return true;
		}

		return false;

	}

	public String getOrigen() {
		return origen;
	}

	public void setOrigen(String origen) {
		this.origen = origen;
	}

	public String getDestino() {
		return destino;
	}

	public void setDestino(String destino) {
		this.destino = destino;
	}

	public Integer getNro() {
		return nro;
	}

	public void setNro(Integer nro) {
		this.nro = nro;
	}

	public LocalDate getFecha() {
		return fecha;
	}

	public void setFecha(LocalDate fecha) {
		this.fecha = fecha;
	}

	public LocalTime getHora() {
		return hora;
	}

	public void setHora(LocalTime hora) {
		this.hora = hora;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Vuelo other = (Vuelo) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}

}
