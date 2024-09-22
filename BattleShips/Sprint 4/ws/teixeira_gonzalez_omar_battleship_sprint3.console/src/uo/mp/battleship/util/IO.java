package uo.mp.battleship.util;

import java.util.Scanner;

import uo.mp.battleship.board.Coordinate;

/**
 * Titulo: Clase IO
 * 
 * Descripción: Clase que lee las coordenadas del jugador
 * 
 * @author Omitg
 * @version 24-03-2021
 */
public class IO {
	/**
	 * Método lector estatico
	 */
	private static Scanner reader = new Scanner( System.in );

	/**
	 * Método que lee coordenadas aleatorias
	 * 
	 * @return Coordinate, coordenadas
	 */
	public static Coordinate readCoordinates () {
		System.out.print("Col (letter): ");

		reader = new Scanner(System.in);
		
		String c = reader.next();
		int x = c.toUpperCase().charAt(0) - 'A';
		
		System.out.print("Row (number): ");
		reader = new Scanner(System.in);
		
		int y = reader.nextInt() - 1;
		
		return new Coordinate (x, y);
	}
	
	/**
	 * Método estatico que muestra por pantalla un mensaje
	 * 
	 * @param string, mensaje a mostrar
	 */
	public static void display(String string) {
		System.out.println( string );
		
	}

}