package uo.mp.battleship.board;

import uo.mp2021.util.checks.ArgumentChecks;
import uo.mp2021.util.checks.StateChecks;

/**
 * Titulo: Clase BoardBuilder
 * 
 * Descripci�n: Clase que se encarga de generar el tablero
 * 
 * @author Omitg
 * @version 12-02-2021
 */
public class BoardBuilder {
	/**
	 * Tama�o minimo del tablero
	 */
	public static final int MIN_SIZE = 5;
	
	/**
	 * Tama�o m�ximo del tablero
	 */
	public static final int MAX_SIZE = 15;
	
//Atributos:	
	/**
	 * Atributo tablero
	 */
	private int[][] board;
	
	/**
	 * Atributo tama�o
	 */
	private int size;

	/**
	 * M�todo que settea el tama�o de la dimension del tablero, debe de ser 
	 * entre 5 y 15
	 * 
	 * @param size, tama�o del tablero
	 * @return board, devuelve el tablero
	 */
	public BoardBuilder of(int size) {		
		ArgumentChecks.isTrue(size>=MIN_SIZE && size<=MAX_SIZE, 
				"El tama�o no respeta los l�mites");		
		setSize(size);
		return this;
	}
	
	/**
	 * M�todo que construye el tablero situando a los barcos en una posici�n 
	 * fija
	 * 
	 * @return board, tablero con los barcos situados
	 */
	public int[][] build() {		
		of(size);
		StateChecks.isTrue(size>=MIN_SIZE && size<=MAX_SIZE, 
				"El tama�o no respeta los l�mites");
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
	 * M�todo que setea el tama�o del tablero
	 * 
	 * @param size, tama�o del tablero
	 */
	private void setSize(int size) {
		this.size=size;
	}
	
	/**
	 * M�todo que devuelve el tama�o del tablero
	 * 
	 * @return size, tama�o del tablero
	 */
	public int getSize() {
		return size;
	}
}