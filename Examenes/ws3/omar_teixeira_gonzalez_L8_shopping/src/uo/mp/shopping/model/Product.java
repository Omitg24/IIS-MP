/**
 * 
 */
package uo.mp.shopping.model;

import uo.mp.checks.ArgumentChecks;
import uo.mp.invoice.Billable;

public abstract class Product implements Billable{
	private String code;
	private String description; 
	private double basePrice;	
		
	public Product(String code, String description, double basePrice) {
		super();
		ArgumentChecks.isTrue(code!=null && !code.trim().isEmpty(), 
				"El codigo no cumple los requisitos");
		ArgumentChecks.isTrue(description!=null && !description.trim().isEmpty(), 
				"La descripción no cumple los requisitos");
		ArgumentChecks.isTrue(basePrice>0, "El precio base no cumple los requisitos");
		this.code=code;
		this.description=description;
		this.basePrice=basePrice;		
	}		
	
	public String getCode() {
		return code;
	}

	public String getDescription() {
		return description;
	}

	public double getBasePrice() {
		return basePrice;
	}

	public abstract double getCost();

	@Override
	public String toString() {
		String result = "Product [code" + getCode() +", desctiption=" + 
					getDescription() + ", basePrice=" +
					getBasePrice() + "]";  
		return result;
	}
	
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Product other = (Product) obj;
		if (Double.doubleToLongBits(basePrice) != Double.doubleToLongBits(other.basePrice))
			return false;
		if (code == null) {
			if (other.code != null)
				return false;
		} else if (!code.equals(other.code))
			return false;
		if (description == null) {
			if (other.description != null)
				return false;
		} else if (!description.equals(other.description))
			return false;
		return true;
	}
}
