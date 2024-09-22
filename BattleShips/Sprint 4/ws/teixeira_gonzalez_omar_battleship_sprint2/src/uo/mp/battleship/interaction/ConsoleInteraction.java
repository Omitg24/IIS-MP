package uo.mp.battleship.interaction;

import uo.mp.battleship.board.Board;
import uo.mp.battleship.game.Game;
import uo.mp2021.util.checks.ArgumentChecks;

/**
 * Titulo: Clase ConsoleInteraction
 *  
 * @author Omitg
 * @version 07-03-2021
 */
public class ConsoleInteraction {
	
	/**
	 * Método estatico que imprime el contenido del juego, es decir, 
	 * los dos tableros en función del debugMode
	 * 
	 * @param left, tablero de la izquierda (del jugador)
	 * @param right, tablero de la derecha (del ordenador)
	 * @param debugMode, modo de juego
	 */
	public static void showGameStatus(Board left, Board right, boolean debugMode) {
		ArgumentChecks.isTrue(left!=null && right!=null,				 
				"Los parametros no cumplen los requisitos");
		System.out.println("         MY_SHIPS\t\t      OPPONENT'S_SHIPS\n");		
		System.out.print("    ");
		showLetters(left);
		System.out.print("            ");
		showLetters(right);
		System.out.println();
		show(left, right, debugMode);
		System.out.println();		
		
	}	
	
	/**
	 * Método que imprime las letras que marcan las columnas
	 * 
	 * @param board, tablero en el cual imprimir las letras
	 */
	private static void showLetters(Board board) {
		for (int x=0; x<board.getSize(); x++) {
			System.out.print((char)(x+65) + " ");
		}
	}
	
	/**
	 * Método que lanza los dos tableros con el número de las filas
	 * 
	 * @param left, tablero de la izquierda (del jugador)
	 * @param right, tablero de la derecha (del ordenador)
	 * @param debugMode, modo de juego
	 */
	private static void show(Board left, Board right, boolean debugMode) {
		int size = right.getSize();
		char[][] leftBoard = left.getFullStatus(); 
		char[][] rightBoardN = right.getMinimalStatus();
		char[][] rightBoardD = right.getFullStatus();
		for (int i=0; i<size; i++) {
			if (i<9) {
				System.out.print(" " + (i+1) + " ");
			} else {
				System.out.print(" " + (i+1) + "");
			}
			for (int j=0; j<size;j++) {
				if (j==size-1) {
					System.out.print("|" + leftBoard[i][j] + "|");
				} else {
					System.out.print("|" + leftBoard[i][j]);
				}	
			}
			System.out.print("\t");
			if (i<9) {
				System.out.print(" " + (i+1) + " ");
			} else {
				System.out.print(" " + (i+1) + "");
			}
			for (int j=0; j<size;j++) {
				if (debugMode == Game.NORMAL_MODE) {
					if (j==size-1) {
						System.out.print("|" + rightBoardN[i][j] + "|");
					} else {
						System.out.print("|" + rightBoardN[i][j]);
					}										
				} else {
					if (j==size-1) {
						System.out.print("|" + rightBoardD[i][j] + "|");
					} else {
						System.out.print("|" + rightBoardD[i][j]);
					}			
				}
			}
			System.out.println();
		}
	}		
}