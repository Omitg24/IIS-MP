package uo.mp.s6.greenhouse.temperature;

import java.util.Random;

import uo.mp.s6.greenhouse.scanner.Checkable;

/**
 * <p>Title: TemperatureController</p>
 * <p>Description: Clase que simula un sensor de temperatura.</p>
 * <p>Copyright: Copyright (c) 2020</p>
 * <p>Escuela de Ingenier�a Inform�tica</p>
 * <p>Metodolog�a de la Programaci�n</p>
 * 
 * @author Profesores de Metodolog�a de la Programaci�n
 * @version 1.0
 */
public class TemperatureSensor implements Checkable{
	/**
	 * Atributo id del sensor	
	 */
	private int id;

	/**
	 * M�todo que crea un sensor de temperatura y le asigna un id
	 * 
	 * @param id, id del sensor
	 */
	public TemperatureSensor(int id) {
		this.id = id;
	}

	/**
	 * Simula la obtencci�n de la temperatura
	 * 
	 * Devuelve un valor en el rango [5, 40)
	 * @return la temperatura generada por el sensor.
	 */
	public int getTemperature() {
		return new Random().nextInt(36) + 5;
	}
	
	/**
	 * M�todo que devuelve los datos del sensor de temperatura
	 * 
	 * @return datos del sensor
	 */	
	public String toString() {
		return "TemperatureSensor [id=" + id + "]";
	}
	
	/**
	 * M�todo que checkea el estado del sensor de temperatura
	 * 
	 * @return true o false si el sensor esta estropeado
	 */
	@Override
	public boolean check() {
		int probability = new Random().nextInt(100);
		if (probability<=5) {
			return false;
		} else {
			return true;
		}
	}
	
}
