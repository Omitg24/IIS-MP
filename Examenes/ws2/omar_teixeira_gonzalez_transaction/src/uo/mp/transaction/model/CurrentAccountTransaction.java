package uo.mp.transaction.model;

import uo.mp.transaction.model.util.IBAN;

public class CurrentAccountTransaction extends Transaction {
	
	private ClientType type;
	
	public CurrentAccountTransaction(String date, String number, ClientType type ,double amount, String description) {
		super(date, number, amount, description);
		this.type=type;
	}
	
	public ClientType getType() {
		return type;
	}

	@Override
	public void validate() {
		if (getType().equals(ClientType.N)) {
			if (getAmount()>1000) {
				this.addFault("(acc) El tipo de cliente es normal "
						+ "y la cantidad es mayor que 1000, es: " +this.getAmount());
			}
		}
		if (!IBAN.isValid(getNumber())) {
			this.addFault("(acc) El IBAN no es válido, es: " + this.getNumber());
		}
	}

	@Override
	public String toString() {
		return "CurrentAccountTransaction: " + getNumber() + " - " + getAmount() + " - " + getDescription() + " - " + getDate();
	}

	@Override
	public String serialize() {
		String result = "cc;" + this.getDate() + ";"  
				   + this.getNumber() + ";" 
			       + this.getType() + ";"				   
			       + this.getAmount() + ";" 
				   + this.getDescription();
		return result;
	}

}
