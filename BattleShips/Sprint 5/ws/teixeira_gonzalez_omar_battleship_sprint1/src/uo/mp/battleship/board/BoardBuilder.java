package uo.mp.battleship.board;

import uo.mp2021.util.checks.ArgumentChecks;
import uo.mp2021.util.checks.StateChecks;

/**
 * Titulo: Clase BoardBuilder
 * 
 * Descripción: Clase que se encarga de generar el tablero
 * 
 * @author Omitg
 * @version 12-02-2021
 */
public class BoardBuilder {
	/**
	 * Tamaño minimo del tablero
	 */
	public static final int MIN_SIZE = 5;
	
	/**
	 * Tamaño máximo del tablero
	 */
	public static final int MAX_SIZE = 15;
	
//Atributos:	
	/**
	 * Atributo tablero
	 */
	private int[][] board;
	
	/**
	 * Atributo tamaño
	 */
	private int size;

	/**
	 * Método que settea el tamaño de la dimension del tablero, debe de ser 
	 * entre 5 y 15
	 * 
	 * @param size, tamaño del tablero
	 * @return board, devuelve el tablero
	 */
	public BoardBuilder of(int size) {		
		ArgumentChecks.isTrue(size>=MIN_SIZE && size<=MAX_SIZE, 
				"El tamaño no respeta los límites");		
		setSize(size);
		return this;
	}
	
	/**
	 * Método que construye el tablero situando a los barcos en una posición 
	 * fija
	 * 
	 * @return board, tablero con los barcos situados
	 */
	public int[][] build() {		
		of(size);
		StateChecks.isTrue(size>=MIN_SIZE && size<=MAX_SIZE, 
				"El tamaño no respeta los límites");
		board = new int[getSize()][getSize()];
		for (int k=0; k<board.length;k++) {
			if (k==0 || k==2 || k==4 | k==6) {
				board[0][k]=1;							
			}
		}
		for(int k=0; k<board.length;k++) {
			if (k!=2 && k!=5 && k!=8 && k!=9) {
				board[2][k]=2;						
			}
		}
		for (int k=0; k<board.length;k++) {
			if (k!=3 && k!=7 && k!=8 && k!=9) {
				board[4][k]=3;
			}
		}
		for (int k=0; k<board.length;k++) {
			if (k==4 || k==5 || k==6 || k==7) {
				board[6][k]=4;
			}
		}				
		return board;
	}
	
	/**
	 * Método que setea el tamaño del tablero
	 * 
	 * @param size, tamaño del tablero
	 */
	private void setSize(int size) {
		this.size=size;
	}
	
	/**
	 * Método que devuelve el tamaño del tablero
	 * 
	 * @return size, tamaño del tablero
	 */
	public int getSize() {
		return size;
	}
}