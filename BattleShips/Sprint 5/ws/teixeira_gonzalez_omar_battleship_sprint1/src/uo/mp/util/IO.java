package uo.mp.util;

import java.util.Scanner;

import uo.mp.battleship.board.Coordinate;

/**
 * Titulo: Clase IO
 * 
 * @author Omitg
 * @version 12-02-2021
 */
public class IO {
	
	/**
	 * Método lector estatico
	 */
	private static Scanner reader = new Scanner( System.in );

	/**
	 * Método que lee un numero introducido por teclado
	 * 
	 * @return num, el numeor introducido
	 */
	public static int readInt() {
		int num = reader.nextInt();
		return num;
	}
	
	/**
	 * Método que lee coordenadas aleatorias
	 * 
	 * @return Coordinate, coordenadas
	 */
	public static Coordinate readCoordinates () {
		System.out.print("Col (letter): ");
		
		String c = reader.next();
		int x = c.toUpperCase().charAt(0) - 'A';
		
		System.out.print("Row (number): ");
		
		int y = reader.nextInt() - 1;
		
		return new Coordinate (x, y);
	}
	
	/**
	 * Método que muestra por pantalla el contenido introducido
	 * 
	 * @param string, texto a mostrar
	 */
	public static void display(String string) {
		System.out.println( string );
		
	}

}