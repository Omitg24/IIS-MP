package uo.mp.publicationparser;

import static org.junit.Assert.assertEquals;

import java.util.LinkedList;
import java.util.List;

import org.junit.Before;
import org.junit.Test;

import uo.mp.newsstand.domain.Magazine;
import uo.mp.newsstand.domain.Newspaper;
import uo.mp.newsstand.service.parsers.PublicationParser;

/**
 * Titulo: Clase ParseTest
 * 
 * @author Omitg
 * @version 07-04-2021
 */
public class ParseTest {
	/**
	 * Atributo lista
	 */
	private List<String> list = new LinkedList<String>();
	/**
	 * Atributo parser
	 */
	private PublicationParser parser;
	/**
	 * Atributo revista
	 */
	private Magazine magazine1;
	/**
	 * Atributo periodico 
	 */
	private Newspaper newspaper1;
	
	/**
	 * Creación de objetos para su posterior uso
	 */
	@Before
	public void setUp() {
		parser = new PublicationParser();
		magazine1 = new Magazine("Hobby Consolas", 10, 6, 4);
		newspaper1 = new Newspaper("El País", 13, 3);
	}
	
	/**
	 * Pruebas del método parse de la clase PublicationParse:
	 * 1- Recibe lista vacía
	 * 2- Cadena para magazine y es correcta
	 * 3- Cadena para newspaper y es correcta
	 * 4- Cadenas con ambos y es correcta
	 * 5- Cadena con linea correcta y otra incorrecta
	 */
	
	/**
	 * 1- Recibe lista vacía
	 * GIVEN Se crea una lista
	 * WHEN Se pasa como parámetro al parser
	 * THEN Se lanza la excepción pero se sigue ejecutando el programa
	 */
	@Test
	public void emptyList() {
		parser.parse(list);
		assertEquals(0,list.size());
	}	

	/**
	 * 2- Cadena para magazine y es correcta
	 * GIVEN Se crea una lista y se añade una revista
	 * WHEN Se pasa como parámetro al parser
	 * THEN Se ejecuta el programa
	 */
	@Test
	public void magazineList() {
		list.add(magazine1.toString());
		parser.parse(list);
		assertEquals(1,list.size());
	}
	
	/**
	 * 3- Cadena para newspaper y es correcta
	 * GIVEN Se crea una lista y se añade un periodico
	 * WHEN Se pasa como parámetro al parser
	 * THEN Se ejecuta el programa
	 */
	@Test
	public void newspaperList() {
		list.add(newspaper1.toString());
		parser.parse(list);
		assertEquals(1,list.size());		
	}
	
	/**
	 * 4- Cadenas con ambos y es correcta
	 * GIVEN Se crea una lista y se añade un periodico y una revista
	 * WHEN Se pasa como parámetro al parser
	 * THEN Se ejecuta el programa
	 */
	@Test
	public void bothList() {
		list.add(magazine1.toString());
		list.add(newspaper1.toString());
		parser.parse(list);
		assertEquals(2,list.size());
	}
	
	/**
	 * 5- Cadena con linea correcta y otra incorrecta
	 * GIVEN Se crea una lista y se añade un periodico y una linea en blanco
	 * WHEN Se pasa como parámetro al parser
	 * THEN Se lanza la excepción pero se sigue ejecutando el programa
	 */
	@Test	
	public void wrongList() {
		list.add(magazine1.toString());		
		list.add("");
		parser.parse(list);
		assertEquals(2,list.size());
	}
}
