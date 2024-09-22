package uo.mp.transaction;

import java.io.FileNotFoundException;

import uo.mp.collections.List;
import uo.mp.transaction.model.Transaction;
import uo.mp.transaction.validator.TransactionValidator;
import uo.mp.transaction.validator.file.InvalidTransactionWriter;
import uo.mp.transaction.validator.file.TransactionLoader;
import uo.mp.transaction.validator.file.ValidTransactionWriter;

public class TransactionProcessor {

	private TransactionValidator validator;

	public void process(String trxFileName) throws FileNotFoundException {
		
		List<Transaction> trxs = new TransactionLoader( trxFileName ).load();
		
		validator = new TransactionValidator();
		validator.add( trxs );
		validator.validate();
		
		List<Transaction> validTransactions = validator.getValidTransactions();
		List<Transaction> invalidTransactions = validator.getInvalidTransactions();

		new ValidTransactionWriter( trxFileName ).save( validTransactions );
		new InvalidTransactionWriter( trxFileName ).save( invalidTransactions );
	}

	public List<Transaction> getInvalidTransactions() {
		return validator.getInvalidTransactions();
	}

}
