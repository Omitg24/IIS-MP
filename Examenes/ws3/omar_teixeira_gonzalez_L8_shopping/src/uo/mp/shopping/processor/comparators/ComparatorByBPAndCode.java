package uo.mp.shopping.processor.comparators;

import java.util.Comparator;

import uo.mp.shopping.model.Product;

public class ComparatorByBPAndCode implements Comparator<Product>{

	@Override
	public int compare(Product o1, Product o2) {
		int dif = (int) (o1.getBasePrice()-o2.getBasePrice());
		if (dif==0) {
			dif = o1.getCode().compareTo(o2.getCode());
		}
		return dif;
	}

}
