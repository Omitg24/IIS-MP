package uo.mp.exammarker;

import java.io.IOException;
import org.junit.Before;
import org.junit.Test;

import uo.mp.marker.ExamMarker;
import uo.mp.log.Logger;

/**
 * Titulo: Clase LoadStudentExamsTest
 * 
 * @author Omitg
 * @version 22-04-2021
 */
public class LoadStudentExamsTest {
	/**
	 * Atributo stand
	 */
	private ExamMarker marker;
	
	/**
	 * Creación de objetos para su uso posterior
	 */
	@Before
	public void setUp() {
		marker = new ExamMarker();
	}

	/**
	 * Pruebas del método loadStudentExams de la clase ExamMarker: 
	 * 1- El fichero no exise 
	 * 2- El fichero existe 
	 * 3- Se llaman 2 veces al mismo fichero
	 */

	/**
	 * 1- El fichero no exise 
	 * GIVEN Se crea un hacedor 
	 * WHEN Se busca un fichero que no existe 
	 * THEN Se lanza la excepcion pero sigue el programa
	 */
	@Test
	public void fileDoesNotExist() {
		try {
			marker.loadStudentExams("fileDoesNotExist.txt");
		} catch (IOException e) {
			Logger.log(e.getMessage());
		}
	}

	/**
	 * 2- El fichero existe
	 * GIVEN Se crea un hacedor 
	 * WHEN Se busca un fichero que existe 
	 * THEN Sigue el programa
	 */
	@Test
	public void fileDoesExist() {
		try {
			marker.loadStudentExams("exams.txt.gz");
		} catch (IOException e) {
			Logger.log(e.getMessage());
		}
	}

	/**
	 * 3- Se llaman 2 veces al mismo fichero 
	 * GIVEN Se crea un hacedor 
	 * WHEN Se busca un fichero que existe dos veces 
	 * THEN Sigue el programa
	 */
	@Test
	public void fileDoesExistCalledTwice() {		
		try {
			marker.loadStudentExams("exams.txt.gz");
			marker.loadStudentExams("exams.txt.gz");
		} catch (IOException e) {
			Logger.log(e.getMessage());
		}
	}
}