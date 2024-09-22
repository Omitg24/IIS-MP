package uo.mp.s2.analyzer.model.wordanalyzer;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import uo.mp.s2.analyzer.model.WordAnalyzer;

/**
 * <p>
 * T�tulo: Clase WordAnalyzerTest
 * </p>
 * 
 * @author Omar Teixeira Gonz�lez
 * @version 12/02/2021
 */

public class WordAnalyzerTest {
	
	/**
	 * Pruebas del constructor WordAnalyzer de la clase WordAnalyzer:
	 * Negativas (pruebas de robustez):
	 * 1- Null en lugar de palabra
	 * 2- Palabra vacia
	 * 
	 * Positivas:
	 * 3- Palabra cualquiera
	 * 4- Palabra de un solo caracter 
	 */
	
//Negativas (pruebas de robustez):
	
	/**
	 * 1- Null en lugar de palabra
	 * GIVEN Se crea un analizador con null como parametro
	 * WHEN 
	 * THEN lanzar IllegalArgumentException 
	 */
	@Test
	(expected=IllegalArgumentException.class)
	public void testNullArgument()  {
		new WordAnalyzer(null);
	}
	
	/**
	 * 2- Palabra vacia
	 * GIVEN Se crea un analizador con la palabra vac�a como parametro
	 * WHEN 
	 * THEN lanzar IllegalArgumentException 
	 */
	@Test
	(expected=IllegalArgumentException.class)
	public void testEmptyArgument()  {
		new WordAnalyzer("");
	}
	
//Positivas:
	
	/**
	 * 3- Palabra cualquiera
	 * GIVEN Se crea un analizador con una palabra cualquiera
	 * WHEN Se llama al m�todo getWord
	 * THEN Se comprueba que la palabra y lo obtenido de getWord es igual 
	 */
	@Test
	public void testRandomWord() {
		WordAnalyzer word = new WordAnalyzer("pollo");
		assertEquals("pollo", word.getWord());
	}
	
	/**
	 * 4- Palabra de un solo caracter
	 * GIVEN Se crea un analizador con una palabra con caracter
	 * WHEN Se llama al m�todo getWord
	 * THEN Se comprueba que la palabra y lo obtenido de getWord es igual 
	 */
	@Test
	public void testOneCharacter() {
		WordAnalyzer word = new WordAnalyzer("a");
		assertEquals("a", word.getWord());
	}
}
