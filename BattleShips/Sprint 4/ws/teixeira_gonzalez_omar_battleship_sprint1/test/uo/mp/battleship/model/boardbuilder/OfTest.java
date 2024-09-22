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
	 * Atributos tamaño
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
	 * Pruebas del método Of de la clase BoardBuilder:
	 * Pruebas de funcionalidad:
	 * 1- Size entre limites
	 * 2- Size tamaño minimo 
	 * 3- Size tamaño máximo
	 * 
	 * Pruebas de robustez:
	 * 4- Inferior al tamaño minimo
	 * 5- Superior al tamaño máximo
	 */
//Pruebas de funcionalidad:
	/**
	 * 1- Size entre limites
	 * GIVEN Se creea un boardBuilder y varios tamaños
	 * WHEN Se le pasa un tamaño valido al métood Of
	 * THEN Se comprueba que el tamaño es correcto
	 */
	 @Test
	 public void testOfInLimit() {
		 board.of(size10);
		 assertEquals(size10, board.getSize());
	 }
	 
	 /**
	  * 2- Size tamaño minimo 
	 * GIVEN Se creea un boardBuilder y varios tamaños
	 * WHEN Se le pasa un tamaño valido al métood Of
	 * THEN Se comprueba que el tamaño es correcto
	 */
	 @Test
	 public void testOfInLowerLimit() {
		 board.of(size5);
		 assertEquals(size5, board.getSize());
	 }
	 
	 /**
	  * 3- Size tamaño máximo 
	 * GIVEN Se creea un boardBuilder y varios tamaños
	 * WHEN Se le pasa un tamaño valido al métood Of
	 * THEN Se comprueba que el tamaño es correcto
	 */
	 @Test
	 public void testOfInUpperLimit() {
		 board.of(size15);
		 assertEquals(size15, board.getSize());
	 }
//Pruebas de robustez:
	 /**
	  * 4- Inferior al tamaño minimo
	 * GIVEN Se creea un boardBuilder y varios tamaños
	 * WHEN Se le pasa un tamaño invalido al métood Of
	 * THEN Se lanza la excepción
	 */
	 @Test
	 (expected = IllegalArgumentException.class)
	 public void testOfUnderLimit() {
		 board.of(size2);		 
	 }
	 
	 /**
	  * 5- Superior al tamaño máximo
	 * GIVEN Se creea un boardBuilder y varios tamaños
	 * WHEN Se le pasa un tamaño invalido al métood Of
	 * THEN Se lanza la excepción
	 */
	 @Test
	 (expected = IllegalArgumentException.class)
	 public void testOfOverLimit() {
		 board.of(size20);		 
	 }
}
