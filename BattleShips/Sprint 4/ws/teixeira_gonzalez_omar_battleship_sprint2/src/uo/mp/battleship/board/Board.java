package uo.mp.battleship.board;

import java.util.ArrayList;
import java.util.List;

import uo.mp.battleship.board.squares.Ship;
import uo.mp2021.util.checks.ArgumentChecks;

/**
 * Titulo: Clase Board
 * 
 * Descripción: Clase que crea el tablero 
 * 
 * @author Omitg
 * @version 07-03-2021
 */
public class Board {
//Atributos:
	/**
	 * Atributo board
	 */
	private Square[][] board;
	
	/*
	 * Atributop lista de barcos (flota)
	 */
	private List<Ship> ships;
		
	/**
	 * Constructor con parámetro size de la clase Board
	 * 
	 * @param size, tamaño del tablero
	 */
	public Board(int size) {
		ArgumentChecks.isTrue(size>=BoardBuilder.MIN_SIZE && 
				size<=BoardBuilder.MAX_SIZE, 
				"El parametro no cumple los requisitos");	
		ships = BoardBuilder.createFleet();
		board = new BoardBuilder().of(size).forFleet(ships).build();		
	}
	
	/**
	 * Método que dispara a una coordenada introducida
	 * 
	 * @param position, coordenadas a donde disparar
	 * @return true, si habia un barco en esas coordendas, o false en caso 
	 * contrario
	 */
	public int shootAt(Coordinate position) {		
		return board[position.getRow()][position.getCol()].shootAt();
	}	
	
	/**
	 * Método que comprueba si todos los barcos se han hundido, en ese caso 
	 * devuelve true
	 * 
	 * @return true, si los barcos se han hundido
	 */
	public boolean isFleetSunk() {
		for (int i=0; i<board.length;i++) {
			for (int j=0; j<board.length;j++) {
				if (board[i][j].contentInSquare().getClass()==Ship.class) {
					if (!board[i][j].isShot()) {
						return false;
					}
				}
			}
		}
		return true;
	}
	
	/**
	 * Método que devuelve el tamaño de la dimension del tablero
	 * 
	 * @return dim, dimensión del tablero
	 */
	public int getSize() {
		if (board.length==board[0].length) {
			int dim = board.length;
			return dim;
		}
		return 0;
	}
	
	/**
	 * Método que devuelve una lista con las coordenadas que no han sido 
	 * disparadas todavia
	 * 
	 * @return notFired, lista de coordendas no disparadas
	 */
	public List<Coordinate> getNotFiredPositions() {
		List<Coordinate> notFired = new ArrayList<Coordinate>();
		for (int i=0; i<board.length;i++) {
			for (int j=0; j<board[i].length; j++) {
				if (!board[i][j].isShot()) {
					notFired.add(new Coordinate(i,j));
				}
			}
		}
		return notFired;
	}
	
	/**
	 * Método que devuelve un array con el tablero en 2D con una representación 
	 * de caracteres
	 * 
	 * @return copy, array 2D con un formato predefinido
	 */
	public char[][] getFullStatus() {
		char[][] copy = new char[board.length][board[0].length];
		for (int i=0; i<board.length;i++) {
			for (int j=0; j<board[i].length; j++) {
				copy[i][j]=board[i][j].toChar();				
			}
		}		
		return copy;
	}
	
	/**
	 * Método que devuelve una array 2D con un formato combinado
	 * 
	 * @return copy, array 2D con un formato predefinido
	 */
	public char[][] getMinimalStatus() {
		char[][] copy = new char[board.length][board[0].length];
		for (int i=0; i<copy.length;i++) {
			for (int j=0; j<copy[i].length; j++) {				
				if (!board[i][j].isShot()) {
					copy[i][j] = ' ';					
				} else if (board[i][j].isShot()) {
					copy[i][j]= board[i][j].contentInSquare().toFiredChar();;
				}
			}
		}
		return copy;		
	}
	
	/**
	 * Método que devuelve una copia del tablero
	 * 
	 * @return copy, array 2D con los valores int
	 */
	public int[][] getBoard(){
		int[][] copy = new int [board.length][board[0].length];
		for (int i=0; i<copy.length;i++) {
			for (int j=0; j<copy[i].length; j++) {
				if (board[i][j].toChar()=='B') {
					copy[i][j]=4;
				}
				if (board[i][j].toChar()=='C') {
					copy[i][j]=3;
				}
				if (board[i][j].toChar()=='D') {
					copy[i][j]=2;
				}							
				if (board[i][j].toChar()=='S') {
					copy[i][j]=1;
				}				
				if (board[i][j].toChar()==' ') {
					copy[i][j]=0;
				}				
				if (board[i][j].toChar()=='.') {
					copy[i][j]=-10;
				}				
				if (board[i][j].toChar()=='*') {
					copy[i][j]=(-1);
				}				
				if (board[i][j].toChar()=='#') {
					copy[i][j]=(-1);
				}
			}
		}
		return copy;
	}
	
	/**
	 * Método que asigna el array de squares al atributo board
	 * 
	 * @param arg, array de squares introducido por parámetro
	 */
	public void setSquaresForTest (Square[][] arg) {
		this.board=arg;
	}
}
