package uo.mp.shopping.model;

import uo.mp.checks.ArgumentChecks;

public class FoodProduct extends Product {
	
	public static final double FOOD_IVA=0.1;
	
	private double weight;
	
	public FoodProduct(String code, String description, double basePrice, double weight) {
		super(code, description, basePrice);
		ArgumentChecks.isTrue(weight>0, "El peso no cumple los requisitos");
		this.weight=weight;
	}
		
	public double getWeight() {
		return weight;
	}
	
	@Override
	public double getCost() {
		double finalPrice = this.getBasePrice()*this.weight;
		double finalPriceIVA = finalPrice + (finalPrice*FOOD_IVA);
		return finalPriceIVA;
	}
	
	public String toString() {
		String result = super.toString() + "Food [weight=" + getWeight() + "]";
		return result;	
	}
	@Override
	public boolean equals(Object obj) {
		super.equals(obj);
		FoodProduct other = (FoodProduct) obj;
		if (Double.doubleToLongBits(weight) != Double.doubleToLongBits(other.weight))
			return false;
		return true;
	}
}
