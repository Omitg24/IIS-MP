package uo.mp.marker.questions;

import uo.mp.checks.ArgumentChecks;

/**
 * Titulo: Clase Gap
 * 
 * @author Omitg
 * @version 22-04-2021
 */
public class Gap extends Question{
	/**
	 * Atributo word
	 */
	private String word;
	
	/**
	 * Constructor con par�metros de Gap
	 * 
	 * @param number, numero
	 * @param weight, peso
	 * @param word, palabra
	 */
	public Gap(int number, double weight, String word) {		
		super(number, weight);
		ArgumentChecks.isTrue(word!=null && !word.trim().isEmpty());
		this.word=word;
	}
	
	/**
	 * M�todo que devuelve la puntuacion
	 * 
	 * @param answer, respuesta
	 * @return double, peso
	 */
	@Override
	public double getMarkForAnswer(String answer) {
		if (answer.equals(word)) {
			return weight;
		}
		return 0.0;
	}
}
