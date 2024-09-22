package uo.mp.s2.game.model.game2048;

/**
 * <p>
 * Título: Clase CodeForTest 
 * <p>
 *  
 * @author Omar Teixeira González
 * @version 11/02/2021
 */

public class CodeForTest {
	
	/**
	 * Matriz para la realización de los test 1 
	 */
	public static int[][] SEMIFULL11 = {{0,2,0},{0,2,0},{0,2,0}};
	
	/**
	 * Matriz para la realización de los test 2 
	 */
	public static int[][] SEMIFULL12 = {{2,0,0},{2,0,0},{2,0,0}};
	
	/**
	 * Matriz para la realización de los test 3 
	 */
	public static int[][] SEMIFULL13 = {{0,0,2},{0,0,2},{0,0,2}};
	
	/**
	 * Matriz para la realización de los test4 
	 */
	public static int[][] SEMIFULL1_RIGHTCOMPACTED = {{0,0,2},{0,0,2},{0,0,2}};
	
	/**
	 * Matriz para la realización de los test 5
	 */
	public static int[][] SEMIFULL1_LEFTCOMPACTED = {{2,0,0},{2,0,0},{2,0,0}};
	
	/**
	 * Matriz para la realización de los test 6 
	 */
	public static int[][] SEMIFULL21 = {{0,2,2},{0,2,2},{0,2,2}};
	
	/**
	 * Matriz para la realización de los test 7 
	 */
	public static int[][] SEMIFULL22 = {{2,2,0},{2,2,0},{2,2,0}};
	
	/**
	 * Matriz para la realización de los test 8 
	 */
	public static int[][] SEMIFULL23 = {{2,0,2},{2,0,2},{2,0,2}};
	
	/**
	 * Matriz para la realización de los test 9 
	 */
	public static int[][] SEMIFULL2_RIGHTCOMPACTED = {{0,2,2},{0,2,2},{0,2,2}};
	
	/**
	 * Matriz para la realización de los test 10 
	 */
	public static int[][] SEMIFULL2_LEFTCOMPACTED = {{2,2,0},{2,2,0},{2,2,0}};
	
	/**
	 * Matriz para la realización de los test 11 
	 */
	public static int[][] EMPTY = {{0,0,0},{0,0,0},{0,0,0}};
	
	/**
	 * Matriz para la realización de los test 12 
	 */
	public static int[][] FULL = {{2,2,2},{2,2,2},{2,2,2}};
	
	/**
	 * Matriz para la realización de los test 13 
	 */			
	public static int[][] SEMIFULL31 = {{0,0,0},{0,0,0},{2,2,2}};
	
	/**
	 * Matriz para la realización de los test 14 
	 */
	public static int[][] SEMIFULL32 = {{0,0,0},{2,2,2},{0,0,0}};
	
	/**
	 * Matriz para la realización de los test 15 
	 */
	public static int[][] SEMIFULL33 = {{2,2,2},{0,0,0},{0,0,0}};
	
	/**
	 * Matriz para la realización de los test 16 
	 */
	public static int[][] SEMIFULL3_UPCOMPACTED = {{2,2,2},{0,0,0},{0,0,0}};
	
	/**
	 * Matriz para la realización de los test 17 
	 */
	public static int[][] SEMIFULL3_DOWNCOMPACTED = {{0,0,0},{0,0,0},{2,2,2}};
	
	/**
	 * Matriz para la realización de los test 18 
	 */
	public static int[][] SEMIFULL41 = {{0,0,0},{2,2,2},{2,2,2}};
	
	/**
	 * Matriz para la realización de los test 19 
	 */
	public static int[][] SEMIFULL42 = {{2,2,2},{0,0,0},{2,2,2}};
	
	/**
	 * Matriz para la realización de los test 20 
	 */
	public static int[][] SEMIFULL43 = {{2,2,2},{2,2,2},{0,0,0}};
	
	/**
	 * Matriz para la realización de los test 21 
	 */
	public static int[][] SEMIFULL4_UPCOMPACTED = {{2,2,2},{2,2,2},{0,0,0}};
	
	/**
	 * Matriz para la realización de los test 22 
	 */
	public static int[][] SEMIFULL4_DOWNCOMPACTED = {{0,0,0},{2,2,2},{2,2,2}};
	
	
	/**
	 * Método estatico getSum que recibe como parametro una matriz 
	 * y devuelve la suma de todos los elementos de la matriz
	 * 
	 * @param	matrix, matriz de la que se sumaran todos los elementos
	 * @return	cont, suma de todos los elementos de la matriz
	 */
	public static int getSum(int[][] matrix) {
		int cont = 0;
		for (int i = 0; i < matrix.length; i++)
			for (int j = 0; j < matrix[i].length; j++)
				cont = cont + matrix[i][j];
		return cont;
	}

}
