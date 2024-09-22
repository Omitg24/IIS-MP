package uo.mp.battleship.board;

import uo.mp2021.util.checks.ArgumentChecks;

/**
 * Titulo: Clase Coordinate
 * 
 * Descripci�n: Clase que settea las coordenadas
 * 
 * @author Omitg
 * @version 07-05-2021
 */
public class Coordinate {
//Constantes:
	/**
	 * Constante para la conversi�n del int al char
	 */
	public static final int CHAR_VALUE = 64;	
	/**
	 * Constantes norte, este, sur y oeste
	 */
	public static final int N=0, E=1, S=2, W=3;	
//Atributos:
	/**
	 * Coordenada x 
	 */
	private int x;
	
	/**
	 * Coordenada y 
	 */
	private int y;

	/**
	 * Constructor con parametros int, para expresar las coordenadas de la 
	 * siguiente forma: x=1 y=3
	 * 
	 * @param x, coordenada x, de tipo int
	 * @param y, coordeanda y, de tipo int
	 */
	public Coordinate(int x, int y) {
		ArgumentChecks.isTrue(x>=0 && y>=0, "Los par�metros no cumplen la condici�n");
		setCol(x);
		setRow(y);
	}
	
	/**
	 * Constructor con parametros char e int, para expresar las coordenadas de 
	 * la siguiente forma: x='B' y=3
	 * 
	 * @param x, coordenada x, de tipo char
	 * @param y, coordeanda y, de tipo int
	 */
	public Coordinate(char x, int y) {		
		setCol(x);
		setRow(y);
	}
	
	/**
	 * M�todo que devuelve el valor del atributo x
	 * 
	 * @return x, coordenada x
	 */
	public int getCol() {
		return x;
	}
		
	/**
	 * M�todo que devuelve el valor del atributo y
	 * 
	 * @return y, coordenada y
	 */
	public int getRow() {
		return y;
	}
	
	/**
	 * M�todo que modifica el valor del atributo y
	 * 
	 * @param y, coordenada y, de tipo int
	 */
	private void setRow(int y) {
		this.y=y;
	}
	
	/**
	 * M�todo que modifica el valor del atributo x
	 * 
	 * @param x, coordenada x, de tipo int
	 */
	private void setCol(int x) {
		this.x=x;
	}
	
	/**
	 * M�todo que modifica el valor del atributo x
	 *  
	 * @param x, coordenada x, de tipo char
	 */
	private void setCol(char x) {
		this.x=x;
	}
	
	@Override
	/**
	 * M�todo que devuelve las coordenadas x, y del objeto con un formato especial
	 * 
	 * @return Coordenada con los valores correspondientes
	 */
	public String toString() {
		return "Coordenada [ x = " + getCol() + ", y = " + getRow() + " ]";
	}
	
	/**
	 * M�todo que devuelve las coordenadas con formato: "A-1"
	 * 
	 * @return Coordenada con la letra y el numero
	 */
	public String toUserString() {
		char CoordinateLetter=(char)(getCol()+CHAR_VALUE+1);
		return CoordinateLetter + "-" + (getRow()+1);
	}
	
	/**
	 * M�todo que devuelve true si ambos objetos son iguales
	 */
	public boolean equals(Object obj) {		
		return super.equals(obj);
	}
	
	/**
	 * M�todo que devuelve un objeto Coordinate que invoca al m�todo, en la direcc�n recibida como par�metro, siendo:
	 * 		-> Norte = 0
	 * 		-> Este = 1
	 * 		-> Sur = 2
	 *		-> Oeste = 3
	 * 
	 * @param direction, direcci�n de la coordenada
	 * @return Coordinate, objeto coordinate
	 */
	public Coordinate go(int direction) {
		ArgumentChecks.isTrue(direction==N || direction==S || direction==E || 
				direction==W, "La direcci�n no cumple los requisitos");
		if (direction == N) {
			if (getRow()==0) {
				setRow(0);
			} else {
				setRow(getRow()-1);
				return this;
			}
		} else if (direction == E) {
			if (getCol()==75) {
				setCol(75);
			} else {
				setCol(getCol()+1);
				return this;
			}
		} else if (direction == S) {
			if (getRow()==10) {
				setRow(10);
			} else {
				setRow(getRow()+1);
				return this;
			}
		} else {
			if (getCol()==65) {
				setCol(65);
			} else {
				setCol(getCol()-1);
				return this;
			}
		}
		return this;		
	}
}
