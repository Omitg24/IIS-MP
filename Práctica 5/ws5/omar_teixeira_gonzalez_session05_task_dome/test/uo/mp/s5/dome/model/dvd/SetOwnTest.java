package uo.mp.s5.dome.model.dvd;

import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;

import uo.mp.s5.dome.model.Dvd;

/**
 * Titulo: Clase SetOwnTest
 * 
 * @author Omitg
 * @version 18-02-2021
 */
public class SetOwnTest {
	/**
	 * Atributo Dvd
	 */
	private Dvd aDVD;
	
	/**
	 * Atributo titulo
	 */
	private String theTitle;
	
	/**
	 * Atributo director
	 */
	private String theDirector;
	
	/**
	 * Atributo tiempo
	 */
	private int theTime;
	
	/**
	 * Atributo basePrice, precio base
	 */
	private double basePrice;

	/**
	 * Creaci�n de atributos para su uso posterior
	 */
	@Before
	public void setUp() {
		theTitle = "La guerra de las Galaxias";
		theDirector = "George Lucas";
		theTime = 125;
		basePrice = 14.99;
		aDVD = new Dvd(theTitle, theDirector, theTime, basePrice);
	}

	/**
	 * Pruebas del m�todo setOwn de la clase Dvd:
	 * 1- Se pasa true dos veces
	 * 2- Se pasa true y posteriormente se pasa false
	 * 3- Se pasa false dos veces
	 * 4- Se pasa false y posteriormente se pasa true 
	 */
	
	/**
	 * 1- Se pasa true dos veces
	 * GIVEN cd con valor true para propietario 
	 * WHEN se invoca setOwn con true
	 * THEN el dvd permanece con true en propietario 
	 */
	@Test
	public void trueToTrue() {
		aDVD.setOwn(true);
		aDVD.setOwn(true);
		assertEquals(true, aDVD.getOwn());
	}

	/**
	 * 2- Se pasa true y posteriormente se pasa false
	 * GIVEN cd con valor true para propietario 
	 * WHEN se invoca setOwn con false
	 * THEN el dvd cambia a false en propietario 
	 */
	@Test
	public void trueToFalse() {
		aDVD.setOwn(true);
		aDVD.setOwn(false);
		assertEquals(false, aDVD.getOwn());
	}

	/**
	 * 3- Se pasa false dos veces
	 * GIVEN cd con valor false para propietario 
	 * WHEN se invoca setOwn con false
	 * THEN el dvd permanece con false en propietario 
	 */
	@Test
	public void falseToFalse() {
		aDVD.setOwn(false);
		aDVD.setOwn(false);
		assertEquals(false, aDVD.getOwn());
	}

	/**
	 * 4- Se pasa false y posteriormente se pasa true
	 * GIVEN cd con valor false para propietario 
	 * WHEN se invoca setOwn con true
	 * THEN el dvd cambia a true en propietario
	 */
	@Test
	public void falseToTrue() {
		aDVD.setOwn(false);
		aDVD.setOwn(true);
		assertEquals(true, aDVD.getOwn());
	}

}