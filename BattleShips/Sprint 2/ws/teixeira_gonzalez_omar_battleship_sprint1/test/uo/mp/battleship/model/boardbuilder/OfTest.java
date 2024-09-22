package uo.mp.battleship.model.boardbuilder;

import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;

import uo.mp.battleship.board.BoardBuilder;

/**
 * Titulo: Clase OfTest
 * 
 * @author Omitg
 * @version 12-02-2021
 */
public class OfTest {		
	/**
	 * Atributo board
	 */
	private BoardBuilder board;
	
	/**
	 * Atributos tama�o
	 */
	private int size10, size5, size15, size2, size20;
	
	/**
	 * Creacion de objetos para su posterior uso
	 */
	@Before
	public void setUp() {
		board = new BoardBuilder();
		size10 = 10;
		size5 = 5;
		size15 = 15;
		size2 = 2;
		size20 = 20;
	}
	
	/**
	 * Pruebas del m�todo Of de la clase BoardBuilder:
	 * Pruebas de funcionalidad:
	 * 1- Size entre limites
	 * 2- Size tama�o minimo 
	 * 3- Size tama�o m�ximo
	 * 
	 * Pruebas de robustez:
	 * 4- Inferior al tama�o minimo
	 * 5- Superior al tama�o m�ximo
	 */
//Pruebas de funcionalidad:
	/**
	 * 1- Size entre limites
	 * GIVEN Se creea un boardBuilder y varios tama�os
	 * WHEN Se le pasa un tama�o valido al m�tood Of
	 * THEN Se comprueba que el tama�o es correcto
	 */
	 @Test
	 public void testOfInLimit() {
		 board.of(size10);
		 assertEquals(size10, board.getSize());
	 }
	 
	 /**
	  * 2- Size tama�o minimo 
	 * GIVEN Se creea un boardBuilder y varios tama�os
	 * WHEN Se le pasa un tama�o valido al m�tood Of
	 * THEN Se comprueba que el tama�o es correcto
	 */
	 @Test
	 public void testOfInLowerLimit() {
		 board.of(size5);
		 assertEquals(size5, board.getSize());
	 }
	 
	 /**
	  * 3- Size tama�o m�ximo 
	 * GIVEN Se creea un boardBuilder y varios tama�os
	 * WHEN Se le pasa un tama�o valido al m�tood Of
	 * THEN Se comprueba que el tama�o es correcto
	 */
	 @Test
	 public void testOfInUpperLimit() {
		 board.of(size15);
		 assertEquals(size15, board.getSize());
	 }
//Pruebas de robustez:
	 /**
	  * 4- Inferior al tama�o minimo
	 * GIVEN Se creea un boardBuilder y varios tama�os
	 * WHEN Se le pasa un tama�o invalido al m�tood Of
	 * THEN Se lanza la excepci�n
	 */
	 @Test
	 (expected = IllegalArgumentException.class)
	 public void testOfUnderLimit() {
		 board.of(size2);		 
	 }
	 
	 /**
	  * 5- Superior al tama�o m�ximo
	 * GIVEN Se creea un boardBuilder y varios tama�os
	 * WHEN Se le pasa un tama�o invalido al m�tood Of
	 * THEN Se lanza la excepci�n
	 */
	 @Test
	 (expected = IllegalArgumentException.class)
	 public void testOfOverLimit() {
		 board.of(size20);		 
	 }
}
