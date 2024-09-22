package uo.mp.marker.parser;

import java.util.LinkedList;
import java.util.List;

import uo.mp.marker.StudentExam;
import uo.mp.marker.exception.InvalidLineFormatException;
import uo.mp.log.Logger;

/**
 * Titulo: Clase StudentParser
 * 
 * @author Omitg
 * @version 22-04-2021
 */
public class StudentParser {
	/**
	 * Atributo numero de linea
	 */
	private int lineNumber = 0;
	
	/**
	 * M�todo que devuelve una lista de estudiantes, tras pasarle como parametro
	 * una lista de strings
	 * 
	 * @param lines, lineas
	 * @return students, estudiantes
	 */
	public List<StudentExam> parse(List<String> lines) {
		List<StudentExam> exams = new LinkedList<StudentExam>();

		for (String line : lines) {
			lineNumber++;
			try {
				StudentExam exam = parseLine(line);
				exams.add(exam);
			} catch (InvalidLineFormatException e) {
				Logger.log(e.getMessage());
			}
		}
		return exams;
	}

	private StudentExam parseLine(String line) throws InvalidLineFormatException {		
		checkEmptyLine(line);
		String[] parts = line.split("\t");
		String type = parts[0];
		StudentExam exam = new StudentExam(type);		
		checkParts(parts, 11);
		for (int i=1; i<parts.length;i++) {
			exam.addAnswer(parts[i]);
		}		 
		return exam;		
	}	
	
	/**
	 * M�todo que comprueba las partes de la pregunta
	 * 
	 * @param parts, partes
	 * @param i,     numero de partes
	 * @throws InvalidLineFormatException, lanza excepci�n si no cumple la condici�n
	 *                                     necesaria
	 */
	private void checkParts(String[] parts, int i) throws InvalidLineFormatException {
		if (parts.length != i) {
			throw new InvalidLineFormatException(lineNumber, " Numero de partes incorrecto");
		}
	}
	
	/**
	 * M�todo que comprueba que una linea no esta vacia
	 * 
	 * @param line, linea a revisar
	 * @throws InvalidLineFormatException, lanza excepci�n si no cumple la condici�n
	 *                                     necesaria
	 */
	private void checkEmptyLine(String line) throws InvalidLineFormatException {
		if (line.isBlank()) {
			throw new InvalidLineFormatException(lineNumber, " Linea vac�a");
		}
	}
}
