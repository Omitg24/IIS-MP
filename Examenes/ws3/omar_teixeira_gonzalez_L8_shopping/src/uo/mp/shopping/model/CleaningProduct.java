package uo.mp.shopping.model;

import uo.mp.checks.ArgumentChecks;

public class CleaningProduct extends Product {

	public static final double CLEANING_IVA=0.2;
	
	private int pieces;
	
	public CleaningProduct(String code, String description, double basePrice, int pieces) {
		super(code, description, basePrice);
		ArgumentChecks.isTrue(pieces>0, "El numero de piezas no cumple los requisitos");
		this.pieces=pieces;
	}

	private int getPieces() { 
		return pieces;
	}
	
	@Override
	public double getCost() {
		double finalPrice = this.getBasePrice()*this.pieces;
		double finalPriceIVA = finalPrice + (finalPrice*CLEANING_IVA);
		return finalPriceIVA;
	}
	
	public String toString() {
		String result = super.toString() + "Cleaning [pieces=" + getPieces() + "]";
		return result;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + pieces;
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		super.equals(obj);
		CleaningProduct other = (CleaningProduct) obj;
		if (pieces != other.pieces)
			return false;
		return true;
	}
}
