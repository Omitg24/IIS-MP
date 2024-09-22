package uo.mp.marker.questions;

import uo.mp.checks.ArgumentChecks;

/**
 * Titulo: Clase Question
 * 
 * @author Omitg
 * @version 22-04-2021
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
	 * Constructor con parámetros de Question
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
	 * Método que devuelve la puntuacion
	 * 
	 * @param answer, respuesta
	 * @return double, peso
	 */
	public abstract double getMarkForAnswer(String answer);
}
