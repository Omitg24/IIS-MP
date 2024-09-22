package uo.mp.s6.greenhouse.humidity;

import java.util.Random;

import uo.mp.s6.greenhouse.scanner.Checkable;

/**
 * Titulo: Clase HumiditySensor
 * 
 * @author Omitg
 * @version 18-03-2021
 */
public class HumiditySensor implements Checkable{
	/**
	 * Atributo id del sensor 
	 */
	private int id;
	
	/**
	 * Constructo que crea un sensor de humedad asignandole un id
	 * 
	 * @param id, id del sensor
	 */
	public HumiditySensor(int id) {
		this.id=id;
	}
	
	/**
	 * Método que devuelve la humedad detectada por el sensor
	 * 
	 * @return humedad, valor de la humedad
	 */
	public int getHumidity() {
		return new Random().nextInt(100);
	}
	
	/**
	 * Método que devuelve los datos del sensor
	 */
	public String toString() {
		return "HumiditySensor [id=" + id + "]";
	}
	
	/**
	 * Método que checkea el estado de la puerta
	 * 
	 * @return true o false si la puerta esta estropeada
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
