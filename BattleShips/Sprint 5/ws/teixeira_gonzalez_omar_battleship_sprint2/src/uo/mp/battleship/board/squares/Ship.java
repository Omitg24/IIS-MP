package uo.mp.battleship.board.squares;

import uo.mp2021.util.checks.ArgumentChecks;

/**
 * Titulo: Clase Ship
 * 
 * Descripci�n: Clase que representa cualquier barco que se puede representar en 
 * el tableroy le a�ade m�todosque le dan acciones correspondiente, 
 * ocupando cada uno determinadas casillas, de esta forma:
 * 		-> (4x) Submarino: 1
 * 		-> (3x) Destructor: 2
 * 		-> (3x) Crucero: 3
 * 		-> (1x) Batalla: 4
 * 
 * @author Omitg
 * @version 07-03-2021
 */
public class Ship implements Target{
//Constantes:
	/**
	 * Constante tama�o minimo
	 */
	public static final int MIN_SIZE=1;
	
	/**
	 * Constante tama�o m�ximo
	 */
	public static final int MAX_SIZE=4;
	
	/**
	 * Constantes barcos
	 */
	public static final int SUBMARINE=1, DESTROYER=2, CRUISER=3, BATTLESHIP=4;
	
//Atributos
	/**
	 * Atributo tama�o del barco
	 */
	private int shipSize;
	
	/**
	 * Atributo disparos al barco
	 */
	private int numberOfShots;	

	/**
	 * Constructor con par�metros que settea el tama�o del barco si cumple 
	 * las condiciones adjuntadas
	 * 
	 * @param shipSize, tama�o del barco
	 */
	public Ship (int shipSize) {
		ArgumentChecks.isTrue(shipSize>=MIN_SIZE && shipSize<=MAX_SIZE,
				"El tama�o no cumple los requisitos");
		setSize(shipSize);
		setNumberOfShots(0);
	}
	
	/**
	 * M�todo que modifica el valor del atributo shipSize
	 * 
	 * @param shipSize, tama�o del barco 
	 */
	private void setSize(int shipSize) {
		this.shipSize=shipSize;
	}
	
	/**
	 * M�todo que devuelve el valor del atributo shipSize
	 *  
	 * @return shipSize, tama�o del barco
	 */
	public int size() {
		return shipSize;
	}
	
	/**
	 * M�todo que devuelve el valor del atributo numberOfShots
	 *  
	 * @return numberOfShots, numero de disparos al barco
	 */
	public int getNumberOfShots() {
		return numberOfShots;
	}

	/**
	 * M�todo que modifica el valor del atributo numberOfShots
	 *  
	 * @param numberOfShots, numero de disparos al barco
	 */
	public void setNumberOfShots(int numberOfShots) {
		this.numberOfShots = numberOfShots;
	}
	
	/**
	 * M�todo booleano que devuelve true si un  barco est� hundido o no
	 * 
	 * @return true o false si el barco esta hundido
	 */
	public boolean isSunk() {		
		if (getNumberOfShots()==size()) {
			return true;
		}
		return false;		
	}
	
	/**
	 * M�todo que devuelve un valor en funci�n del grado de disparo del barco:
	 * 		-> Devuelve 1 si toca el barco pero no se hunde
	 * 		-> Devuelve 2 si toca el barco y se hunde
	 * 
	 * @return 2 o 1 si toca o hunde el barco
	 */
	@Override
	public int shootAt() {		
		numberOfShots=numberOfShots+1;
		if (isSunk()) {			
			return 2;
		} else {					
			return 1;
		}
	}
	
	/**
	 * M�todo booleano que devuelve true si el barco ha sido tocado al menos una vez
	 * 
	 * @return true, si se ha tocado al barco
	 */
	@Override
	public boolean hasImpact() {
		if (getNumberOfShots()>=1) {			
			return true;			
		}
		return false;
	}
	
	/**
	 * M�todo que devuelve el simbolo de los barcos
	 * 
	 * @return 'S', 'D', 'C' o 'B', en funci�n del barco al que representan
	 */
	@Override
	public char toChar() {
		if (size()==SUBMARINE) {
			return 'S';
		} else if (size()==DESTROYER) {
			return 'D';
		} else if (size()==CRUISER) {
			return 'C';
		} else if (size()==BATTLESHIP){
			return 'B';
		}
		return 0;
	}

	/**
	 * M�todo que devuelve un simbolo concreto en funci�n de si se ha hundido o 
	 * tocado un barco
	 * 
	 * @return '#' o '*', si hunde o toca el barco
	 */
	@Override
	public char toFiredChar() {
		if (isSunk()) { 
			return '#';
		}
		return '*';
	}
}
