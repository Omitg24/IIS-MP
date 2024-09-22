package uo.mp.s2.analyzer.model.wordanalyzer;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import uo.mp.s2.analyzer.model.WordAnalyzer;

/**
 * <p>
 * Título: Clase FirstMultipleCharacterTest
 * </p>
 * 
 * @author Omar Teixeira González
 * @version 12/02/2021
 */

public class FirstMultipleCharacterTest {
	
	/**
	 * Pruebas para el método firstRepeatedCharacter de la clae Word Analyzer:
	 * 1- Palabra sin caracteres repetidos -> Devuelve 0.
	 * 2- Palabra con caracteres repetidos consecutivos-> Devuelve el caracter
	 * 3- Palabra con caracteres repetidos no consecutivos -> Devuelve el caracter
	 * 4- Palabra con varios caracteres repetidos -> Devuelve el caracter
	 * 5- Palabra con caracteres repetidos consecutivos mas de 2 -> Devuelve el primer caracter que se repite
	 * 6- Palabra con caracteres repetidos al comienzo -> Devuelve el primer caracter que se repite
	 * 7- Palabra con caracteres repetidos al final -> Devuelve el primer caracter que se repite
	 * 8- Palabra con un solo caracter-> Devolver 0
	 */
	
	/**
	 * 1- Palabra sin caracteres repetidos -> Devuelve 0.
 	 * GIVEN Analizador recibe una palabra sin caracteres repetidos
	 * WHEN se llama al metodo
	 * THEN devuelve 0
	 */
	@Test
	public void testFirstMultipleCharacterNoCharactersRepeated() {
		WordAnalyzer analyzer = new WordAnalyzer("hola");
		char r=analyzer.firstMultipleCharacter();
		assertEquals(0,r);
	}
	
	/**
	 * 2- Palabra con caracteres repetidos consecutivos-> Devuelve el caracter
	 * GIVEN Analizador recibe una palabra con caracteres repetidos consecutivos
	 * WHEN se llama al metodo
	 * THEN devuelve el caracter repetido
	 */
	@Test
	public void testFirstMultipleCharacterCharactersRepeatedInARow() {
		WordAnalyzer analyzer = new WordAnalyzer("pollo");
		char r=analyzer.firstMultipleCharacter();
		assertEquals('o',r);
	}
	
	/**
	 * 3- Palabra con caracteres repetidos no consecutivos -> Devuelve el caracter
	 * GIVEN Analizador recibe una palabra con caracteres repetidos no consecutivos
	 * WHEN se llama al metodo
	 * THEN devuelve el primer caracter repetido
	 */
	@Test
	public void testFirstMultipleCharacterNotInARow() {
		WordAnalyzer analyzer = new WordAnalyzer("naranja");
		char r=analyzer.firstMultipleCharacter();
		assertEquals('n',r);
	}
	
	/**
	 * 4- Palabra con varios caracteres repetidos -> Devuelve el caracter
	 * GIVEN Analizador recibe una palabra con varios caracteres repetidos no consecutivos
	 * WHEN se llama al metodo
	 * THEN devuelve el primer caracter repetido
	 */
	@Test
	public void testFirstMultipleCharacterMoreThanOne() {
		WordAnalyzer analyzer = new WordAnalyzer("dromedario");
		char r=analyzer.firstMultipleCharacter();
		assertEquals('d',r);
	}
	
	/**
	 * 5- Palabra con caracteres repetidos consecutivos mas de 2 -> Devuelve 
	 * el primer caracter que se repite
	 * GIVEN Analizador recibe una palabra con caracteres repetidos consecutivos
	 * WHEN se llama al metodo
	 * THEN devuelve el primer caracter repetido
	 */
	@Test
	public void testFirstMultipleCharacterMoreThanOneRow() {
		WordAnalyzer analyzer = new WordAnalyzer("abbcdd");
		char r=analyzer.firstMultipleCharacter();
		assertEquals('b',r);
	}
	
	/**
	 * 6- Palabra con caracteres repetidos al comienzo -> Devuelve el primer caracter que se repite
	 * GIVEN Analizador recibe una palabra con caracteres repetidos al principio
	 * WHEN se llama al metodo
	 * THEN devuelve dicho caracter repetido
	 */
	@Test
	public void testFirstMultipleCharacterAtTheStart() {
		WordAnalyzer analyzer = new WordAnalyzer("llama");
		char r=analyzer.firstMultipleCharacter();
		assertEquals('l',r);
	}
	
	/**
	 * 7- Palabra con caracteres repetidos al final -> Devuelve el primer caracter que se repite
	 * GIVEN Analizador recibe una palabra con caracteres repetidos al final
	 * WHEN se llama al metodo
	 * THEN devuelve dicho caracter repetido
	 */
	@Test
	public void testFirstMultipleCharacterAtTheEnd() {
		WordAnalyzer analyzer = new WordAnalyzer("motocross");
		char r=analyzer.firstMultipleCharacter();
		assertEquals('o',r);
	}
	
	/**
	 * 8- Palabra con un solo caracter-> Devuelve 0
	 * GIVEN Analizador recibe un unico caracter
	 * WHEN se llama al metodo
	 * THEN devuelve 0
	 */
	@Test
	public void testFirstMultipleCharacter() {
		WordAnalyzer analyzer = new WordAnalyzer("a");
		char r=analyzer.firstMultipleCharacter();
		assertEquals(0,r);
	}
	
	
}