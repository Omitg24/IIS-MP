package uo.mp.s5.figure.drawable;

import java.io.PrintStream;
import java.util.ArrayList;
import java.util.List;

/**
 * Titulo: Clase Canvas
 * 
 * @author Omitg
 * @version 04-03-2021
 */
public class Canvas {
	/**
	 * Atributo lista drawables
	 */
	private List<Drawable> drawables = new ArrayList<>();
	
	/**
	 * Método que añade a la lista los objetos dibujables
	 * 
	 * @param drawable, objeto a añadir
	 */
	public void add(Drawable drawable) {
		drawables.add(drawable);
	}
	
	/**
	 * Método que dibuja por pantalla los objetos de la colección
	 * 
	 * @param out, lugar donde imprimir los archivos, de tipo PrintStream
	 */
	public void draw(PrintStream out) {
		for (Drawable shape : drawables) {
			shape.draw(out);
		}		
	}
}
