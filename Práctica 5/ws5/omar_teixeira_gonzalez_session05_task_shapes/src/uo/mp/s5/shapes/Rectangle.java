package uo.mp.s5.shapes;

import java.io.PrintStream;

import uo.mp2021.util.checks.ArgumentChecks;

/**
 * Titulo: Clase Rectangle
 * 
 * @author Omitg
 * @version 04-03-2021
 */
public class Rectangle extends Shape {
//Atributos:
	/**
	 * Atributo altura del rectangulo
	 */
	private int height;
	/**
	 * Atributo anchura del rectangulo
	 */	
	private int width;
	
	/**
	 * Constructor con parámetros de la clase Rectangle
	 * 
	 * @param x, coordenada x
	 * @param y, coordenada y
	 * @param width, anchura del rectangulo
	 * @param height, altura del rectangulo
	 * @param colour, color del rectangulo
	 */
	public Rectangle(int x, int y, int width, int height, Colour colour) {
		super(x, y, colour);
		ArgumentChecks.isTrue(width >= 0);
		ArgumentChecks.isTrue(height >= 0);	
		this.width = width;
		this.height = height;
	}
	
	/**
	 * Método que devuelve el valor del atributo width
	 * 
	 * @return width, anchura del rectangulo
	 */
	public int getWidth() {
		return width;
	}

	/**
	 * Método que devuelve el valor del atributo height
	 * 
	 * @return height, altura del rectangulo
	 */
	public int getHeight() {
		return height;
	}
	
	/**
	 * Método que imprime el rectangulo
	 * 
	 * @param out, lugar donde imprimir las formas o las fotos
	 */
	public void draw (PrintStream out) {
		out.println("Dibujando rectángulo: (" + getX() + ", " + 
		getY() + ") Ancho: " + getWidth() + "; Alto: " +
		getHeight() + "; Color: " + getColour());					
	}
}
