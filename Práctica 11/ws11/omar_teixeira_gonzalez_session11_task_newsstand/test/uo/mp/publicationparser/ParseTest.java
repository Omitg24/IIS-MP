package uo.mp.publicationparser;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

import uo.mp.newsstand.domain.Magazine;
import uo.mp.newsstand.domain.Newspaper;
import uo.mp.newsstand.domain.Publication;
import uo.mp.newsstand.service.parsers.PublicationParser;

/**
 * Titulo: Clase ParseTest
 * 
 * @author Omitg
 * @version 07-04-2021
 */
public class ParseTest {
	/**
	 * Pruebas del método parse de la clase PublicationParse: 1- Recibe lista vacía
	 * 2- Newspaper correcto 3- Magazine correcto 4- Newspaper fallo numero de datos
	 * 5- Newspaper fallo stock 6- Newspaper fallo sales 7- Magazine fallo numero de
	 * datos 8- Magazine fallo frecuencia 9- Magazine fallo stock 10- Magazine fallo
	 * sales
	 */

	/**
	 * 1- Recibe lista vacía GIVEN Se crea una lista con o sin contenido WHEN Se
	 * crea una lista, fallida o no THEN Se ejecuta el programa
	 */
	@Test
	public void EmptyList() {
		List<String> lines = new ArrayList<>();
		List<Publication> pubs = new PublicationParser().parse(lines);
		assertTrue(pubs.isEmpty());
	}

	/**
	 * 2- Newspaper correcto GIVEN Se crea una lista con o sin contenido WHEN Se
	 * crea una lista, fallida o no THEN Se ejecuta el programa
	 */
	@Test
	public void NewspaperList() {
		List<String> lines = List.of("newspaper\tLa Nueva España\t14\t30");
		List<Publication> pubs = new PublicationParser().parse(lines);

		Newspaper parsed = (Newspaper) pubs.get(0);
		assertTrue(pubs.size() == 1);
		assertEquals("La Nueva España", parsed.getName());
		assertEquals(30, parsed.getSales());
		assertEquals(14, parsed.getStock());
	}

	/**
	 * 3- Magazine correcto GIVEN Se crea una lista con o sin contenido WHEN Se crea
	 * una lista, fallida o no THEN Se ejecuta el programa
	 */
	@Test
	public void MagazineList() {
		List<String> lines = List.of("magazine\tHola\t14\t30\t7");
		List<Publication> pubs = new PublicationParser().parse(lines);

		Magazine parsed = (Magazine) pubs.get(0);
		assertTrue(pubs.size() == 1);
		assertEquals("Hola", parsed.getName());
		assertEquals(30, parsed.getSales());
		assertEquals(14, parsed.getStock());
		assertEquals(7, parsed.getFrequency());
	}

	/**
	 * 4- Newspaper fallo numero de datos GIVEN Se crea una lista con o sin
	 * contenido WHEN Se crea una lista, fallida o no THEN Se ejecuta el programa
	 */
	@Test
	public void NewspaperWrongNFields() {
		List<String> lines = List.of("newspaper\tLa Nueva España\t14\t30\t56");
		List<Publication> pubs = new PublicationParser().parse(lines);
		assertTrue(pubs.size() == 0);
	}

	/**
	 * 5- Newspaper fallo stock GIVEN Se crea una lista con o sin contenido WHEN Se
	 * crea una lista, fallida o no THEN Se ejecuta el programa
	 */
	@Test
	public void NewspaperWrongStock() {
		List<String> lines = List.of("newspaper\tLa Nueva España\t14\t30a");
		List<Publication> pubs = new PublicationParser().parse(lines);
		assertTrue(pubs.size() == 0);
	}

	/**
	 * 6- Newspaper fallo sales GIVEN Se crea una lista con o sin contenido WHEN Se
	 * crea una lista, fallida o no THEN Se ejecuta el programa
	 */
	@Test
	public void NewspaperWrongSales() {
		List<String> lines = List.of("newspaper\tLa Nueva España\t14a\t30");
		List<Publication> pubs = new PublicationParser().parse(lines);
		assertTrue(pubs.size() == 0);
	}

	/**
	 * 7- Magazine fallo numero de datos GIVEN Se crea una lista con o sin contenido
	 * WHEN Se crea una lista, fallida o no THEN Se ejecuta el programa
	 */
	@Test
	public void MagazineWrongNFields() {
		List<String> lines = List.of("magazine\tHola\t14\t30\t7\t8");
		List<Publication> pubs = new PublicationParser().parse(lines);
		assertTrue(pubs.size() == 0);
	}

	/**
	 * 8- Magazine fallo frecuencia GIVEN Se crea una lista con o sin contenido WHEN
	 * Se crea una lista, fallida o no THEN Se ejecuta el programa
	 */
	@Test
	public void MagazineWrongFrequency() {
		List<String> lines = List.of("magazine\tHola\t14\t30\t7\t8a");
		List<Publication> pubs = new PublicationParser().parse(lines);
		assertTrue(pubs.size() == 0);
	}

	/**
	 * 9- Magazine fallo stock GIVEN Se crea una lista con o sin contenido WHEN Se
	 * crea una lista, fallida o no THEN Se ejecuta el programa
	 */
	@Test
	public void MagazineWrongStock() {
		List<String> lines = List.of("magazine\tHola\t14\t30\t7a\t8");
		List<Publication> pubs = new PublicationParser().parse(lines);
		assertTrue(pubs.size() == 0);
	}

	/**
	 * 10- Magazine fallo sales GIVEN Se crea una lista con o sin contenido WHEN Se
	 * crea una lista, fallida o no THEN Se ejecuta el programa
	 */
	@Test
	public void MagazineWrongSales() {
		List<String> lines = List.of("magazine\tHola\t14\t30a\t7\t8");
		List<Publication> pubs = new PublicationParser().parse(lines);
		assertTrue(pubs.size() == 0);
	}
}