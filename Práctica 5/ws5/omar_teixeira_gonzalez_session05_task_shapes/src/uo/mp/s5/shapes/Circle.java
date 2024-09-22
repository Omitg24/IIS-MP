package uo.mp.s5.shapes;

import java.io.PrintStream;

import uo.mp2021.util.checks.ArgumentChecks;

/**
 * Titulo: Clase Circle
 * 
 * @author Omitg
 * @version 04-03-2021 
 */
public class Circle extends Shape {
	/**
	 * Atributo altura del rectangulo
	 */
	private int radius;	
	
	/**
	 * Constrcutor con parámetros de la clase Circle
	 * 
	 * @param x, coordenada x
	 * @param y, coordenada y
	 * @param radius, radio del circulo
	 * @param colour, color del circulo
	 */
	public Circle(int x, int y, int radius, Colour colour) {
		super(x, y, colour);		
		ArgumentChecks.isTrue(radius >= 0);		
		this.radius = radius;
	}	
	
	/**
	 * Método que devuelve el valor del atributo radius
	 * 
	 * @return radius
	 */
	public int getRadius() {
		return radius;
	}
	
	/**
	 * Método que imprime el circulo
	 * 
	 * @param out, lugar donde imprimir las formas o las fotos	
	 */
	public void draw (PrintStream out) {
		out.println("Dibujando circulo: (" + getX() + ", " + 
		getY() + ") Radio: " + getRadius() + "; Color: " + getColour());					
	}
}
