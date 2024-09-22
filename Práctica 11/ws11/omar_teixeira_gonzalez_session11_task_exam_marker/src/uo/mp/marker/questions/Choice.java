package uo.mp.marker.questions;

import uo.mp.checks.ArgumentChecks;

/**
 * Titulo: Clase Choice
 * 
 * @author Omitg
 * @version 22-04-2021
 */
public class Choice extends Question{
	/**	
	 * Atributo option
	 */
	private String option;
	
	/**
	 * Constructor con par�metros de Choice
	 * 
	 * @param number, numero
	 * @param weight, peso de la pregunta
	 * @param option, opcion elegida
	 */
	public Choice(int number, double weight, String option) {
		super(number, weight);
		ArgumentChecks.isTrue(option!=null && !option.trim().isEmpty());
		this.option=option;
	}
	
	/**
	 * M�todo que devuelve la puntuacion
	 * 
	 * @param answer, respuesta
	 * @return double, peso
	 */
	@Override
	public double getMarkForAnswer(String answer) {
		if (answer.equals(option)) {
			return weight;
		}		
	return (-1)*(0.2)*weight; 			
	}
}
