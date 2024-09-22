package uo.mp.s4.algorithms;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.junit.Before;
import org.junit.Test;

import uo.mp.s4.dome.model.Cd;
import uo.mp.s4.dome.model.Dvd;
import uo.mp.s4.dome.model.VideoGame;
import uo.mp.s4.dome.model.VideoGame.Platform;
import uo.mp.s4.Algorithms;

/**
 * Titulo: Clase SearchTest
 * 
 * @author Omitg
 * @version 26-02-2021
 */
public class SearchTest {
//Atributos:
	/**
	 * Atributo lista
	 */
	private List<Object> objects;
	
	/**
	 * Atributo Dvd
	 */
	private Dvd dvd1;
	
	/**
	 * Atributo Cd
	 */
	private Cd cd1;
	
	/**
	 * Atributo VideoGame
	 */
	private VideoGame vg1;
	
	/**
	 * Creaci�n de atributos para su uso posterior
	 */
	@Before
	public void setUp(){
		dvd1 = new Dvd("The Godfather", "F. F. Koppola", 256, 19.9);
		cd1 = new Cd("Come Together", "Beatles", 4, 70, 14.99);
		vg1 = new VideoGame("Fifa", "JPK", 4, Platform.NINTENDO, 39.99);
		objects = new ArrayList<>();
	
		objects.add( 1 );
		objects.add( 'a' );
		objects.add( "Hi" );
		objects.add( new Date() );
		objects.add( dvd1 );
		objects.add( cd1 );
		objects.add( vg1 );
	}
	
	/**
	 * Pruebas del m�todo search de la clase Algorithms:
	 * Pruebas de funcionalidad:
	 * 1- Busca un valor que si esta -> Devuelve la posici�n
	 * 2- Busca un valor que no esta -> Devuelve -1
	 * 3- Busca un caracter -> Devuelve la posici�n
	 * 4- Busca una palabra -> Devuelve la posici�n
	 * 5- Busca un objeto dvd -> Devuelve la posici�n
	 * 6- Busca un objeto cd -> Devuelve la posici�n
	 * 7- Busca un objeto videogame -> Devuelve la posici�n
	 * 
	 * Pruebas de robustez:
	 * 8- Recibe lista null -> Lanza la excepci�n 
	 * 9- Recibe objeto null -> Lanza la excepci�n
	 * 10- Recibe ambos null -> Lanza la excepci�n
	 * 
	 */
	
//Pruebas de funcionalidad:
	/**
	 * 1- Busca un valor que si esta -> Devuelve la posici�n
	 * GIVEN Se crean objetos y un arrayList, se a�aden los objetos a la lista
	 * WHEN Se llama m�todo search con la busqueda de un valor
	 * THEN Se comprueba que la posici�n esperada es igual a la soluci�n
	 */
	@Test
	public void testOne() {
		int pos = Algorithms.search( objects, 1 );
		assertTrue( pos == 0 );
	}

	/**
	 * 2- Busca un valor que no esta -> Devuelve -1
	 * GIVEN Se crean objetos y un arrayList, se a�aden los objetos a la lista
	 * WHEN Se llama m�todo search con la busqueda de un valor que no esta
	 * THEN Se comprueba devuelve -1
	 */
	@Test
	public void tesNonExisting() {
		int pos = Algorithms.search( objects, 25 );
		assertTrue( pos == -1 );
	}

	/**
	 * 3- Busca un caracter -> Devuelve la posici�n
	 * GIVEN Se crean objetos y un arrayList, se a�aden los objetos a la lista
	 * WHEN Se llama m�todo search con la busqueda de un caracter
	 * THEN Se comprueba que la posici�n esperada es igual a la soluci�n
	 */
	@Test
	public void tesA() {
		int pos = Algorithms.search( objects, 'a' );
		assertTrue( pos == 1 );
	}

	/**
	 * 4- Busca una palabra -> Devuelve la posici�n
	 * GIVEN Se crean objetos y un arrayList, se a�aden los objetos a la lista
	 * WHEN Se llama m�todo search con la busqueda de una palabra
	 * THEN Se comprueba que la posici�n esperada es igual a la soluci�n
	 */
	@Test
	public void tesHi() {
		int pos = Algorithms.search( objects, "Hi" );
		assertTrue( pos == 2 );
	}

	/**
	 * 5- Busca un objeto dvd -> Devuelve la posici�n
	 * GIVEN Se crean objetos y un arrayList, se a�aden los objetos a la lista
	 * WHEN Se llama m�todo search con la busqueda de un cd
	 * THEN Se comprueba que la posici�n esperada es igual a la soluci�n
	 */
	@Test
	public void tesDvd() {
		Dvd dvd = new Dvd("The Godfather", "F. F. Koppola", 256, 19.99);
		int pos = Algorithms.search( objects, dvd );
		assertTrue( pos == 4 );
	}

	/**
	 * 6- Busca un objeto cd -> Devuelve la posici�n
	 * GIVEN Se crean objetos y un arrayList, se a�aden los objetos a la lista
	 * WHEN Se llama m�todo search con la busqueda de un dvd
	 * THEN Se comprueba que la posici�n esperada es igual a la soluci�n
	 */
	@Test
	public void tesCd() {
		Cd cd = new Cd("Come Together", "Beatles",4, 70, 14.99);
		int pos = Algorithms.search( objects, cd );
		assertTrue( pos == 5 );
	}

	/**
	 * 7- Busca un objeto videogame -> Devuelve la posici�n
	 * GIVEN Se crean objetos y un arrayList, se a�aden los objetos a la lista
	 * WHEN Se llama m�todo search con la busqueda de un videogame
	 * THEN Se comprueba que la posici�n esperada es igual a la soluci�n
	 */
	@Test
	public void tesVideoGame() {
		VideoGame vg = new VideoGame("Fifa", "JPK", 4, Platform.NINTENDO, 39.99);
		int pos = Algorithms.search( objects, vg );
		assertTrue( pos == 6 );
	}
	
//Pruebas de robustez:
	/**
	 * 8- Recibe lista null -> Lanza la excepci�n
	 * GIVEN Se crean objetos y un arrayList, se a�aden los objetos a la lista
	 * WHEN Se llama m�todo search con la lista null
	 * THEN Se lanza la excepci�n
	 */
	@Test
	(expected =IllegalArgumentException.class)
	public void testNullList() {
		Algorithms.search( null, vg1 );
	}
	
	/**
	 * 9- Recibe objeto null -> Lanza la excepci�n
	 * GIVEN Se crean objetos y un arrayList, se a�aden los objetos a la lista
	 * WHEN Se llama m�todo search con el objeto null
	 * THEN Se lanza la excepci�n
	 */
	@Test
	(expected =IllegalArgumentException.class)
	public void testNullObject() {
		Algorithms.search( objects, null );
	}
	
	/**
	 * 10- Recibe ambos null -> Lanza la excepci�n
	 * GIVEN Se crean objetos y un arrayList, se a�aden los objetos a la lista
	 * WHEN Se llama m�todo search con la lista y el objeto null
	 * THEN Se lanza la excepci�n
	 */
	@Test
	(expected =IllegalArgumentException.class)
	public void testNullBoth() {
		Algorithms.search( null, null);
	}
}