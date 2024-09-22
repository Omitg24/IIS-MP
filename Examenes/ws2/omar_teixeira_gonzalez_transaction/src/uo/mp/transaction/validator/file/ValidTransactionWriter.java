package uo.mp.transaction.validator.file;

import uo.mp.collections.List;
import uo.mp.file.ZipFileUtil;
import uo.mp.transaction.model.Transaction;
import uo.mp.transaction.validator.serialize.TransactionSerializer;

public class ValidTransactionWriter {

	private String fileName;

	public ValidTransactionWriter(String fileName) {
		this.fileName = fileName;
	}

	public void save(List<Transaction> validTrx) {
		List<String> lines = new TransactionSerializer().serialize( validTrx );
		new ZipFileUtil().saveToFile(fileName + ".gz", lines );
	}

}
