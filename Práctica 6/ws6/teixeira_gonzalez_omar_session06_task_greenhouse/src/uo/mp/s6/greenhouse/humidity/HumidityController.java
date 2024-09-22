package uo.mp.s6.greenhouse.humidity;

import java.util.ArrayList;
import java.util.List;

/**
 * Titulo: Clase HumidityController
 * 
 * @author Omitg
 * @version 18-03-2021
 */
public class HumidityController {
	/**
	 * Constantes humedad m�xima y m�nima
	 */
	public static final double MAX_HUMIDITY=70, MIN_HUMIDITY=20;
	/**
	 * Constantes posiciones del sistema de riego
	 */
	public static final int OFF = 1, LOW = 2, MEDIUM = 3, HIGH = 4;	
	/**
	 * Lista de sensores de humedad
	 */
	private List<HumiditySensor> sensors = new ArrayList<>();
	/**
	 * Estado del sistema de riego
	 */
	private int state;
	
	/**
	 * M�todo que a�ade sensores a la lista
	 * 
	 * @param sensor, sensor de humedad a a�adir
	 */
	public void add(HumiditySensor sensor) {
		this.sensors.add(sensor);
	}
	
	/**
	 * M�todo que monitorea el valor de la humedada en el invernadero
	 */
	public void monitor() {
		if (MAX_HUMIDITY>= getAverageHumidity() && MIN_HUMIDITY<=getAverageHumidity()) {
			doNothing();			
		} else if ((MAX_HUMIDITY*0.2)<getAverageHumidity()) {
			adjustToMin();
		} else if ((MIN_HUMIDITY*0.2)>getAverageHumidity()) {
			adjustToMax();
		} else if (MAX_HUMIDITY<getAverageHumidity()){
			decreaseState();
		} else if (MIN_HUMIDITY>getAverageHumidity()) {
			increaseState();
		}
	}
	
	/**
	 * M�todo que pasa la posici�n al m�nimo
	 */
	private void adjustToMin(){
		setState(OFF);
		System.out.println(" Sistema de riego: OFF");
	}
	
	/**
	 * M�todo que pasa la posici�n al m�ximo
	 */
	private void adjustToMax() {
		setState(HIGH);
		System.out.println(" Sistema de riego: HIGH");
	}
	
	/**
	 * M�todo que baja una posici�n del sistema de riego
	 */
	private void decreaseState() {
		if (getState()==HIGH) {
			setState(MEDIUM);
			System.out.println(" Sistema de riego: MEDIUM");
		} else if (getState()==MEDIUM) {
			setState(LOW);
			System.out.println(" Sistema de riego: LOW");
		} else if (getState()==LOW) {
			setState(OFF);
			System.out.println(" Sistema de riego: OFF");
		} else if(getState()==OFF) {
			setState(OFF);
			System.out.println(" Sistema de riego: OFF");
		}
	}
	
	/**
	 * M�todo que sube una posici�n del sistema de riego
	 */
	private void increaseState() {
		if (getState()==OFF) {
			setState(LOW);
			System.out.println(" Sistema de riego: LOW");
		} else if (getState()==LOW) {
			setState(MEDIUM);
			System.out.println(" Sistema de riego: MEDIUM");
		} else if (getState()==MEDIUM) {
			setState(HIGH);
			System.out.println(" Sistema de riego: HIGH");
		} else if(getState()==HIGH) {
			setState(HIGH);
			System.out.println(" Sistema de riego: HIGH");
		}
	}
	
	/**
	 * M�todo que imprime que la humedad es correcta
	 */
	private void doNothing() {
		System.out.println(" La humedad " + getAverageHumidity() + " es correcta");		
	}
	
	/**
	 * M�todo que calcula la media de la humedad
	 * 
	 * @return media de la humedad
	 */
	private double getAverageHumidity() {
		double addition = 0;
		for(HumiditySensor sensor : sensors) {
			addition += sensor.getHumidity();
		}
		return addition / sensors.size();
	}
	
	/**
	 * M�todo modific el valor del atributo state
	 * 
	 * @param state, estado del sistema de riega
	 */
	private void setState(int state) {
		if (state==OFF || state == LOW || state == MEDIUM || state == HIGH) {
			this.state=state;
		}
	}
	
	/**
	 * M�todo que devuelve el valor del atributo state
	 * 
	 * @return state, estado del sistema de riego
	 */
	public int getState() {
		return state;
	}
}
