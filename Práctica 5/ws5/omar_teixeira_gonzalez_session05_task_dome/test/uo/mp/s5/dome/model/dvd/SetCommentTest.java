package uo.mp.s5.dome.model.dvd;

import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;

import uo.mp.s5.dome.model.Dvd;

/**
 * Titulo: Clase SetCommentTest
 * 
 * @author Omitg
 * @version 18-02-2021
 */
public class SetCommentTest {
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
	 * Creación de atributos para su uso posterior
	 */
	@Before
	public void setUp() {
		theTitle = "La guerra de las Galaxias";
		theDirector = "George Lucas";
		theTime = 125;
		basePrice = 29.9;
		aDVD = new Dvd(theTitle, theDirector, theTime, basePrice);
	}

	/**
	 * Pruebas del método setComment de la clase Cd:
	 * 1- Se escribe el comentario correctamente
	 * 2- Se escribe null y posteriormente el comentario correcto 
	 */
	
	/**
	 * 1- Se escribe el comentario correctamente
	 * GIVEN dvd con comentario vacío 
	 * WHEN invoca setComment con cadena no vacía como comentario 
	 * THEN se cambia el comentario a la cadena 
	 */
	@Test
	public void rigthComment() {
		aDVD.setComment("Excellent");

		assertEquals("Excellent", aDVD.getComment());
	}

	/**
	 * 2- Se escribe null y posteriormente el comentario correcto
	 * GIVEN dvd con comentario no vacío
	 * WHEN invoca setComment con null 
	 * THEN permanece el comentario que había
	 */
	@Test
	public void invalidComment() {
		aDVD.setComment("Excellent");
		aDVD.setComment(null);

		assertEquals("Excellent", aDVD.getComment());
	}

}