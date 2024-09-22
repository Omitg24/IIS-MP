package uo.mp.battleship.board.squares;

/**
 * Titulo: Clase Water
 * 
 * Descripci�n: Clase que representa el agua del tablero y le a�ade m�todos 
 * que le dan acciones correspondiente
 * 
 * @author Omitg
 * @version 16-04-2021  
 */
public class Water implements Target{
	
	/**
	 * M�todo que devuelve 0 tras un disparo al agua
	 * 
	 * @return 0, valor del disparo del agua
	 */
	@Override
	public int shootAt() {
		return 0;
	}
	
	/**
	 * M�todo que devuelve false tras un disparo al agua porque no hay impactos 
	 * en un barco
	 * 
	 * @return false, porque no impacta en ningun barco
	 */
	@Override
	public boolean hasImpact() {
		return false;
	}
	
	/**
	 * M�todo que devuelve el caracter asociado al agua, un espacio en blanco
	 * 
	 * @return ' ', caracter asociao al agua 
	 */
	@Override
	public char toChar() {
		return ' ';
	}
	
	/**
	 * M�todo que devuelve el caracter asociado a un disparo al agua, un punto
	 * 
	 * @return '.', caracter asociao a un disparo al agua 
	 */
	@Override
	public char toFiredChar() {
		return '.';
	}

}
