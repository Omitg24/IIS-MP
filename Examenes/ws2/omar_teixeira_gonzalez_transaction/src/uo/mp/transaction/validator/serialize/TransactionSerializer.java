package uo.mp.transaction.validator.serialize;

import uo.mp.checks.ArgumentChecks;
import uo.mp.collections.List;
import uo.mp.collections.impl.ArrayList;
import uo.mp.transaction.model.Transaction;

public class TransactionSerializer {

	public List<String> serialize(List<Transaction> invalidTrx) {
		ArgumentChecks.isNotNull(invalidTrx);;
		List<String> lines = new ArrayList<>();
		for (Transaction t: invalidTrx) {
			lines.add(t.serialize());
		}
		return lines;
	}

}
