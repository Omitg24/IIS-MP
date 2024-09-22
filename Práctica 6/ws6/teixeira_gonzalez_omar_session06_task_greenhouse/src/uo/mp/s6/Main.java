package uo.mp.s6;

import uo.mp.s6.greenhouse.GreenhouseController;
import uo.mp.s6.greenhouse.humidity.HumiditySensor;
import uo.mp.s6.greenhouse.temperature.AutomaticDoor;
import uo.mp.s6.greenhouse.temperature.ManualDoor;
import uo.mp.s6.greenhouse.temperature.TemperatureSensor;

/**
 * <p>Title: Main</p>
 * <p>Description: Clase que ejecuta el programa.</p>
 * <p>Copyright: Copyright (c) 2020</p>
 * <p>Escuela de Ingeniería Informática</p>
 * <p>Metodología de la Programación</p>
 * 
 * @author 	Omitg
 * @version 18-03-2021
 */
public class Main {
	/**
	 * Atributo controlador del invernadero
	 */
	private GreenhouseController greenhouse;

	/**
	 * Método principal que lanza la aplicación
	 * 
	 * @param args, argumento a analizar
	 */
	public static void main(String[] args) {
		new Main()
			.configure()
			.run();
	}
	
	/**
	 * Método que configura la aplicación
	 * 
	 * @return this, main configurado
	 */
	private Main configure() {
		System.out.println("-------------------------- GreenHouse --------------------------\n");
		greenhouse = new GreenhouseController();
		
		for (int i = 0; i < 10; i++) {
			greenhouse.add( new TemperatureSensor(i) );
			greenhouse.add( new HumiditySensor(i) );
			greenhouse.add( new ManualDoor(i) );
			greenhouse.add( new AutomaticDoor(i) );			
		}

		return this;
	}

	/**
	 * Método que ejecuta la aplicación
	 */
	public void run() {
		greenhouse.start();
	}

}
