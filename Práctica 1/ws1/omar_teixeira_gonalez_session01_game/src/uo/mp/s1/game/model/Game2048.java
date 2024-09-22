package uo.mp.s1.game.model;

import java.util.Random;

/**
 * <p>
 * T�tulo: Clase Game2048
 * </p>
 * <p>
 * Descripci�n: A partir de un array bidimensional de n�meros y a trav�s de
 * diferentes operaciones se simula un juego llamado "2048"
 * </p>
 * <p>
 * Copyright: Copyright (c) 2021
 * </p>
 * <p>
 * Empresa: Escuela de Ingenier�a Inform�tica - Uiversidad de Oviedo
 * </p>
 * 
 * @author Omar Teixeira Gonz�lez
 * @version 06/02/2021
 */
public class Game2048 {
	
	//Constantes
	public static final int MIN_DIMENSION=3;	//Dimensi�n minima necesaria de la matriz
	public static final int MAX_DIMENSION=10;	//Dimensi�n m�xima necesaria de la matriz
	
	//Atributos
	private int[][] board;		//Atributo board

	/**
	 * Constructor sin par�metros con tablero por defecto de 3*3 Inicialmente todas las posiciones con valor 0
	 */
	public Game2048() {
		board = new int[3][3];
		for (int i=0; i<board.length; i++) {
			for (int j=0; j<board[i].length; j++) {
				board[i][j]=0;
			}			
		}
	}

	/**
	 *Constructor que recibe la dimensi�n del tablero y crea una matriz de dicha dimensi�n contodas las posiciones con valor 0
	 *
	 *@param	dimension, dimension del tablero, de tipo int
	 */
	public Game2048(int dimension) {
		checkParam(dimension>=MIN_DIMENSION && dimension<=MAX_DIMENSION, "La dimension no cumple los requisitos");
		board = new int[dimension][dimension];
		for (int i=0; i<board.length; i++) {
			for (int j=0; j<board[i].length; j++) {
				board[i][j]=0;
			}			
		}
	}
	
	/**
	 * Inicializa el tablero con la matriz pasada como par�metro 
	 * 
	 * @param	board, tablero, de tipo int[][]
	 */
	public Game2048(int[][] board) {
		checkParam(board!=null && board.length>=MIN_DIMENSION && board.length<=MAX_DIMENSION && board[0].length>=MIN_DIMENSION 
				&& board[0].length<=MAX_DIMENSION && board.length==board[board.length-1].length, "El tablero no cumple los requisitos");
				this.board= board;
	}

	/**
	 * Devuelve una copia de la matriz para poder usarla en las pruebas
	 * 
	 * @return	matrix, matriz copia de la matriz board
	 */
	public int[][] getBoard() {
		int[][] matrix = new int[board.length][board.length];
		for (int i=0; i<board.length; i++) {
			for (int j=0; j<board[i].length; j++) {
				matrix[i][j]=board[i][j];
			}
		}
		return matrix;
	}
	
	/**
	 * Reinicia todas las posiciones a 0 y llama a next para que incluya un 2 en una posici�n aleatoria
	 */
	public void restart() {
		for (int i=0; i<board.length; i++) {
			for (int j=0; j<board[i].length; j++) {
				board[i][j]=0;
			}
		}
		next();
	}
		
	/**
	 * A�ade un nuevo n�mero 2 en una posici�n aleatoria
	 */
	public void next() {
		Random random=new Random();
		int randomRow=random.nextInt(board.length);
		int randomColumn=random.nextInt(board.length);
		while (board[randomRow][randomColumn]!=0) {
			randomRow=random.nextInt(board.length);
			randomColumn=random.nextInt(board.length);
		}
		board[randomRow][randomColumn]=2;
	}
	
	/**
	 * Comprueba si el tablero est� lleno. Esto ocurre cuando todas las celdas o posiciones del tablero tienen un n�mero distinto de cero
	 * 
	 * @return true si la matriz esta llena y false si no lo est�
	 */
	public boolean isBoardFull() {
		for (int i=0; i<board.length; i++) {
			for (int j=0;j<board[i].length;j++) {
				if (board[i][j]==0){
					return false;
				}
			}
		}
		return true;		
	}

	/**
	 * Compacta el tablero a la derecha compactando todas las filas
	 */
	public void compactRight() {
		for (int x=0; x<board.length;x++) {
			for (int y=board[x].length-2; y>=0;y--) {
				if (board[x][y]!=0) {
					int i=1;
					int j=0;
					while (y+i<board.length) {
						if (board[x][y+i]==0) {
						board[x][y+i]=board[x][y+j];
						board[x][y+j]=0;						
						}				
						i++;
						j++;
					}
				}					
			}
		}
	}
	
	/**
	 * Compacta el tablero a la izquierda compactando todas las filas
	 */
	public void compactLeft() {
		for (int x=0; x<board.length;x++) {
			for (int y=1; y<board[x].length;y++) {
				if (board[x][y]!=0) {
					int i=1;
					int j=0;
					while (y-i>=0) {
						if (board[x][y-i]==0) {
						board[x][y-i]=board[x][y-j];
						board[x][y-j]=0;						
						}				
						i++;
						j++;
					}
				}	
			}
		}
	}

	/**
	 * compacta toda la matriz hacia arriba compactando todas las filas
	 */
	public void compactUp() {
		for (int x=0; x<board.length;x++) {
			for (int y=1; y<board[x].length;y++) {
				if (board[y][x]!=0) {
					int i=1;
					int j=0;
					while (y-i>=0) {
						if (board[y-i][x]==0) {
						board[y-i][x]=board[y-j][x];
						board[y-j][x]=0;						
						}				
						i++;
						j++;
					}
				}	
			}
		}
	}

	/**
	 * Compacta la matriz hacia abajo compactando todas las filas
	 */
	public void compactDown() {
		for (int x=0; x<board.length;x++) {
			for (int y=board[x].length-2; y>=0;y--) {
				if (board[y][x]!=0) {
					int i=1;
					int j=0;
					while (y+i<board.length) {
						if (board[y+i][x]==0) {
						board[y+i][x]=board[y+j][x];
						board[y+j][x]=0;						
						}				
						i++;
						j++;
					}
				}					
			}
		}
	}
	
	/**
	 * Devuelve la matriz en formato para ser mostrado por pantalla
	 * 
	 * @return	str, la matriz en tipo String 
	 */
	public String toString() {
		String str="";
		for (int i=0; i<board.length;i++) {
			for (int j=0; j<board[i].length;j++) {
				str+=board[i][j];
			}
			str += "\n";
		}
		return str;
	}

	// Controlador del par�metro
	/**
	 * M�todo que controla el parametro y lanza una excepcion en caso de no cumplirse
	 * 
	 * @param condition, la condicion a cumplirse
	 * @param msg, la excepci�n
	 */
	private void checkParam(boolean condition, String msg){
        if(!condition){
            throw new RuntimeException(msg);
        }
   	}
}
