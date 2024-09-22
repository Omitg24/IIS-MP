package uo.mp.newsstand;

import java.io.IOException;

import org.junit.Before;
import org.junit.Test;

import uo.mp.newsstand.service.Newsstand;
import uo.mp.newsstand.service.exception.InvalidFileNameException;
import uo.mp.log.Logger;

/**
 * Titulo: Clase ImportPublicationsFromZipFileTest
 * 
 * @author Omitg
 * @version 16-04-2021
 */
public class ImportPublicationsFromZipFileTest {
	/**
	 * Atributo stand
	 */
	private Newsstand stand;

	/**
	 * Creación de objetos para su uso posterior
	 */
	@Before
	public void setUp() {
		stand = new Newsstand();
	}

	/**
	 * Pruebas del método importPublicationsFromZipFile de la clase newsStand: 
	 * 1- El zip no exise 
	 * 2- El zip existe 
	 * 3- Se llaman 2 veces al mismo zip
	 */

	/**
	 * 1- El zip no exise 
	 * GIVEN Se crea un kiosko
	 * WHEN Se busca un zip que no existe
	 * THEN Se lanza la excepcion pero sigue el programa
	 */
	@Test
	public void fileDoesNotExist() {
		try {
			stand.importPublicationsFromZipFile("zipDoesNotExist.zip");
		} catch (InvalidFileNameException | IOException e) {
			Logger.log(e.getMessage());
		}
	}

	/**
	 * 2- El zip existe 
	 * GIVEN Se crea un kiosko 
	 * WHEN Se busca un zip que existe 
	 * THEN Sigue el programa
	 */
	@Test
	public void fileDoesExist() {
		try {
			stand.importPublicationsFromZipFile("publicationsgz.zip");
		} catch (InvalidFileNameException | IOException e) {
			Logger.log(e.getMessage());
		}

	}

	/**
	 * 3- Se llaman 2 veces al mismo zip 
	 * GIVEN Se crea un kiosko 
	 * WHEN Se busca un zip que existe dos veces 
	 * THEN Sigue el programa
	 */
	@Test
	public void fileDoesExistCalledTwice() {
		try {
			stand.importPublicationsFromZipFile("publicationsgz.zip");
			stand.importPublicationsFromZipFile("publicationsgz.zip");
		} catch (InvalidFileNameException | IOException e) {
			Logger.log(e.getMessage());
		}
	}
}