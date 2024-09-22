package uo.mp.transaction.validator.file;

import java.io.FileNotFoundException;

import uo.mp.collections.List;
import uo.mp.file.TxtFileUtil;
import uo.mp.transaction.model.Transaction;
import uo.mp.transaction.validator.parser.TransactionParser;

public class TransactionLoader {

	private String fileName;

	public TransactionLoader(String fileName) {
		this.fileName = fileName;
	}

	public List<Transaction> load() throws FileNotFoundException {
		List<String> lines = new TxtFileUtil().readLines( fileName );
		return new TransactionParser().parse( lines );
	}

}
