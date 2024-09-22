package uo.mp.question;

import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;

import uo.mp.marker.questions.Choice;
import uo.mp.marker.questions.Gap;
import uo.mp.marker.questions.Value;

/**
 * Titulo: Clase GetMarkForAnswerTest
 * 
 * @author Omitg
 * @version 29-04-2021
 */
public class GetMarkForAnswerTest {
	/**
	 * Atributo choice
	 */
	private Choice choice;
	/**
	 * Atributo gap
	 */
	private Gap gap;
	/**
	 * Atributo value
	 */
	private Value value;
	
	/**
	 * Creación de objetos para su posterior uso
	 */
	@Before
	public void setUp() {
		choice =  new Choice(1, 2, "c");
		gap = new Gap(2, 3, "Thread");
		value = new Value(3, 5, 28.99);
	}
	
	/**
	 * Pruebas del método getMarkForAnswer de la clase Question:
	 * 1- Choice valida
	 * 2- Choice invalida
	 * 3- Gap valida
	 * 4- Gap invalida
	 * 5- Value valida
	 * 6- Value invalida 
	 */
	
	/**
	 * 1- Choice valida
	 * GIVEN Se crea una pregunta
	 * WHEN Se llama al método getMarkForAnswer
	 * THEN Se comprueba que devuelve lo esperado
	 */
	@Test
	public void validChoice() {
		assertEquals(2,choice.getMarkForAnswer("c"), 0.1);
	}
	
	/**
	 * 2- Choice invalida
	 * GIVEN Se crea una pregunta
	 * WHEN Se llama al método getMarkForAnswer
	 * THEN Se comprueba que devuelve lo esperado
	 */
	@Test
	public void invalidChoice() {
		assertEquals(-0.4,choice.getMarkForAnswer("a"), 0.1);
	}
	
	/**
	 * 3- Gap valida
	 * GIVEN Se crea una pregunta
	 * WHEN Se llama al método getMarkForAnswer
	 * THEN Se comprueba que devuelve lo esperado
	 */
	@Test
	public void validGap() {
		assertEquals(3,gap.getMarkForAnswer("Thread"), 0.1);
	}
	
	/**
	 * 4- Gap invalida
	 * GIVEN Se crea una pregunta
	 * WHEN Se llama al método getMarkForAnswer
	 * THEN Se comprueba que devuelve lo esperado
	 */
	@Test
	public void invalidGap() {
		assertEquals(0,gap.getMarkForAnswer("Join"), 0.1);
	}
	
	/**
	 * 5- Value valida
	 * GIVEN Se crea una pregunta
	 * WHEN Se llama al método getMarkForAnswer
	 * THEN Se comprueba que devuelve lo esperado
	 */
	@Test
	public void validValue() {
		assertEquals(5,value.getMarkForAnswer("28.99"), 0.1);
	}
	
	/**
	 * 6- Value invalida
	 * GIVEN Se crea una pregunta
	 * WHEN Se llama al método getMarkForAnswer
	 * THEN Se comprueba que devuelve lo esperado
	 */
	@Test
	public void invalidValue() {
		assertEquals(0,value.getMarkForAnswer("69.99"), 0.1);
	}
}
