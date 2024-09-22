package uo.mp.transaction.validator.file;


import uo.mp.collections.List;
import uo.mp.file.TxtFileUtil;
import uo.mp.transaction.model.Transaction;
import uo.mp.transaction.validator.serialize.TransactionSerializer;


public class InvalidTransactionWriter {

	private String fileName;

	public InvalidTransactionWriter(String fileName) {
		this.fileName = fileName;
	}

	public void save(List<Transaction> invalidTrx) {
		List<String> lines = new TransactionSerializer().serialize( invalidTrx );
		new TxtFileUtil().saveToFile( fileName + ".invalid.trx", lines );
	}

}
