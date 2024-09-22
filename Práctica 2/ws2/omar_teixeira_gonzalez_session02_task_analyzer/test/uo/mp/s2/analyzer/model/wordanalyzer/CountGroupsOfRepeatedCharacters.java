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

public class CountGroupsOfRepeatedCharacters {
	
	/**
	 * Pruebas para el m�todo firstRepeatedCharacter de la clae Word Analyzer:
	 * 1- Palabra sin caracteres repetidos -> Devuelve 0.
	 * 2- Palabra con 1 grupo de caracteres repetidos consecutivos-> Devuelve 1
	 * 3- Palabra con caracteres repetidos no consecutivos -> Devuelve 0
	 * 4- Palabra con varios caracteres repetidos pero no son grupos consecutivos -> Devuelve 0
	 * 5- Palabra con grupos de caracteres repetidos consecutivos mas de 2 -> Devuelve el numero de grupos
	 * 		Ejemplo: "mississippi!!!" devuelve 4.
	 * 6- Palabra con caracteres repetidos al comienzo -> Devuelve 1
	 * 7- Palabra con caracteres repetidos al final -> Devuelve 1
	 * 8- Palabra con un solo caracter-> Devuelve 0
	 */
	
	/**
	 * 1- Palabra sin caracteres repetidos -> Devuelve 0.
	 * GIVEN Analizador recibe una palabra sin caracteres repetidos
	 * WHEN se llama al metodo
	 * THEN devuelve 0
	 */
	@Test
	public void testCountGroupsOfRepeatedCharactersNoCharactersRepeated() {
		WordAnalyzer analyzer = new WordAnalyzer("hola");
		int r=analyzer.countGroupsOfRepeatedCharacters();
		assertEquals(0,r);
	}
	
	/**
	 * 2- Palabra con 1 grupo de caracteres repetidos consecutivos-> Devuelve 1
	 * GIVEN Analizador recibe una palabra con un grupo de caracteres repetidos
	 * WHEN se llama al metodo
	 * THEN devuelve 1
	 */
	@Test
	public void testCountGroupsOfRepeatedCharactersOneGroup() {
		WordAnalyzer analyzer = new WordAnalyzer("pollo");
		int r=analyzer.countGroupsOfRepeatedCharacters();
		assertEquals(1,r);
	}
		
	/**
	 * 3- Palabra con caracteres repetidos no consecutivos -> Devuelve 0
	 * GIVEN Analizador recibe una palabra sin grupos de caracteres repetidos
	 * WHEN se llama al metodo
	 * THEN devuelve 0
	 */
	@Test
	public void testCountGroupsOfRepeatedCharactersNoGroups() {
		WordAnalyzer analyzer = new WordAnalyzer("agua");
		int r=analyzer.countGroupsOfRepeatedCharacters();
		assertEquals(0,r);
	}
	
	/**
	 * 4- Palabra con varios caracteres repetidos pero no son grupos consecutivos -> Devuelve 0
	 * GIVEN Analizador recibe una palabra con caracteres repetidos pero no en grupos
	 * WHEN se llama al metodo
	 * THEN devuelve 0
	 */
	@Test
	public void testCountGroupsOfRepeatedCharactersRepeatedNotInGroups() {
		WordAnalyzer analyzer = new WordAnalyzer("naranja");
		int r=analyzer.countGroupsOfRepeatedCharacters();
		assertEquals(0,r);
	}
	
	/**
	 * 5- Palabra con grupos de caracteres repetidos consecutivos mas de 2 -> Devuelve el numero de grupos
	 * 		Ejemplo: "mississippi!!!" devuelve 4.
	 * GIVEN Analizador recibe una palabra con varios de grupos de caracteres
	 * WHEN se llama al metodo
	 * THEN devuelve el numero de grupos
	 */
	@Test
	public void testCountGroupsOfRepeatedCharactersMultipleGroups() {
		WordAnalyzer analyzer = new WordAnalyzer("mississippi!!!");
		int r=analyzer.countGroupsOfRepeatedCharacters();
		assertEquals(4,r);
	}
	
	/**
	 * 6- Palabra con caracteres repetidos al comienzo -> Devuelve 1
	 * GIVEN Analizador recibe una palabra con un grupo de caracteres al comienzo
	 * WHEN se llama al metodo
	 * THEN devuelve 1
	 */
	@Test
	public void testCountGroupsOfRepeatedCharactersAtTheStart() {
		WordAnalyzer analyzer = new WordAnalyzer("llaga");
		int r=analyzer.countGroupsOfRepeatedCharacters();
		assertEquals(1,r);
	}
	
	/**
	 * 7- Palabra con caracteres repetidos al final -> Devuelve 1
	 * GIVEN Analizador recibe una palabra con un grupo de caracteres al final
	 * WHEN se llama al metodo
	 * THEN devuelve 1
	 */
	@Test
	public void testCountGroupsOfRepeatedCharactersAtTheEnd() {
		WordAnalyzer analyzer = new WordAnalyzer("motocross");
		int r=analyzer.countGroupsOfRepeatedCharacters();
		assertEquals(1,r);
	}
	
	/**
	 * 8- Palabra con un solo caracter-> Devuelve 0
	 * GIVEN Analizador recibe un unico caracter
	 * WHEN se llama al metodo
	 * THEN devuelve 0
	 */
	@Test
	public void testCountGroupsOfRepeatedCharactersOneCharacter() {
		WordAnalyzer analyzer = new WordAnalyzer("a");
		int r=analyzer.countGroupsOfRepeatedCharacters();
		assertEquals(0,r);
	}
}
