package uo.mp.transaction.model;

import uo.mp.checks.ArgumentChecks;
import uo.mp.transaction.model.util.Lhun;

public class CreditCardTransaction extends Transaction {
	
	private String finalDate;
	private double maxAmount;
	
	public CreditCardTransaction(String date, String number, String finalDate, 
			double maxAmount, double amount, String description) {
		super(date, number, amount, description);
		ArgumentChecks.isTrue(finalDate!=null && !finalDate.trim().isEmpty(), 
				"La fecha final no cumple los requisitos");
		ArgumentChecks.isTrue(maxAmount>0, "La cantidad máxima no cumple los requisitos");
		this.finalDate=finalDate;
		this.maxAmount=maxAmount;
	}

	@Override
	public void validate() {
		if ( this.maxAmount < getAmount()) {
            addFault("(cc) El número IBAN es inválido: "+ this.getNumber());

        }else if(this.finalDate.compareTo(this.getDate()) < 0 ) {
            addFault("(cc) La fecha "+this.getDate()+" se sobrepasa de la permitida "+this.finalDate);

        }else if(!Lhun.isValid( this.getNumber() ) ) {
            addFault( "(cc) La cantidad "+ this.getAmount() +" es mayor que el máximo:"+ 
                                            this.maxAmount+" para la tarjeta de crédito");
        }
	}

	@Override
	public String toString() {
		return "CreditCardTransaction " + finalDate + " - " + maxAmount + " - "
				+ getNumber() + " - " + getAmount() + " - " + getDescription()
				+ " - " + getDate();
	}

	@Override
	public String serialize() {
		String result = "cc;" + this.getDate() + ";"  
							   + this.getNumber() + ";" 
						       + this.finalDate + ";" 
							   + this.maxAmount + ";" 
						       + this.getAmount() + ";" 
							   + this.getDescription();
		return result;
	}

}
