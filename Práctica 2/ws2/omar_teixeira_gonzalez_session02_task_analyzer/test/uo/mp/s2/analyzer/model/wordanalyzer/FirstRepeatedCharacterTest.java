package uo.mp.s2.analyzer.model.wordanalyzer;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import uo.mp.s2.analyzer.model.WordAnalyzer;

/**
 * <p>
 * T�tulo: Clase FirstRepeatedCharacterTest
 * </p>
 * 
 * @author Omar Teixeira Gonz�lez
 * @version 12/02/2021
 */

public class FirstRepeatedCharacterTest {

	/**
	 * Pruebas para el m�todo firstRepeatedCharacter de la clae Word Analyzer:
	 * 1- Palabra sin caracteres repetidos -> Devuelve 0.
	 * 2- Palabra con caracteres repetidos consecutivos-> Devuelve el caracter
	 * 3- Palabra con caracteres repetidos no consecutivos -> Devuelve 0
	 * 4- Palabra con varios caracteres repetidos -> Devuelve 0
	 * 5- Palabra con caracteres repetidos consecutivos mas de 2 -> Devuelve el primer caracter que se repite
	 * 6- Palabra con caracteres repetidos al comienzo -> Devuelve el primer caracter que se repite
	 * 7- Palabra con caracteres repetidos al final -> Devuelve el primer caracter que se repite
	 * 8- Palabra con un solo caracter-> Devuelve 0
	 */
	
	/**
	 * 1- Palabra sin caracteres repetidos -> Devuelve 0.
 	 * GIVEN Analizador recibe una palabra sin caracteres repetidos
	 * WHEN se llama al metodo
	 * THEN devuelve 0
	 */
	@Test
	public void testFirstRepeatedCharacterNoRepeated() {
		WordAnalyzer analyzer = new WordAnalyzer("hola");
		char r=analyzer.firstRepeatedCharacter();
		assertEquals(0,r);
	}
	
	/**
	 * 2- Palabra con caracteres repetidos consecutivos-> Devuelve el caracter
	 * GIVEN Analizador recibe una palabra con caracteres repetidos consecutivos
	 * WHEN se llama al metodo
	 * THEN devuelve el caracter repetido
	 */
	@Test
	public void testFirstRepeatedCharacterRepeatedInARow() {
		WordAnalyzer analyzer = new WordAnalyzer("pollo");
		char r=analyzer.firstRepeatedCharacter();
		assertEquals('l',r);
	}
	
	/**
	 * 3- Palabra con caracteres repetidos no consecutivos -> Devuelve 0
	 * GIVEN Analizador recibe una palabra con caracteres repetidos no consecutivos
	 * WHEN se llama al metodo
	 * THEN devuelve 0
	 */
	@Test
	public void testFirstRepeatedCharacterNotInARow() {
		WordAnalyzer analyzer = new WordAnalyzer("naranja");
		char r=analyzer.firstRepeatedCharacter();
		assertEquals(0,r);
	}
	
	/**
	 * 4- Palabra con varios caracteres repetidos -> Devuelve 0
	 * GIVEN Analizador recibe una palabra con varios caracteres repetidos no consecutivos
	 * WHEN se llama al metodo
	 * THEN devuelve 0
	 */
	@Test
	public void testFirstRepeatedCharacterMoreThanOne() {
		WordAnalyzer analyzer = new WordAnalyzer("dromedario");
		char r=analyzer.firstRepeatedCharacter();
		assertEquals(0,r);
	}
	
	/**
	 * 5- Palabra con caracteres repetidos consecutivos mas de 2 -> Devuelve el primer caracter que se repite
	 * GIVEN Analizador recibe una palabra con caracteres repetidos consecutivos
	 * WHEN se llama al metodo
	 * THEN devuelve dicho caracter repetido
	 */
	@Test
	public void testFirstRepeatedCharacterMoreThanOneRow() {
		WordAnalyzer analyzer = new WordAnalyzer("abbcdd");
		char r=analyzer.firstRepeatedCharacter();
		assertEquals('b',r);
	}
	
	/**
	 * 6- Palabra con caracteres repetidos al comienzo -> Devuelve el primer caracter que se repite
	 * GIVEN Analizador recibe una palabra con caracteres repetidos al principio
	 * WHEN se llama al metodo
	 * THEN devuelve dicho caracter repetido
	 */
	@Test
	public void testFirstRepeatedCharacterAtTheStart() {
		WordAnalyzer analyzer = new WordAnalyzer("llama");
		char r=analyzer.firstRepeatedCharacter();
		assertEquals('l',r);
	}
	
	/**
	 * 7- Palabra con caracteres repetidos al final -> Devuelve el primer caracter que se repite
	 * GIVEN Analizador recibe una palabra con caracteres repetidos al final
	 * WHEN se llama al metodo
	 * THEN devuelve dicho caracter repetido
	 */
	@Test
	public void testFirstRepeatedCharacterAtTheEnd() {
		WordAnalyzer analyzer = new WordAnalyzer("motocross");
		char r=analyzer.firstRepeatedCharacter();
		assertEquals('s',r);
	}
	/**
	 * 8- Palabra con un solo caracter-> Devuelve 0
	 * GIVEN Analizador recibe un unico caracter
	 * WHEN se llama al metodo
	 * THEN devuelve 0
	 */
	 @Test
	 public void testFirstRepeatedCharacterOne() {
		 WordAnalyzer analyzer = new WordAnalyzer("a");
		 char r =analyzer.firstRepeatedCharacter();
		 assertEquals(0,r);
	}

}
