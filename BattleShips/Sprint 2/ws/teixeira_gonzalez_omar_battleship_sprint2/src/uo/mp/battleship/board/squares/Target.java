package uo.mp.battleship.board.squares;

/**
 * Titulo: Interfaz Target
 * 
 * Descripci�n: Interfaz Target que almacena los objetivos a disparar
 *  
 * @author Omitg
 * @version 07-03-2021
 */
public interface Target {
	
	/**
	 * M�todo que devuelve un valor en funci�n del grado de disparo del barco:
	 * 		-> Devuelve 0 si toca el agua
	 * 		-> Devuelve 1 si toca el barco pero no se hunde
	 * 		-> Devuelve 2 si toca el barco y se hunde 		
	 * 
	 * @return 2 o 1 si toca o hunde el barco
	 */
	int shootAt();
	
	/**
	 * M�todo booleano que devuelve true si el barco ha sido tocado al menos una vez
	 * 
	 * @return true, si se ha tocado al barco
	 */
	boolean hasImpact();
	
	/**
	 * M�todo que devuelve el simbolo de los barcos
	 * 
	 * @return S, D, C o B, en funci�n del barco al que representan
	 */
	char toChar();
	
	/**
	 * M�todo que devuelve un simbolo concreto en funci�n de si se ha hundido o 
	 * tocado un barco
	 * 
	 * @return # o *, si hunde o toca el barco
	 */
	char toFiredChar();
}
