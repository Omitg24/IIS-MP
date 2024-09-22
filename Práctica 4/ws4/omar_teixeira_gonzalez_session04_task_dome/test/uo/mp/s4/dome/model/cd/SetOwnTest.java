package uo.mp.s4.dome.model.cd;

import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;

import uo.mp.s4.dome.model.Cd;
import uo.mp.s4.dome.model.Item;

/**
 * Titulo: Clase SetOwnTest
 * 
 * @author Omitg
 * @version 18-02-2021
 */
public class SetOwnTest {
	/**
	 * Atributo Cd
	 */
	private Item aCD;
	
	/**
	 * Atributo titulo
	 */
	private String theTitle;
	
	/**
	 * Atributo artista
	 */
	private String theArtist;
	
	/**
	 * Atributo tiempo, duracion
	 */
	private int theTime;

	/**
	 * Atributo tracks, numero de pistas
	 */
	private int theTracks;
	
	/**
	 * Atributo basePrice, precio base
	 */
	private double basePrice;
	
	/**
	 * Creación de atributos para su uso posterior
	 */
	@Before
	public void setUp() {
		theTitle = "Come Together";
		theArtist = "Beatles";
		theTime = 70;
		theTracks = 4;
		basePrice = 19.9;
		aCD = new Cd(theTitle, theArtist, theTracks, theTime, basePrice);
	}
	
	/**
	 * Pruebas del método setOwn de la clase Cd:
	 * 1- Se pasa true dos veces
	 * 2- Se pasa true y posteriormente se pasa false
	 * 3- Se pasa false dos veces
	 * 4- Se pasa false y posteriormente se pasa true 
	 */
	
	/**
	 * 1- Se pasa true dos veces
	 * GIVEN cd con valor true para propietario 
	 * WHEN se invoca setOwn con true
	 * THEN el cd permanece con true en propietario 
	 */
	@Test
	public void trueToTrue() {
		aCD.setOwn(true);
		aCD.setOwn(true);
		assertEquals(true, aCD.getOwn());
	}

	/**
	 * 2- Se pasa true y posteriormente se pasa false
	 * GIVEN cd con valor true para propietario 
	 * WHEN se invoca setOwn con false
	 * THEN el cd cambia a false en propietario 
	 */
	@Test
	public void trueToFalse() {
		aCD.setOwn(true);
		aCD.setOwn(false);
		assertEquals(false, aCD.getOwn());
	}

	/**
	 * 3- Se pasa false dos veces
	 * GIVEN cd con valor false para propietario 
	 * WHEN se invoca setOwn con false
	 * THEN el cd permanece con false en propietario 
	 */
	@Test
	public void falseToFalse() {
		aCD.setOwn(false);
		aCD.setOwn(false);
		assertEquals(false, aCD.getOwn());
	}

	/**
	 * 4- Se pasa false y posteriormente se pasa true
	 * GIVEN cd con valor false para propietario 
	 * WHEN se invoca setOwn con true
	 * THEN el cd cambia a true en propietario
	 */
	@Test
	public void falseToTrue() {
		aCD.setOwn(false);
		aCD.setOwn(true);
		assertEquals(true, aCD.getOwn());
	}
}
