package uo.mp.battleship.board.squares;

/**
 * Titulo: Interfaz Target
 * 
 * Descripción: Interfaz Target que almacena los objetivos a disparar
 *  
 * @author Omitg
 * @version 07-03-2021
 */
public interface Target {
	
	/**
	 * Método que devuelve un valor en función del grado de disparo del barco:
	 * 		-> Devuelve 0 si toca el agua
	 * 		-> Devuelve 1 si toca el barco pero no se hunde
	 * 		-> Devuelve 2 si toca el barco y se hunde 		
	 * 
	 * @return 2 o 1 si toca o hunde el barco
	 */
	int shootAt();
	
	/**
	 * Método booleano que devuelve true si el barco ha sido tocado al menos una vez
	 * 
	 * @return true, si se ha tocado al barco
	 */
	boolean hasImpact();
	
	/**
	 * Método que devuelve el simbolo de los barcos
	 * 
	 * @return S, D, C o B, en función del barco al que representan
	 */
	char toChar();
	
	/**
	 * Método que devuelve un simbolo concreto en función de si se ha hundido o 
	 * tocado un barco
	 * 
	 * @return # o *, si hunde o toca el barco
	 */
	char toFiredChar();
}
