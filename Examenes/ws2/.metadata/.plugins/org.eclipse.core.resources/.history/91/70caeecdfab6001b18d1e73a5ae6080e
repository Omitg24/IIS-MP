package uo.mp.transaction.validator.parser;

import uo.mp.checks.ArgumentChecks;
import uo.mp.collections.List;
import uo.mp.collections.impl.ArrayList;
import uo.mp.exceptions.InvalidLineFormatException;
import uo.mp.log.Logger;
import uo.mp.transaction.model.ClientType;
import uo.mp.transaction.model.CreditCardTransaction;
import uo.mp.transaction.model.CurrentAccountTransaction;
import uo.mp.transaction.model.Transaction;

public class TransactionParser {
	private int lineNumber = 0;
	
	public List<Transaction> parse(List<String> lines) {
		ArgumentChecks.isNotNull(lines);
		List<Transaction> transactions = new ArrayList<>();
		for (String line : lines) {
			lineNumber++;
			try {
				transactions.add(parseLine(line));
				
			} catch (InvalidLineFormatException e) {
					Logger.log("PARSING ERROR en linea " + lineNumber + "; " 
			+ e.getMessage());
			}			
		}
		return transactions;
	}

	private Transaction parseLine(String line) throws InvalidLineFormatException {
		checkIsEmpty(line);
		String[] parts = line.split(";");
		String type = parts[0];
		if (type.equals("cc")) {
			return parseCreditCard(parts);
		} else if (type.equals("acc")) {
			return parseCurrentAccount(parts);			
		} else {
			throw new InvalidLineFormatException(lineNumber, "PALABRA CLAVE NO VÁLIDA");
		}
	}

	private Transaction parseCurrentAccount(String[] parts) throws InvalidLineFormatException {
		checkParts(parts, 6);
		String date = parts[1];
		String number = parts[2];
		ClientType type = clientToString(parts[3]);
		double amount = toDouble(parts[4]);
		String description = parts[5];
		return new CurrentAccountTransaction(date, number, type, amount, description);
	}	

	private ClientType clientToString(String string) {
		if (string.equals("N")) {
			return ClientType.N;
		} else if (string.equals("P")) {
			return ClientType.P;
		}
		return null;
	}

	private Transaction parseCreditCard(String[] parts) throws InvalidLineFormatException {
		checkParts(parts, 7);
		String date = parts[1];
		String number = parts[2];
		String finalDate = parts[3];
		double maxAmount = toDouble(parts[4]);
		double amount = toDouble(parts[5]);
		String description = parts[6];
		return new CreditCardTransaction(date, number, finalDate, maxAmount, 
				amount, description);
	}

	private void checkIsEmpty(String line) throws InvalidLineFormatException {		
		if (line.isBlank()) {
			throw new InvalidLineFormatException(lineNumber, " Linea vacía");
		}
	}
	
	private double toDouble(String string) throws InvalidLineFormatException {
		try {
			return Double.parseDouble(string);
		} catch (NumberFormatException e) {
			throw new InvalidLineFormatException(lineNumber, " Formato de número incorrecto");
		}
		
	}
	
	private void checkParts(String[] parts, int i) throws InvalidLineFormatException {
		if (parts.length != i) {
			throw new InvalidLineFormatException(lineNumber, " Numero de partes incorrecto");
		}
	}

}
