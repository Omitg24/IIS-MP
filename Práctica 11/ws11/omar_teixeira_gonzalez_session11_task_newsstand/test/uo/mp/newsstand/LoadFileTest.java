package uo.mp.newsstand;

import org.junit.Before;
import org.junit.Test;

import uo.mp.newsstand.service.Newsstand;
import uo.mp.newsstand.service.exception.InvalidFileNameException;
import uo.mp.log.Logger;

/**
 * Titulo: Clase LoadFileTest
 *
 * @author Omitg
 * @version 16-04-2021
 */
public class LoadFileTest {
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
	 * Pruebas del método loadFile de la clase newsStand: 1- El fichero no exise 2-
	 * El fichero existe 3- Se llaman 2 veces al mismo fichero
	 */

	/**
	 * 1- El fichero no exise GIVEN Se crea un kiosko WHEN Se busca un fichero que
	 * no existe THEN Se lanza la excepcion pero sigue el programa
	 */
	@Test
	public void fileDoesNotExist() {
		try {
			stand.loadFile("fileDoesNotExist.txt");
		} catch (InvalidFileNameException e) {
			Logger.log(e.getMessage());
		}
	}

	/**
	 * 2- El fichero existe GIVEN Se crea un kiosko WHEN Se busca un fichero que
	 * existe THEN Sigue el programa
	 */
	@Test
	public void fileDoesExist() {
		try {
			stand.loadFile("publications.txt");
		} catch (InvalidFileNameException e) {
			Logger.log(e.getMessage());
		}
	}

	/**
	 * 3- Se llaman 2 veces al mismo fichero GIVEN Se crea un kiosko WHEN Se busca
	 * un fichero que existe dos veces THEN Sigue el programa
	 */
	@Test
	public void fileDoesExistCalledTwice() {
		try {
			stand.loadFile("publications.txt");
			stand.loadFile("publications.txt");
		} catch (InvalidFileNameException e) {
			Logger.log(e.getMessage());
		}
	}
}
