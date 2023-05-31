package ar.edu.unlam.aerolinea;

import static org.junit.Assert.*;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.Month;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

import org.junit.Test;

import solucion.Aerolinea;
import solucion.Avion;
import solucion.Azafata;
import solucion.Pasajero;
import solucion.Personal;
import solucion.Piloto;
import solucion.Vuelo;

public class testAerolinea {

	@Test
	public void crearAerolinea() {
		String nombre = "Humanos unidos";
		Integer aerolineaId = 2561;

		Aerolinea aerolinea = new Aerolinea(nombre);

		// hacer un atributo de cuando creas aerolinea se suma a ese atributo +1

		assertEquals(aerolineaId, aerolinea.id());

	}

	@Test
	public void queSePuedaCrearVuelo() {
		
		String origen = "Buenos Aires";
		String destino = "Cancun";
		Integer nro = 12;
		LocalDate fecha = LocalDate.of(2022, Month.MAY, 04);
		LocalTime hora = LocalTime.of(9, 30);
		
		Vuelo vuelo = new Vuelo(nro, fecha, hora, origen, destino);
		
		Integer idVuelo = 1;
		
		assertEquals(idVuelo, vuelo.getId());
	}
	@Test
	public void queAVueloSeLePuedaAsignarUnAvion() {

		String origen = "Buenos Aires";
		String destino = "Cancun";
		Integer nro = 12;
		LocalDate fecha = LocalDate.of(2022, Month.MAY, 04);
		LocalTime hora = LocalTime.of(9, 30);

		Integer nroDeAvion = 520;
		String modelo = "Boing 747";
		String fabricante = "Airbuss";
		Integer capacidad = 200;

		Avion avion = new Avion(nroDeAvion, modelo, fabricante, capacidad);

		Vuelo vuelo = new Vuelo(nro, fecha, hora, origen, destino);

		String nombre = "Humanos unidos";

		Aerolinea aerolinea = new Aerolinea(nombre);

		aerolinea.agregarVuelo(vuelo);

		aerolinea.agregarAvion(avion, vuelo.getId());

		assertEquals(avion, aerolinea.buscarVueloPorId(vuelo.getId()).getAvion());

	}


	@Test
	public void queNoSePuedanSumarMisDe2Pilotos() {
		String nombre = "Carlitos";
		String apellido = "Hernandez";
		Integer legajo = 0;

		List<Personal> personalGeneral = new ArrayList<>();

		Azafata personal1 = new Azafata(nombre, apellido, legajo);
		Piloto personal2 = new Piloto("Julian", "forza", 585220, "Boing 747");
		Piloto personal3 = new Piloto("Julian", "Hown", 585220, "Boing 747");

		personalGeneral.add(personal1);
		personalGeneral.add(personal2);
		personalGeneral.add(personal3);

		String origen = "Buenos Aires";
		String destino = "Cancun";
		Integer nro = 12;
		LocalDate fecha = LocalDate.of(2022, Month.MAY, 04);
		LocalTime hora = LocalTime.of(9, 30);

		Integer nroDeAvion = 520;
		String modelo = "Boing 747";
		String fabricante = "Airbuss";
		Integer capacidad = 200;

		Avion avion = new Avion(nroDeAvion, modelo, fabricante, capacidad);

		Vuelo vuelo = new Vuelo(nro, fecha, hora, origen, destino);

		String nombreAero = "Humanos unidos";

		Aerolinea aerolinea = new Aerolinea(nombreAero);

		aerolinea.agregarVuelo(vuelo);

		aerolinea.agregarAvion(avion, vuelo.getId());

		aerolinea.agregarPesonalAlVuelo(personalGeneral, vuelo);

		Integer cantPersonal = 2;

		assertEquals(cantPersonal, vuelo.getCantDePersonal());
		

	}
	@Test
	public void quenosepuedanasignarmasde4azafatas() {
		String nombre = "Carlitos";
		String apellido = "Hernandez";
		Integer legajo = 0;

		List<Personal> personalGeneral = new ArrayList<>();

		Azafata personal1 = new Azafata(nombre, apellido, legajo);
		Piloto personal2 = new Piloto("Julian", "forza", 585220, "Boing 747");
		Azafata personal3 = new Azafata("Maria", "Hown", 585222);
		Azafata personal4 = new Azafata("Julieta", "Hown", 585282);
		Azafata personal5 = new Azafata("Julian", "Hown", 58522);
		Azafata personal6 = new Azafata("Rouz", "Hown", 585282);

		personalGeneral.add(personal1);
		personalGeneral.add(personal2);
		personalGeneral.add(personal3);
		personalGeneral.add(personal4);
		personalGeneral.add(personal5);
		personalGeneral.add(personal6);

		String origen = "Buenos Aires";
		String destino = "Cancun";
		Integer nro = 12;
		LocalDate fecha = LocalDate.of(2022, Month.MAY, 04);
		LocalTime hora = LocalTime.of(9, 30);

		Integer nroDeAvion = 520;
		String modelo = "Boing 747";
		String fabricante = "Airbuss";
		Integer capacidad = 200;

		Avion avion = new Avion(nroDeAvion, modelo, fabricante, capacidad);

		Vuelo vuelo = new Vuelo(nro, fecha, hora, origen, destino);

		String nombreAero = "Humanos unidos";

		Aerolinea aerolinea = new Aerolinea(nombreAero);

		aerolinea.agregarVuelo(vuelo);

		aerolinea.agregarAvion(avion, vuelo.getId());

		aerolinea.agregarPesonalAlVuelo(personalGeneral, vuelo);

		Integer cantPersonal = 5;

		assertEquals(cantPersonal, vuelo.getCantDePersonal());
	}
	
	@Test
	public void queAunpasajeroSeLeAsigneUnAsientoDeVuelo() {
		Boolean pasaporte = true;

		Pasajero pasajero = new Pasajero(pasaporte);
		List<Personal> personalGeneral = new ArrayList<>();

		String nombre = "Carlitos";
		String apellido = "Hernandez";
		Integer legajo = 0;

		Azafata personal1 = new Azafata(nombre, apellido, legajo);
		Piloto personal2 = new Piloto("Julian", "forza", 585220, "Boing 747");
		Piloto personal3 = new Piloto("Julian", "Hown", 585220, "Boing 747");

		personalGeneral.add(personal1);
		personalGeneral.add(personal2);
		personalGeneral.add(personal3);

		String origen = "Buenos Aires";
		String destino = "Cancun";
		Integer nro = 12;
		LocalDate fecha = LocalDate.of(2022, Month.MAY, 04);
		LocalTime hora = LocalTime.of(9, 30);

		Integer nroDeAvion = 520;
		String modelo = "Boing 747";
		String fabricante = "Airbuss";
		Integer capacidad = 200;

		Avion avion = new Avion(nroDeAvion, modelo, fabricante, capacidad);

		avion.contarAsientos();

		Vuelo vuelo = new Vuelo(nro, fecha, hora, origen, destino);

		String nombreAero = "Humanos unidos";

		Aerolinea aerolinea = new Aerolinea(nombreAero);

		aerolinea.agregarVuelo(vuelo);

		aerolinea.agregarAvion(avion, vuelo.getId());

		aerolinea.agregarPesonalAlVuelo(personalGeneral, vuelo);

		Integer asiento = 1;

		Boolean sePudo=true;
		assertEquals(sePudo, aerolinea.comprarVuelo(pasajero, vuelo, asiento));


	}

	@Test
	public void quesepuedasubirpasajeroalvuelo() {
		
		Boolean pasaporte = true;
		List<Pasajero> pasajeros = new ArrayList<>();

		for (int i = 0; i < 20; i++) {

			pasajeros.add(new Pasajero(pasaporte));

		}

		List<Personal> personalGeneral = new ArrayList<>();

		String nombre = "Carlitos";
		String apellido = "Hernandez";
		Integer legajo = 0;

		Azafata personal1 = new Azafata(nombre, apellido, legajo);
		Piloto personal2 = new Piloto("Julian", "forza", 585220, "Boing 747");
		Piloto personal3 = new Piloto("Julian", "Hown", 585220, "Boing 747");

		personalGeneral.add(personal1);
		personalGeneral.add(personal2);
		personalGeneral.add(personal3);

		String origen = "Buenos Aires";
		String destino = "Cancun";
		Integer nro = 12;
		LocalDate fecha = LocalDate.of(2022, Month.MAY, 04);
		LocalTime hora = LocalTime.of(9, 30);

		Integer nroDeAvion = 520;
		String modelo = "Boing 747";
		String fabricante = "Airbuss";
		Integer capacidad = 200;

		Avion avion = new Avion(nroDeAvion, modelo, fabricante, capacidad);

		avion.contarAsientos();

		Vuelo vuelo = new Vuelo(nro, fecha, hora, origen, destino);

		String nombreAero = "Humanos unidos";

		Aerolinea aerolinea = new Aerolinea(nombreAero);

		aerolinea.agregarVuelo(vuelo);

		aerolinea.agregarAvion(avion, vuelo.getId());

		aerolinea.agregarPesonalAlVuelo(personalGeneral, vuelo);

		Integer asiento = 1;

		for (Pasajero pasajero : pasajeros) {
			aerolinea.comprarVuelo(pasajero, vuelo, asiento);
			asiento++;

		}

		Boolean idVuelo = true;

		assertEquals(idVuelo, aerolinea.subirPasajeros(pasajeros, vuelo));

//		assertEquals(idVuelo, avion.ocuparAsiento(asiento,pasajero));

	}

	

}
