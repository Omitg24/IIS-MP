package uo.mp.s6.greenhouse.scanner;

import java.util.ArrayList;
import java.util.List;

/**
 * Titulo: Clase Scanner
 * 
 * @author Omitg
 * @version 18-03-2021
 */
public class Scanner {
	/**
	 * Atributo lista de devices checkeables	
	 */
	private List<Checkable> devices = new ArrayList<>();
	
	/**
	 * M�todo que a�ade dispositivos
	 * 
	 * @param device, dispositivo a a�adir
	 */
	public void add(Checkable device) {
		devices.add(device);
	}
	
	/**
	 * M�todo que scanea los dispositivos en la lista
	 */
	public void scan() {
		for (Checkable device : devices) {
			if (!device.check()) {
				System.out.println("ATENCI�N. El dispositivo " + device.toString() +" est� estropeado");
			}
		}
	}
}

