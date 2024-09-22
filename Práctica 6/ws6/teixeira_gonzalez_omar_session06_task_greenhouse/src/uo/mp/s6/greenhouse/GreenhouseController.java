package uo.mp.s6.greenhouse;



import uo.mp.s6.greenhouse.humidity.HumidityController;
import uo.mp.s6.greenhouse.humidity.HumiditySensor;
import uo.mp.s6.greenhouse.scanner.Checkable;
import uo.mp.s6.greenhouse.scanner.Scanner;
import uo.mp.s6.greenhouse.temperature.AutomaticDoor;
import uo.mp.s6.greenhouse.temperature.Doorable;
import uo.mp.s6.greenhouse.temperature.TemperatureController;
import uo.mp.s6.greenhouse.temperature.TemperatureSensor;

/**
 * <p>Title: GreenHouseController</p>
 * <p>Description: Clase que simula al invernadero.</p>
 * <p>Copyright: Copyright (c) 2020</p>
 * <p>Escuela de Ingenier�a Inform�tica</p>
 * <p>Metodolog�a de la Programaci�n</p>
 * 
 * @author Omitg
 * @version 18-03-2021
 */
public class GreenhouseController {
	/**
	 * Objeto controlador de temperatura
	 */
	private TemperatureController tempCtrl = new TemperatureController();
	private HumidityController humCtrl = new HumidityController();
	private Scanner scanner= new Scanner();

	/**
	 * M�todo que a�ade un sensor de temperatura
	 * 
	 * @param sensor, sensor de temperatura
	 */
	public void add(TemperatureSensor sensor) {
		tempCtrl.add( sensor );
		scanner.add(sensor);		
	}

	/**
	 * M�todo que a�ade una puerta
	 * 
	 * @param door, puerta
	 */
	public void add(Doorable door) {
		tempCtrl.add( door );
		if (door instanceof AutomaticDoor) {
			scanner.add((Checkable) door);
		}
	}
	
	
	/**
	 * M�todo que a�ade un sensor de humedad al controlador y al escaner
	 * 
	 * @param sensor, sensor de humedad
	 */
	public void add(HumiditySensor sensor) {
		humCtrl.add(sensor);
		scanner.add(sensor);		
	}
	
	/**
	 * M�todo que empieza el monitoreo
	 */
	public void start() {
		while (true) {
			tempCtrl.monitor();
			scanner.scan();
			humCtrl.monitor();
			sleep(2000);
		}
	}

	/**
	 * M�todo que para la ejecuci�n
	 * 
	 * @param millis, valor para parar la ejecuci�n
	 */
	private void sleep(int millis) {
		try {
			Thread.sleep(millis);
		} catch (InterruptedException e) {
		}
	}

}
