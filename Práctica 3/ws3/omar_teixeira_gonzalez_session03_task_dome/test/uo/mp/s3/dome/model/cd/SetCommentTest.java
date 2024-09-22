package uo.mp.s3.dome.model.cd;

import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;

import uo.mp.s3.dome.model.Cd;
import uo.mp.s3.dome.model.Item;

/**
 * Titulo: Clase SetCommentTest
 * 
 * @author Omitg
 * @version 18-02-2021
 */
public class SetCommentTest {
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
	 * Creación de atributos para su uso posterior
	 */
	@Before
	public void setUp() {
		theTitle = "Come Together";
		theArtist = "Beatles";
		theTime = 70;
		theTracks = 4;
		aCD = new Cd(theTitle, theArtist, theTracks, theTime);
	}

	/**
	 * Pruebas del método setComment de la clase Cd:
	 * 1- Se escribe el comentario correctamente
	 * 2- Se escribe null y posteriormente el comentario correcto 
	 */
	
	/**
	 * 1- Se escribe el comentario correctamente
	 * GIVEN cd con comentario vacío 
	 * WHEN invoca setComment con cadena no vacía como comentario 
	 * THEN se cambia el comentario a la cadena 
	 */
	@Test
	public void setComment() {
		aCD.setComment("Excellent");

		assertEquals("Excellent", aCD.getComment());
	}

	/**
	 * 2- Se escribe null y posteriormente el comentario correcto
	 * GIVEN cd con comentario no vacío
	 * WHEN invoca setComment con null 
	 * THEN permanece el comentario que había
	 */
	@Test
	public void setInvalidComment() {
		aCD.setComment("Excellent");
		aCD.setComment(null);

		assertEquals("Excellent", aCD.getComment());
	}
}
