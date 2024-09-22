package uo.mp.battleship.console;

import uo.mp.battleship.board.Board;
import uo.mp.battleship.board.Coordinate;
import uo.mp.battleship.game.Game;
import uo.mp.battleship.interaction.GamePresenter;
import uo.mp.battleship.player.Player;
import uo.mp2021.util.checks.ArgumentChecks;

/**
 * Titulo: Clase ConsoleGamePresenter
 * 
 * Descripción: Clase que imprime el estado de la partida
 * 
 * @author Omitg
 * @version 24-03-2021
 */
public class ConsoleGamePresenter implements GamePresenter{

	/**
	 * Método estatico que imprime el contenido del juego, es decir, 
	 * los dos tableros en función del debugMode
	 * 
	 * @param left, tablero de la izquierda (del jugador)
	 * @param right, tablero de la derecha (del ordenador)
	 * @param debugMode, modo de juego
	 */
	@Override
	public void showGameStatus(Board left, Board right, boolean debugMode) {
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
	private void showLetters(Board board) {
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
	private void show(Board left, Board right, boolean debugMode) {
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
	
	/**
	 * Método que imprime el mensaje de partida finalizada
	 */
	@Override
	public void showGameOver() {
		System.out.println("GAME OVER!!!!");
	}
	
	/**
	 * Método que imprime el ganador de la partida
	 */
	@Override
	public void showWinner(Player theWinner) {
		System.out.println("The winner is " + theWinner.getName() + ". Congratulations!!!");
	}

	/**
	 * Método que imprime el estado del disparo
	 */
	@Override
	public void showHitOrMiss(int impact) {
		if (impact==1) {
			System.out.println("Hit! Repeat");
		} else if (impact==2) {
			System.out.println("Hit and Sunk! Repeat");
		} else {
			System.out.println("Miss! Change turn");
		}
	}

	/**
	 * Método que imprime el turno del jugador
	 */
	@Override
	public void showTurn(Player player) {
		System.out.println("Now, the turn is for player " + player.getName());
	}
	
	/**
	 * Método que imprime la coordenada la que se dispara
	 */
	@Override
	public void showShootingAt(Coordinate coordinate) {
		System.out.println("Shooting at " + coordinate.toUserString());
	}
}
