package uo.mp;

import java.io.FileNotFoundException;

import uo.mp.collections.List;
import uo.mp.log.Logger;
import uo.mp.transaction.TransactionProcessor;
import uo.mp.transaction.model.Transaction;

public class Main {

	private static final String TRX_FILE_NAME = "input_transactions.trx";
//	private static final String TRX_FILE_NAME = "input_transactions_with_parsing_errors.trx";
//	private static final String TRX_FILE_NAME = "input_transactions_with_repeated_abort.trx";

	public static void main(String[] args) {
		new Main().run();
	}

	private void run() {
		try {
			process();
		} catch (RuntimeException e) {
			handlleSysError(e);
		} catch (Exception e) {
			handleUserError(e);
		}
	}

	private void handleUserError(Exception e) {
		System.out.println("APPLICATION ERROR. Revise este error: " + e.getMessage());
	}

	private void handlleSysError(RuntimeException e) {
		System.out.println("PROGRAMMING ERROR. La aplicación finaliza debido a un error interno: " + e.getMessage());
		Logger.log(e.getMessage());
	}

	private void process() throws FileNotFoundException {
		TransactionProcessor tp = new TransactionProcessor();
		tp.process( TRX_FILE_NAME );
		showInvalidTransactions( tp.getInvalidTransactions() );
	}

	private void showInvalidTransactions(List<Transaction> invalidTrxs) {
		for(Transaction t: invalidTrxs ) {
			System.out.println( t );
			for(String error: t.getFaults() ) {
				System.out.println( error );
			}
		}
	}

}
