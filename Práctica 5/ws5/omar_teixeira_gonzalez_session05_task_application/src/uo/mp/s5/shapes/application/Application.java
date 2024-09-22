package uo.mp.s5.shapes.application;

import uo.mp.s5.acme.picture.Picture;
import uo.mp.s5.figure.drawable.Canvas;
import uo.mp.s5.shapes.Circle;
import uo.mp.s5.shapes.Colour;
import uo.mp.s5.shapes.Rectangle;
import uo.mp.s5.shapes.Triangle;

/**
 * Titulo: Clase Application
 * 
 * @author Omitg
 * @version 04-03-2021
 */
public class Application {
	
	/**
	 * Método estático que lanza el programa
	 * 
	 * @param args, argumento a analizar
	 */
	public static void main(String[] args) {
		new Application().run();
	}
	
	/**
	 * Método que lanza la aplicación
	 */
	public void run() {
		Canvas drawing = new Canvas();

		drawing.add( new Rectangle(1, 2, 3, 6, Colour.BLACK) );
		drawing.add( new Rectangle(3, 4, 7, 8, Colour.YELLOW) );
		drawing.add( new Circle(5, 5, 2, Colour.RED) );
		drawing.add( new Triangle(5, 5, 5, 7, 7, 6, Colour.GREEN) );
		drawing.add( new Picture(10, 10, 100, 75, "picture1.jpg") );
		
		System.out.println("--------------------------------------------SHAPES-------------------------------------------\n");
		drawing.draw(System.out);
	}
}
