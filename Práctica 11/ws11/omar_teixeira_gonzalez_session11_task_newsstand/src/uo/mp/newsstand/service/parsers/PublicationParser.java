package uo.mp.newsstand.service.parsers;

import java.util.LinkedList;
import java.util.List;

import uo.mp.newsstand.domain.Magazine;
import uo.mp.newsstand.domain.Newspaper;
import uo.mp.newsstand.domain.Publication;
import uo.mp.log.Logger;

/**
 * Titulo: Clase PublicationParser
 * 
 * @author Omitg
 * @version 07-04-2021
 */
public class PublicationParser {
	/**
	 * Atributo numero de linea
	 */
	private int lineNumber = 0;

	/**
	 * M�todo que devuelve una lista de publicaciones, tras pasarle como parametro
	 * una lista de strings
	 * 
	 * @param lines, lista de String
	 * @return publications, lista de publicaciones
	 */
	public List<Publication> parse(List<String> lines) {
		List<Publication> publications = new LinkedList<Publication>();

		for (String line : lines) {
			lineNumber++;
			try {
				Publication publication = parseLine(line);
				publications.add(publication);
			} catch (InvalidLineFormatException e) {
				Logger.log(e.getMessage());
			}
		}
		return publications;
	}

	/**
	 * M�todo que comprueba la linea
	 * 
	 * @param line, linea
	 * @return publicaci�n
	 * @throws InvalidLineFormatException, lanza excepci�n si no cumple la condici�n
	 *                                     necesaria
	 */
	private Publication parseLine(String line) throws InvalidLineFormatException {
		checkEmptyLine(line);
		String[] parts = line.split("\t");
		String type = parts[0];

		if (type.equals("newspaper")) {
			return parseNewsPaper(parts);
		} else if (type.equals("magazine")) {
			return parseMagazine(parts);
		} else {
			throw new InvalidLineFormatException(lineNumber, " Tipo incorrecto");
		}
	}

	/**
	 * M�todo que comprueba la revista
	 * 
	 * @param parts, partes de la revista
	 * @return magazine, revista
	 * @throws InvalidLineFormatException, lanza excepci�n si no cumple la condici�n
	 *                                     necesaria
	 */
	private Publication parseMagazine(String[] parts) throws InvalidLineFormatException {
		checkParts(parts, 5);
		String name = parts[1];
		int stock = toInteger(parts[2]);
		int sales = toInteger(parts[3]);
		int frequence = toInteger(parts[4]);

		return new Magazine(name, stock, sales, frequence);
	}

	/**
	 * M�todo que comprueba las partes de la revista o del periodico
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
	 * M�todo que comprueba el periodico
	 * 
	 * @param parts, partes del periodico
	 * @return newspaper, periodico
	 * @throws InvalidLineFormatException, lanza excepci�n si no cumple la condici�n
	 *                                     necesaria
	 */
	private Publication parseNewsPaper(String[] parts) throws InvalidLineFormatException {
		checkParts(parts, 4);
		String name = parts[1];
		int stock = toInteger(parts[2]);
		int sales = toInteger(parts[3]);

		return new Newspaper(name, stock, sales);
	}

	/**
	 * M�todo que transforma la cadena a numero integer
	 * 
	 * @param string, string a convertir
	 * @return int, string transformado a integer
	 * @throws InvalidLineFormatException, lanza excepci�n si no cumple la condici�n
	 *                                     necesaria
	 */
	private int toInteger(String string) throws InvalidLineFormatException {
		try {
			return Integer.parseInt(string);
		} catch (NumberFormatException e) {
			throw new InvalidLineFormatException(lineNumber, " Formato de numero incorrecto");
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
