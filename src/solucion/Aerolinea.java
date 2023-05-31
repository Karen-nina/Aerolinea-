package solucion;

import java.util.ArrayList;
import java.util.List;


public class Aerolinea {

	private String nombre;
	private Integer id = 2560;
	private ArrayList<Vuelo> vuelos;
	private ArrayList<Avion> aviones;

	public Aerolinea(String nombre) {
		this.nombre = nombre;
		this.vuelos = new ArrayList<>();
		this.aviones = new ArrayList<>();
		this.id++;
	}

	public void agregarVuelo(Vuelo vuelo) {
		this.vuelos.add(vuelo);

	}

	public Integer cantidadDeVuelos() {
		return this.vuelos.size();
	}

	public Vuelo buscarVueloPorId(Integer id) {

		for (Vuelo vuelo : vuelos) {
			if (vuelo.getId().equals(id)) {
				return vuelo;
			}
		}

		return null;
	}

	public void agregarAvion(Avion avion, Integer vueloId) {
		Vuelo vueloEncontrado = buscarVueloPorId(vueloId);
		if (vueloEncontrado != null) {
			vueloEncontrado.setAvion(avion);
			this.aviones.add(avion);
			vueloEncontrado.setCosasListas((vueloEncontrado.getCosasListas()) + 1);
		}

	}

	public Avion buscarAvionPorId(Integer id) {

		for (Avion avion : aviones) {
			if (avion.getId().equals(id)) {
				return avion;
			}
		}

		return null;
	}

	public Boolean comprarVuelo(Pasajero pasajero, Vuelo vuelo, Integer asiento) {

		if (vuelo.asientoDisponible(pasajero, asiento)) {

			pasajero.setVueloComprado(vuelo.getId());
			return true;
		}

		return false;
	}

	public Boolean subirPasajeros(List<Pasajero> pasajeros, Vuelo vuelo) {

		for (Pasajero pasajero : pasajeros) {
			if (pasajero.getPasaporte()) {
				if (pasajero.getVueloComprado().equals(vuelo.getId())) {
					vuelo.setCosasListas((vuelo.getCosasListas()) + 1);
					return true;
				}
			}
		}

		return false;
	}

	public void agregarPesonalAlVuelo(List<Personal> personalGeneral, Vuelo vuelo) {
		Integer pilotosEnPersonal = 0;
		Integer AzafatasEnPersonal = 0;

		for (Personal personal : personalGeneral) {
			if (personal instanceof Piloto) {
				if (((Piloto) personal).getTipoDeAvion().equals(vuelo.getAvion().getModelo())) {
					pilotosEnPersonal++;
				}
			}
			if (personal instanceof Azafata) {
				AzafatasEnPersonal++;
			}
			if (pilotosEnPersonal <= 1 && AzafatasEnPersonal <= 4) {
				vuelo.agregarPesonalAlVuelo(personal);
				vuelo.setCosasListas((vuelo.getCosasListas()) + 1);

			}

		}

	}

	public Boolean despegar(Vuelo vuelo) {

		if (vuelo.getCosasListas().equals(3)) {
			vuelo.setFecha(vuelo.getFecha().plusDays(1));
			vuelo.setHora(vuelo.getHora().plusHours(2));
			return true;
		}
		return false;
	}

	public Integer id() {
		return this.id;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

}
