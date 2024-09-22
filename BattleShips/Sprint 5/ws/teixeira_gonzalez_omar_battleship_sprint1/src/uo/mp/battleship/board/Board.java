package uo.mp.battleship.board;

import java.util.ArrayList;
import java.util.List;

import uo.mp2021.util.checks.ArgumentChecks;

/**
 * Titulo: Clase Board
 * 
 * Descripci�n: Clase que crea el tablero 
 * 
 * @author Omitg
 * @version 12-02-2021
 */
public class Board {
	/**
	 * Atributo board
	 */
	private int[][] board;
	
	/**
	 * Constructor con par�metro size de la clase Board
	 * 
	 * @param size, tama�o del tablero
	 */
	public Board(int size) {
		ArgumentChecks.isTrue(size>=BoardBuilder.MIN_SIZE && 
				size<=BoardBuilder.MAX_SIZE, 
				"El parametro no cumple los requisitos");
		board = new BoardBuilder().of(size).build();
	}
	
	/**
	 * M�todo que dispara a una coordenada itnroduc
	 * 
	 * @param position, coordenadas a donde disparar
	 * @return true, si habia un barco en esas coordendas, o false en caso 
	 * contrario
	 */
	public boolean shootAt(Coordinate position) {
		ArgumentChecks.isTrue(position!=null,
				"El par�metro no cumple los requisitos");
		if (board[position.getRow()][position.getCol()]>0) {
			board[position.getRow()][position.getCol()]=(-1)*
					board[position.getRow()][position.getCol()];
			return true;
		} else if (board[position.getRow()][position.getCol()]<0 && 
				board[position.getRow()][position.getCol()]>-10) {
			return true;
		} else { 
			board[position.getRow()][position.getCol()]=-10;
			return false;
		}
	}	
	
	/**
	 * M�todo que comprueba si todos los barcos se han hundido, en ese caso 
	 * devuelve true
	 * 
	 * @return true, si los barcos se han hundido
	 */
	public boolean isFleetSunk() {
		for (int i=0; i<board.length;i++) {
			for (int j=0; j<board[i].length; j++) {
				if (board[i][j]>0) {
					return false;
				}
			}
		}
		return true;
	}
	
	/**
	 * M�todo que devuelve el tama�o de la dimension del tablero
	 * 
	 * @return dim, dimensi�n del tablero
	 */
	public int getSize() {
		if (board.length==board[0].length) {
			int dim = board.length;
			return dim;
		}
		return 0;
	}
	
	/**
	 * M�todo que devuelve una lista con las coordenadas que no han sido 
	 * disparadas todavia
	 * 
	 * @return notFired, lista de coordendas no disparadas
	 */
	public List<Coordinate> getNotFiredPositions() {
		List<Coordinate> notFired = new ArrayList<Coordinate>();
		for (int i=0; i<board.length;i++) {
			for (int j=0; j<board[i].length; j++) {
				if (board[i][j]>=0) {
					notFired.add(new Coordinate(i,j));
				}
			}
		}
		return notFired;
	}
	
	/**
	 * M�todo que devuelve un array con el tablero en 2D con una representaci�n 
	 * de caracteres
	 * 
	 * @return copy, array 2D con un formato predefinido
	 */
	public char[][] getFullStatus() {
		char[][] copy = new char[board.length][board[0].length];
		for (int i=0; i<copy.length;i++) {
			for (int j=0; j<copy[i].length; j++) {
				if (board[i][j]==0) {
					copy[i][j] = ' ';					
				}
				if (board[i][j]==-10) {
					copy[i][j] = '.';
				}
				if (board[i][j]<0 && board[i][j]>-10) {
					copy[i][j] = '*';
				}
				if (board[i][j]==1) {
					copy[i][j] = 'S';
				}
				if (board[i][j]==2) {
					copy[i][j] = 'D';
				}
				if (board[i][j]==3) {
					copy[i][j] = 'C';
				}
				if (board[i][j]==4) {
					copy[i][j] = 'B';
				}
			}
		}
		return copy;
	}
	
	/**
	 * M�todo que devuelve una array 2D con un formato combinado
	 * 
	 * @return copy, array 2D con un formato predefinido
	 */
	public char[][] getMinimalStatus() {
		char[][] copy = new char[board.length][board[0].length];
		for (int i=0; i<copy.length;i++) {
			for (int j=0; j<copy[i].length; j++) {
				if (board[i][j]>=0) {
					copy[i][j] = ' ';					
				}
				if (board[i][j]<0 && board[i][j]>-10) {
					copy[i][j] =  '*';
				}
				if (board[i][j]==-10) {
					copy[i][j] = '.';
				}
			}
		}
		return copy;		
	}
	
	/**
	 * M�todo que devuelve una copia del tablero
	 * 
	 * @return copy, array 2D con los valores int
	 */
	public int[][] getBoard(){
		int[][] copy = new int [board.length][board[0].length];
		for (int i=0; i<copy.length;i++) {
			for (int j=0; j<copy[i].length; j++) {
				copy[i][j]=board[i][j];
			}
		}
		return copy;
	}
}
