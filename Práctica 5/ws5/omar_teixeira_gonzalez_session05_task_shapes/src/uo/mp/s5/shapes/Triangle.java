package uo.mp.s5.shapes;

import java.io.PrintStream;

import uo.mp2021.util.checks.ArgumentChecks;

/**
 * Titulo: Clase Triangle
 * 
 * @author Omitg
 * @version 04-03-2021
 */
public class Triangle extends Shape{
//Atributos
	/**
	 * Coordenada x2
	 */
	private int x2;
	
	/**
	 * Coordenada x3
	 */
	private int x3;
	
	/**
	 * Coordenada y2
	 */
	private int y2;
	
	/**
	 * Coordenada y3
	 */
	private int y3;
	
	/**
	 * Constructor con parámetros de la clase Triangle
	 * 
	 * @param x, coordenada x
	 * @param y, coordenada y
	 * @param x2, coordenada x2
	 * @param y2, coordenada y2
	 * @param x3, coordenada x3
	 * @param y3, coordenada y3
	 * @param colour, color del triangulo
	 */
	public Triangle(int x, int y, int x2, int y2, int x3, int y3, Colour colour) {
		super(x,y,colour);
		ArgumentChecks.isTrue(x2>=0, "La coordenada no cumple los requisitos");
		ArgumentChecks.isTrue(y2>=0, "La coordenada no cumple los requisitos");
		ArgumentChecks.isTrue(x3>=0, "La coordenada no cumple los requisitos");
		ArgumentChecks.isTrue(y3>=0, "La coordenada no cumple los requisitos");		
		this.x2=x2;
		this.y2=y2;
		this.x3=x3;
		this.y3=y3;		
	}
	
	/**
	 * Método que devuelve el valor del atributo x2
	 * 
	 * @return x2, coordenada x2
	 */
	public int getX2() {
		return x2;
	}

	/**
	 * Método que devuelve el valor del atributo x3
	 * 
	 * @return x3, coordenada x3
	 */
	public int getX3() {
		return x3;
	}

	/**
	 * Método que devuelve el valor del atributo y2
	 * 
	 * @return y2, coordenada y2
	 */
	public int getY2() {
		return y2;
	}

	/**
	 * Método que devuelve el valor del atributo y3
	 * 
	 * @return y3, coordenada y3
	 */
	public int getY3() {
		return y3;
	}
	
	/**
	 * Método que imprime el triangulo
	 * 
	 * @param out, lugar donde imprimir las formas o las fotos	
	 */
	public void draw(PrintStream out) {		
		out.println("Dibujando triangulo: Coordendas 1 (" + getX() + ", " + getY() 
		+ "); Coordenadas 2 (" + getX2() + ", " + getY2() + "); Coordenadas 3 (" 
		+ getX3() + ", " + getY3() + "); Color: " + getColour());
	}
}
