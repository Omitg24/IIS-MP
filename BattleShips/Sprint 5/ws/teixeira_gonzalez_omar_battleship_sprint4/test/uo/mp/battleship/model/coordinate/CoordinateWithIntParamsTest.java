/**
 * 
 */
package uo.mp.battleship.model.coordinate;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import uo.mp.battleship.board.Coordinate;

/**
 * Titulo: Clase CoordinateWithIntParamsTest
 *  
 * @author Omitg
 * @version 16-04-2021
 */
public class CoordinateWithIntParamsTest {
	
	/**
	 * Pruebas del constructor con parámetros (int) de la clase Coordinate:
	 * Positivas (Pruebas de funcionalidad):
	 * 1- Parámetros respetan los limites -> Se crea el objeto 
	 * 2- Parámetros respetan los limites (Ej.2) -> Se crea el objeto
	 * 
	 * Negativas (Pruebas de robustez):
	 * 3- X no respeta el límite -> Lanza la excepción
	 * 4- Y no respeta el límite -> Lanza la excepción
	 * 5- Ambos no respetan los límites -> Lanza la excepción
	 */
	
//Positivas:
	/**
	 * 1- Parámetros respetan los limites -> Se crea el objeto
	 * GIVEN
	 * WHEN Se crea un coordinate con dos coordenadas
	 * THEN Se comprueba que las coordenadas tienen ese valor
	 */
	@Test
	public void testCoordinateWithIntParamsBothOk1() {
		Coordinate coordinate = new Coordinate (2,3);
		assertEquals(2,coordinate.getCol());
		assertEquals(3,coordinate.getRow());		
	}
	
	/**
	 * 2- Parámetros respetan los limites (Ej.2) -> Se crea el objeto
	 * GIVEN
	 * WHEN Se crea un coordinate con dos coordenadas
	 * THEN Se comprueba que las coordenadas tienen ese valor
	 */
	@Test
	public void testCoordinateWithIntParamsBothOk2() {
		Coordinate coordinate = new Coordinate (6,4);
		assertEquals(6,coordinate.getCol());
		assertEquals(4,coordinate.getRow());		
	}
	
//Negativas:
	/**
	 * 3- X no respeta el límite -> Lanza la excepción
	 * GIVEN
	 * WHEN Se crea un coordinate con dos coordenadas, la X no valida
	 * THEN Se lanza la excepción
	 */
	@Test
	(expected=IllegalArgumentException.class)
	public void testCoordinateWithIntParamsXNotOk() {
		new Coordinate (-3,4);
	}
	
	/**
	 * 4- Y no respeta el límite -> Lanza la excepción
	 * GIVEN
	 * WHEN Se crea un coordinate con dos coordenadas, la Y no valida
	 * THEN Se lanza la excepción
	 */
	@Test
	(expected=IllegalArgumentException.class)
	public void testCoordinateWithIntParamsYNotOk() {
		new Coordinate (2,-8);
	}
	
	/**
	 * 5- Ambos no respetan los límites -> Lanza la excepción
	 * GIVEN
	 * WHEN Se crea un coordinate con dos coordenadas, ambas no validas
	 * THEN Se lanza la excepción
	 */
	@Test
	(expected=IllegalArgumentException.class)
	public void testCoordinateWithIntParamsBothNotOk() {
		new Coordinate (-3,-8);
	}
}
