package uo.mp.marker.parser;

import java.util.LinkedList;
import java.util.List;

import uo.mp.marker.exception.InvalidLineFormatException;
import uo.mp.marker.questions.Choice;
import uo.mp.marker.questions.Question;
import uo.mp.marker.questions.Value;
import uo.mp.log.Logger;

/**
 * Titulo: Clase QuestionParser
 * 
 * @author Omitg
 * @version 22-04-2021
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
		List<Question> questions = new LinkedList<Question>();

		for (String line : lines) {
			lineNumber++;
			try {
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
		checkEmptyLine(line);
		String[] parts = line.split("\t");
		String type = parts[0];

		if (type.equals("choice")) {
			return parseChoice(parts);
		} else if (type.equals("gap")) {
			return parseGap(parts);
		} else if (type.equals("value")) {
			return parseValue(parts);
		} else {
			throw new InvalidLineFormatException(lineNumber, " Tipo incorrecto");
		}
	}	
	
	/**
	 * Método que comprueba la revista
	 * 
	 * @param parts, partes de la pregunta
	 * @return Value, valor
	 * @throws InvalidLineFormatException, lanza excepción si no cumple la condición
	 *                                     necesaria
	 */
	private Question parseValue(String[] parts) throws InvalidLineFormatException {
		checkParts(parts, 3);
		double weight = toDouble(parts[1]);
		double value = toDouble(parts[2]);

		return new Value(lineNumber, weight, value);
	}
	
	/**
	 * Método que comprueba la revista
	 * 
	 * @param parts, partes de la pregunta
	 * @return Gap, hueco
	 * @throws InvalidLineFormatException, lanza excepción si no cumple la condición
	 *                                     necesaria
	 */
	private Question parseGap(String[] parts) throws InvalidLineFormatException {
		checkParts(parts, 3);
		double weight = toDouble(parts[1]);
		String word = parts[2];

		return new Choice(lineNumber, weight, word);
	}

	/**
	 * Método que comprueba la revista
	 * 
	 * @param parts, partes de la pregunta
	 * @return Choice, eleccion
	 * @throws InvalidLineFormatException, lanza excepción si no cumple la condición
	 *                                     necesaria
	 */
	private Question parseChoice(String[] parts) throws InvalidLineFormatException {
		checkParts(parts, 3);
		double weight = toDouble(parts[1]);
		String option = parts[2];

		return new Choice(lineNumber, weight, option);
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
			return Double.valueOf(string);
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
	private void checkParts(String[] parts, int i) throws InvalidLineFormatException {
		if (parts.length != i) {
			throw new InvalidLineFormatException(lineNumber, " Numero de partes incorrecto");
		}
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
