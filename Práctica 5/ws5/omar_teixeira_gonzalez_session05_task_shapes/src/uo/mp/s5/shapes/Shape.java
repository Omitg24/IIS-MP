package uo.mp.s5.shapes;

import java.io.PrintStream;

import uo.mp.s5.figure.drawable.Drawable;
import uo.mp2021.util.checks.ArgumentChecks;

/**
 * Titulo: Clase Shape
 * 
 * @author Omitg
 * @version 04-03-2021
 */
public abstract class Shape implements Drawable{
//Atributos:
	/**
	 * Coordenada X
	 */
	protected int x;
	/**
	 * Coordenada Y
	 */
	protected int y;
	
	/**
	 * Color de la forma
	 */
	protected Colour colour;
	
	/**
	 * Constructor sin parámetros que genera la superclase
	 */
	public Shape() {
		super();
	}
	
	/**
	 * Constructor con parámetros que genera la superclase con unos parámetros
	 * 
	 * @param x, coordenada x
	 * @param y, coordenada y
	 * @param colour, color de la forma
	 */
	public Shape(int x, int y, Colour colour) {
		ArgumentChecks.isTrue(x >= 0, "La x no cumple los requisitos");
		ArgumentChecks.isTrue(y >= 0, "La y no cumple los requisitos");
		ArgumentChecks.isTrue(colour != null, "El color no cumple los requisitos");
		this.x=x;
		this.y=y;
		this.colour=colour;
	}
	
	/**
	 * Método que devuelve el valor del atributo x
	 * 
	 * @return x, coordenada x
	 */
	public int getX() {
		return x;
	}

	/**
	 * Método que devuelve el valor del atributo y
	 * 
	 * @return y, coordenada y
	 */
	public int getY() {
		return y;
	}
	
	/**
	 * Método que devuelve el valor del atributo color
	 * 
	 * @return colour, color de la forma
	 */
	public Colour getColour() {
		return colour;
	}
	
	/**
	 * Método que imprime las formas o las fotos
	 * 
	 * @param out, lugar donde imprimir las formas o las fotos
	 */
	public abstract void draw (PrintStream out);		
}