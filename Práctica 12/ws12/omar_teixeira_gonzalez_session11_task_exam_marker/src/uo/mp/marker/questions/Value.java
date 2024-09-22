package uo.mp.marker.questions;

import uo.mp2021.util.checks.ArgumentChecks;

/**
 * Titulo: Clase Value
 *  
 * @author Omitg
 * @version 29-04-2021
 */
public class Value extends Question{
	/**
	 * Atributo valor
	 */
	private double value;

	/**
	 * Constructor con par�metros de value
	 * 
	 * @param number, numero
	 * @param weight, peso
	 * @param value, valor
	 */
	public Value(int number, double weight, double value) {		
		super(number, weight);
		ArgumentChecks.isTrue(value>0);
		this.value=value;
	}
	
	/**
	 * M�todo que devuelve el valor de value
	 * 
	 * @return value, valor
	 */
	public double getValue() {
		return value;
	}
	
	/**
	 * M�todo que comprueba si la respuesta es valida
	 * 
	 * @param answerValue, respuesta
	 * @return true si es valida
	 */
	private boolean isValidValue(double answerValue) {
		double min = getValue()-0.1;
		double max = getValue()+0.1;
		return answerValue>=min && answerValue<=max;
	}
	
	/**
	 * M�todo que convierte el string a double
	 * 
	 * @param s, string a convertir
	 * @return double, string convertido
	 */
	private double toDouble(String s) {
		return Double.parseDouble(s);
	}
	
	/**
	 * M�todo que devuelve los datos
	 * 
	 * @return string, cadena	
	 */
	public String toString() {
		return "VALUE: " + super.toString() + ", Value: " + getValue();
	}
	
	/**
	 * M�todo que devuelve la puntuacion
	 * 
	 * @param answer, respuesta
	 * @return double, peso
	 */
	@Override
	public double getMarkForAnswer(String answer) {
		double aux = toDouble(answer);
		if (isValidValue(aux)) {
			return weight;
		}		
		return 0.0;
	}
}