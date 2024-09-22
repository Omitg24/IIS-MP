package uo.mp.s5.acme.picture;

import java.io.PrintStream;

import uo.mp.s5.figure.drawable.Drawable;
import uo.mp2021.util.checks.ArgumentChecks;

/**
 * Titulo: Clase Picture
 * 
 * @author Omitg
 * @version 04-03-2021
 */
public class Picture implements Drawable{
//Atributos:
	/**
	 * Atributo posX
	 */
	private int posX;
	
	/**
	 * Atributo posY
	 */
	private int posY;
	
	/**
	 * Atributo filename
	 */
	private String filename;
	
	/**
	 * Atributo altura del rectangulo
	 */
	private int height;
	
	/**
	 * Atributo anchura del rectangulo
	 */	
	private int width;
	
	/**
	 * Constructor con par�metros de la clase Picture
	 * 
	 * @param posX, posici�n X de la foto
	 * @param posY, posici�n Y de la figura
	 * @param height, altura de la foto
	 * @param width, anchura de la foto
	 * @param filename, archivo donde se almacena
	 */
	public Picture(int posX, int posY, int height, int width, String filename) {
		super();
		ArgumentChecks.isTrue(posX>=0, "La posici�n X no cumple los requisitos");
		ArgumentChecks.isTrue(posY>=0, "La posici�n Y no cumple los requisitos");
		ArgumentChecks.isTrue(height>=0, "La altura no cumple los requisitos");
		ArgumentChecks.isTrue(width>=0, "La anchura no cumple los requisitos");
		ArgumentChecks.isTrue(filename!=null && !filename.trim().isEmpty(), 
				"El fichero no es posible");
		this.posX = posX;
		this.posY = posY;
		this.height = height;
		this.width = width;
		this.filename = filename;
	}
	
	/**
	 * M�todo que devuelve el valor del atributo width
	 *  
	 * @return width, anchura 
	 */
	public int getWidth() {
		return width;
	}

	/**
	 * M�todo que devuelve el valor del atributo height
	 *  
	 * @return height, altura
	 */
	public int getHeight() {
		return height;
	}
	
	/**
	 * M�todo que devuelve el valor del atributo posX
	 * 
	 * @return posX, posicion X
	 */
	public int getPosX() {
		return posX;
	}
	
	/**
	 * M�todo que devuelve el valor del atributo posY
	 *  
	 * @return posY, posici�n Y
	 */
	public int getPosY() {
		return posY;
	}

	/**
	 * M�todo que devuelve el valor del atributo filename
	 *  
	 * @return filename, nombre del fichero
	 */
	public String getFilename() {
		return filename;
	}
	
	/**
	 * M�todo que dibuja la foto con sus datos
	 * 
	 * @param out, lugar a imprimir la foto
	 */
	public void draw(PrintStream out) {
		out.println("Dibujando imagen: '" + filename + "', Posici�n X: " + 
		getPosX() + " y Posici�n Y: " + getPosY() + "; Anchura: " + getWidth() + 
		" y Altura: " + getHeight());		
	}
}
