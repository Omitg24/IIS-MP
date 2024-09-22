package uo.mp.marker.questions;

import uo.mp2021.util.checks.ArgumentChecks;

/**
 * Titulo: Clase Question
 * 
 * @author Omitg
 * @version 29-04-2021
 */
public abstract class Question {
	/**
	 * Atributo numero
	 */
	protected int number;
	/**
	 * Atributo peso
	 */
	protected double weight;
	
	/**
	 * Constructor con par�metros de Question
	 * 
	 * @param number, numero
	 * @param weight, peso
	 */
	public Question(int number, double weight) {
		ArgumentChecks.isTrue(number>0 && weight>0);
		this.number=number;
		this.weight=weight;
	}
	
	/**
	 * M�todo que devuelve los datos
	 * 
	 * @return string, cadena	
	 */
	public String toString() {
		return "Number: " + number +", Weight: " + weight;
	}
	
	/**
	 * M�todo que devuelve la puntuacion
	 * 
	 * @param answer, respuesta
	 * @return double, peso
	 */
	public abstract double getMarkForAnswer(String answer);
}
