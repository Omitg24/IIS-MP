package uo.mp.s6.greenhouse.temperature;

import java.util.ArrayList;
import java.util.List;

/**
 * <p>Title: TemperatureController</p>
 * <p>Description: Clase para realizar el control de la temperatura.</p>
 * <p>Copyright: Copyright (c) 2020</p>
 * <p>Escuela de Ingenier�a Inform�tica</p>
 * <p>Metodolog�a de la Programaci�n</p>
 * 
 * @author Profesores de Metodolog�a de la Programaci�n
 * @version 1.0
 */
public class TemperatureController {
	/**
	 * Constantes temperatura m�xima y m�nima
	 */
	public static final double MAX_TEMPERATURE = 22, MIN_TEMPERATURE = 19;
		
	/**
	 * Lista de sensores de temperatura
	 */
	private List<TemperatureSensor> sensors = new ArrayList<>();
	/**
	 * Lista de puertas
	 */
	private List<Doorable> doors = new ArrayList<>();
		
	/**
	 * M�todo que a�ade sensores de temperatura
	 * 
	 * @param sensor, sensor de temperatura a a�adir
	 */
	public void add(TemperatureSensor sensor) {
		this.sensors.add(sensor);
	}
	
	/**
	 * M�todo que a�ade puertas a la lista
	 * 
	 * @param door, puerta a a�adir
	 */
	public void add(Doorable door) {
		this.doors.add(door);
	}

	/**
	 * Maneja las puertas para mantener la temperatura bajo control
	 */
	public void monitor() {		
		/*
		 * Fuera hace fr�o, por lo que la apertura de las puertas siempre implica enfriar el interior.
		 * 
		 * Cuando getAverageTemperature() es mayor que MAX_TEMPERATURE) 
			� Deber�an abrirse algunas puertas para bajar la temperatura (si es posible)
			� Cada grado de diferencia (getAverageTemperature()-MAX_TEMPERATURE)) 
			     implica la apertura del 10% de las puertas (si es posible)
			� Mostrar un mensaje que indique cu�ntas puertas est�n a punto de abrirse (si es posible)
		 * 
		 Cuando getAverageTemperature() es menor que MIN_TEMPERATURE 
			� Deber�an cerrarse algunas puertas para aumentar la temperatura (si es posible)
			� Cada grado de diferencia (MIN_TEMPERATURE-getAverageTemperature()) 
			     implica el cierre del 10% de las puertas (si es posible)
			� Mostrar un mensaje que indique cu�ntas puertas est�n a punto de cerrarse (si es posible)
		 *
		 * En caso contrario, se mostrar� un mensaje  que indique simplemente la temperatura media
		 */
		double temp = getAverageTemperature();
		if (temp > MAX_TEMPERATURE) {
			coolDown(temp);
		} else if (temp < MIN_TEMPERATURE){
			warmUp (temp);
		} else {
			doNothing();
		}
	}
	
	/**
	 * M�todo que enfr�a el invernadero
	 * 
	 * @param temp, temperatura a enfriar
	 */
	private void coolDown(double temp) {
		double diff = temp - MAX_TEMPERATURE;
		int doorsPerDegree = (int) (doors.size()*0.1);
		int doorsToOpen = (int) (doorsPerDegree * diff);
		System.out.println(" " + doorsToOpen + " puertas necesitan ser abiertas");
		openDoors(doorsToOpen);
	}
	
	/**
	 * M�todo que calienta el invernadero
	 * 
	 * @param temp, temperatura a calentar
	 */
	private void warmUp(double temp) {
		double diff = MIN_TEMPERATURE - temp;
		int doorsPerDegree = (int) (doors.size()*0.1);
		int doorsToClose = (int) (doorsPerDegree * diff);
		System.out.println(" " + doorsToClose + " puertas necesitan ser cerradas");
		closeDoors(doorsToClose);
	}
	
	/**
	 * M�todo que no hace nada porque la temperatura ya es correcta
	 */
	private void doNothing() {		
		System.out.println(" La temperatura " + getAverageTemperature() + " es correcta");
	}
	
	/**
	 * M�todo que abre un numero de puertas
	 * 
	 * @param doorsToOpen, numero de puertas a abrir
	 */
	private void openDoors(int doorsToOpen) { 
		int count=0;
		for (int i=0; count < doorsToOpen && i < doors.size();i++) {
			if (!doors.get(i).isOpened()) {
				doors.get(i).open();
				count++;
			}
		}
		if (count < doorsToOpen) {
			System.out.println("ATENCI�N. No hay mas puertas para abrir");
		}
	}
	
	/**
	 * M�todo que cierra un numero de puertas
	 * 
	 * @param doorsToClose, numero de puertas a cerrar
	 */
	private void closeDoors(int doorsToClose) {
		int count = 0;		
		for (int i=0; count < doorsToClose && i < doors.size();i++) {
			if (doors.get(i).isOpened()) {
				doors.get(i).close();
				count++;
			}
		}
		if (count < doorsToClose) {
			System.out.println("ATENCI�N. No hay mas puertas para cerrar");
		}
	}

	/**
	 * Calcula la temperatura media en el invernadero.
	 * 
	 * @return la temperatura media en el invernadero.
	 */
	private double getAverageTemperature() {
		double addition = 0;
		for(TemperatureSensor sensor : sensors) {
			addition += sensor.getTemperature();
		}
		return addition / sensors.size();
	}
}
