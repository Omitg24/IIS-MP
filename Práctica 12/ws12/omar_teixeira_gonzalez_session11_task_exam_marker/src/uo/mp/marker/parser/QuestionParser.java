package uo.mp.marker.parser;

import java.util.LinkedList;
import java.util.List;

import uo.mp.marker.exception.InvalidLineFormatException;
import uo.mp.marker.questions.Choice;
import uo.mp.marker.questions.Gap;
import uo.mp.marker.questions.Question;
import uo.mp.marker.questions.Value;
import uo.mp2021.log.Logger;

/**
 * Titulo: Clase QuestionParser
 * 
 * @author Omitg
 * @version 29-04-2021
 */
public class QuestionParser {	
	/**
	 * Atributo numero de linea
	 */
	private int lineNumber = 0;
	
	/**
	 * Método que devuelve una lista de questions, tras pasarle como parametro
	 * una lista de strings
	 * 
	 * @param lines, lista de String
	 * @return questions, lista de preguntas
	 */
	public List<Question> parse(List<String> lines) {
		List<Question> questions = new LinkedList<>();

		for (String line : lines) {
			lineNumber++;
			try {
				checkEmptyLine(line);
				checkParts(line);
				Question question = parseLine(line);
				questions.add(question);
			} catch (InvalidLineFormatException e) {
				Logger.log(e.getMessage());
			}
		}
		return questions;
	}
	
	/**
	 * Método que comprueba la linea
	 * 
	 * @param line, linea
	 * @return question, pregunta
	 * @throws InvalidLineFormatException, lanza excepción si no cumple la condición
	 *                                     necesaria
	 */
	private Question parseLine(String line) throws InvalidLineFormatException {		
		String[] parts = line.split("\t");
		String type = parts[0];

		switch (type)  {
		case "choice": return new Choice(lineNumber, toDouble(parts[1]), parts[2]);
		case "gap": return new Gap(lineNumber, toDouble(parts[1]), parts[2]);
		case "value": return new Value(lineNumber, toDouble(parts[1]), toDouble(parts[2]));
		}
		throw new InvalidLineFormatException(lineNumber, "; Unknown question type " + type);
	}
	
	/**
	 * Método que transforma la cadena a numero double
	 * 
	 * @param string, string a convertir
	 * @return double, string transformado a double
	 * @throws InvalidLineFormatException, lanza excepción si no cumple la condición
	 *                                     necesaria
	 */
	private double toDouble(String string) throws InvalidLineFormatException {
		try {
			return Double.parseDouble(string);
		} catch (NumberFormatException e) {
			throw new InvalidLineFormatException(lineNumber, " Formato de numero incorrecto");
		}
	}
	
	/**
	 * Método que comprueba las partes de la pregunta
	 * 
	 * @param parts, partes
	 * @param i,     numero de partes
	 * @throws InvalidLineFormatException, lanza excepción si no cumple la condición
	 *                                     necesaria
	 */
	private void checkParts(String line) throws InvalidLineFormatException {
		String parts[] = line.split("\t");
		if (parts.length == 3) return;
			throw new InvalidLineFormatException(lineNumber, "; The line does not have three fields");
	}
	
	/**
	 * Método que comprueba que una linea no esta vacia
	 * 
	 * @param line, linea a revisar
	 * @throws InvalidLineFormatException, lanza excepción si no cumple la condición
	 *                                     necesaria
	 */
	private void checkEmptyLine(String line) throws InvalidLineFormatException {
		if (line.isBlank()) {
			throw new InvalidLineFormatException(lineNumber, " Linea vacía");
		}
	}
}
