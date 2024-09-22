package uo.mp.transaction.validator;

import uo.mp.collections.List;
import uo.mp.collections.impl.ArrayList;
import uo.mp.sort.Collections;
import uo.mp.transaction.model.Transaction;
import uo.mp.transaction.validator.sort.sortByDate;

public class TransactionValidator {

	private List<Transaction> transactions = new ArrayList<>();
	private List<Transaction> validTransactions = new ArrayList<>();
	private List<Transaction> invalidTransactions = new ArrayList<>();
	
	public void add(List<Transaction> trxs) {
		for (Transaction trx : trxs) {
			transactions.add(trx);
		}
	}

	public void validate() {
		 for (Transaction trx : transactions) {
			 trx.validate();			 
		 }
		 for (Transaction trx : transactions) {
			 if (trx.hasFaults()) {
				 invalidTransactions.add(trx);
			 } else if (!trx.hasFaults()) {
				 validTransactions.add(trx);
			 }
		 }
	}

	public List<Transaction> getInvalidTransactions() {		
		Collections.sort(invalidTransactions, new sortByDate());
		return this.invalidTransactions;
	}

	public List<Transaction> getValidTransactions() {
		Collections.sort(validTransactions, new sortByDate());
		return this.validTransactions;
	}

}
