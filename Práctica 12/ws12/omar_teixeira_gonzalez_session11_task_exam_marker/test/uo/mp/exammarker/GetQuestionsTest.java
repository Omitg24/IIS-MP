package uo.mp.exammarker;

import static org.junit.Assert.assertTrue;

import java.io.FileNotFoundException;

import org.junit.Before;
import org.junit.Test;

import uo.mp.marker.ExamMarker;
import uo.mp2021.log.Logger;

/**
 * Titulo: Clase GetQuestionsTest
 * 
 * @author Omitg
 * @version 29-04-2021
 */
public class GetQuestionsTest {
	/**
	 * Atributo marker 
	 */
	private ExamMarker marker;	
	
	/**
	 * Creación de objetos para su posterior uso
	 */
	@Before
	public void setUp() {
		marker = new ExamMarker();			
	}	
	
	/**
	 * Pruebas del método getQuestions de la clase ExamMarker:
	 * 1- Vacio
	 * 2- Lista normal
	 */
	
	/**
	 * 1- Vacio
	 * GIVEN Hacedor de examenes
	 * WHEN getQuestions con lista vacia
	 * THEN Se comprueba
	 */
	@Test
	public void emptyList() {
		assertTrue(marker.getQuestions().isEmpty());
	}
	
	/**
	 * 2- Lista normal
	 * GIVEN Hacedor de examenes
	 * WHEN getQuestions con lista no vacía
	 * THEN Se comprueba
	 */
	@Test
	public void normalList() {		
		try {
			marker.loadQuestions("questions.txt");
			assertTrue(!marker.getQuestions().isEmpty());			
		} catch (FileNotFoundException e) {
			Logger.log(e.getMessage());
		}				
	}
}
