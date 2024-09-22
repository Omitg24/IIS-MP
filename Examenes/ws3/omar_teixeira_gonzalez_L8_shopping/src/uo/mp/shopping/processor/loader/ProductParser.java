package uo.mp.shopping.processor.loader;


import uo.mp.checks.ArgumentChecks;
import uo.mp.collections.List;
import uo.mp.collections.impl.ArrayList;
import uo.mp.exceptions.InvalidLineFormatException;
import uo.mp.log.Logger;
import uo.mp.shopping.model.CleaningProduct;
import uo.mp.shopping.model.FoodProduct;
import uo.mp.shopping.model.Product;

public class ProductParser {
	
	private int lineNumber=0;
	
	public List<Product> parse(List<String> lines){
		ArgumentChecks.isNotNull(lines);
		List<Product> transactions = new ArrayList<>();
		for (String line : lines) {
			lineNumber++;
			try {
				transactions.add(parseLine(line));
				
			} catch (InvalidLineFormatException e) {
					Logger.log("PARSING ERROR en linea " + lineNumber + ": " 
			+ e.getMessage());
			}			
		}
		return transactions;
	}

	private Product parseLine(String line) throws InvalidLineFormatException {
		checkIsEmpty(line);
		String[] parts = line.split(":");
		String type = parts[0];
		if (type.equals("Food")) {
			return parseFoodProduct(parts);
		} else if (type.equals("Cleaning")) {
			return parseCleaningProduct(parts);			
		} else {
			throw new InvalidLineFormatException(lineNumber, " TIPO DESCONOCIDO");
		}
	}

	private Product parseFoodProduct(String[] parts) throws InvalidLineFormatException {
		checkParts(parts, 5);
		String code = parts[1];
		codeTest(code, "F");
		String description = parts[2];		
		double basePrice= toDouble(parts[3]);
		double weight = toDouble(parts[4]);		
		return new FoodProduct(code, description, basePrice, weight);
	}	
	
	private Product parseCleaningProduct(String[] parts) throws InvalidLineFormatException {
		checkParts(parts, 5);
		String code = parts[1];
		codeTest(code, "C");
		String description = parts[2];		
		double basePrice= toDouble(parts[3]);
		int pieces = toInteger(parts[4]);	
		return new CleaningProduct(code, description, basePrice, pieces);
	}
		
	private void codeTest(String code, String string) throws InvalidLineFormatException {
		String[] codeArray = code.split("");
		if (!codeArray[0].contentEquals(string)) {
			throw new InvalidLineFormatException(lineNumber, " CÓDIGO INVALIDO C/F");
		}
		if (codeArray.length!=3) {
			throw new InvalidLineFormatException(lineNumber, " CÓDIGO INVALIDO. LONGITUD");
		}
	}

	private void checkIsEmpty(String line) throws InvalidLineFormatException {		
		if (line.isBlank()) {
			throw new InvalidLineFormatException(lineNumber, " LINEA VACÍA");
		}
	}
	
	private double toDouble(String string) throws InvalidLineFormatException {
		try {
			return Double.parseDouble(string);
		} catch (NumberFormatException e) {
			throw new InvalidLineFormatException(lineNumber, " FORMATO DE NUMERO INCORRECTO (DOUBLE)");
		}
		
	}
	
	private int toInteger(String string) throws InvalidLineFormatException {
		try {
			return Integer.parseInt(string);
		} catch (NumberFormatException e) {
			throw new InvalidLineFormatException(lineNumber, " FORMATO DE NUMERO INCORRECTO (INT)");
		}
		
	}
	
	private void checkParts(String[] parts, int i) throws InvalidLineFormatException {
		if (parts.length != i) {
			throw new InvalidLineFormatException(lineNumber, " NUMERO DE CAMPOS INCORRECTO");
		}
	}
	
}
