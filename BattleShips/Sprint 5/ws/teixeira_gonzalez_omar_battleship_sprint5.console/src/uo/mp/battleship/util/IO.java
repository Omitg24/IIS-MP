package uo.mp.battleship.util;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.InputMismatchException;
import java.util.Scanner;

import uo.mp.battleship.board.Coordinate;

/**
 * Titulo: Clase IO
 * 
 * Descripción: Clase que lee las coordenadas del jugador
 * 
 * @author Omitg
 * @version 07-05-2021
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
		String c;
		int x;
		int y;
		try {
			System.out.print("Col (letter): ");

			reader = new Scanner(System.in);
			
			c = reader.next();
			x = c.toUpperCase().charAt(0) - 'A';
			
			System.out.print("Row (number): ");
			reader = new Scanner(System.in);		
			
			y = reader.nextInt() - 1;
			return new Coordinate (x, y);			
		} catch (IllegalArgumentException | InputMismatchException e){
			System.out.println("Please, introduce a valid coordinate!\n");			
			System.out.print("Col (letter): ");

			reader = new Scanner(System.in);
			
			c = reader.next();
			x = c.toUpperCase().charAt(0) - 'A';
			
			System.out.print("Row (number): ");
			reader = new Scanner(System.in);		
			
			y = reader.nextInt() - 1;
			return new Coordinate (x, y);			
		}		
	}
	
	/**
	 * Método que produce la entrada por teclado
	 * 
	 * @return keyboard, entrada por teclado
	 * @throws IOException
	 */
	public static String keyboard() throws IOException {
		BufferedReader keyboard = new BufferedReader(
				new InputStreamReader(System.in));
		String line = keyboard.readLine();
		return line;
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