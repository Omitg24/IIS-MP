package uo.mp.battleship.model.boardbuilder;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import uo.mp.battleship.board.BoardBuilder;

/**
 * Titulo: Clase BuildTest
 * 
 * @author Omitg
 * @version 12-02-2021
 */
public class BuildTest {
	
	/**
	 * Prueba del método build de la clase buildBoard:
	 */
	@Test
	public void testBuild() {
		BoardBuilder boardBuilder = new BoardBuilder();
		int[][] board = boardBuilder.of(10).build();
		assertEquals(10,boardBuilder.getSize());		
		for (int k=0; k<boardBuilder.getSize();k+=2) {
			if (k==0 || k==2 || k==4 | k==6) {
				board[0][k]=1;						
			}
		}
		for(int k=0; k<boardBuilder.getSize();k++) {
			if (k!=2 && k!=5 && k!=8 && k!=9) {
				board[2][k]=2;						
			}	
		}
		for (int k=0; k<boardBuilder.getSize();k++) {
			if (k!=3 && k!=7 && k!=8 && k!=9) {
				board[4][k]=3;
			}
		}
		for (int k=0; k<boardBuilder.getSize();k++) {
			if (k==4 || k==5 || k==6 || k==7) {
				board[6][k]=4;
			}
		}
	}
}
