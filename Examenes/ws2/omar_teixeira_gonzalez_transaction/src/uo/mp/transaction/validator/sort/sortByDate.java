package uo.mp.transaction.validator.sort;

import java.util.Comparator;

import uo.mp.transaction.model.Transaction;

public class sortByDate implements Comparator<Transaction>{

	@Override
	public int compare(Transaction o1, Transaction o2) {
		int dif = o1.getDate().compareTo(o2.getDate());
		if (dif==0) {
			dif =  (toInteger(o1.getNumber())-toInteger(o2.getNumber()));
		}
		return dif;
	}
	
	private int toInteger(String string) {		
		return Integer.valueOf(string);		
	}
}
