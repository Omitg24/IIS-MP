package uo.mp.s2.seatmanager.ui;

import uo.mp.s2.seatmanager.model.Person;
import uo.mp.s2.seatmanager.model.SeatManager;

/**
 * <p>
 * T�tulo: Clase Aplication
 * </p>
 * Descripcion: 
 *
 * @author Omar Teixeira Gonz�lez
 * @version 13/02/2021
 */
public class Application {

//Prueba de que el programa est� correctamente realizado (invenci�n propia)
	/**
	 * Comprueba el correcto funcionamiento de los programas.
	 */
	public void run() {
		SeatManager seatManager = new SeatManager(10,4);		//Creaci�n de objetos
		Person child1 = new Person ("Mar�a", 2);
		Person adult1 = new Person ("Marta", 24);
		Person retired1 = new Person ("Jose", 78);
		Person child2 = new Person ("Pablo", 7);
		Person adult2 = new Person ("Andres", 20);
		Person retired2 = new Person ("Juan", 65);
		
		System.out.println("El array bidimensional es el siguiente:\n");		//Imprime por pantalla
		
		System.out.println(seatManager.toString());		//Imprime el array convertido en String a trav�s del m�todo toString
		
		System.out.println("\nEl array bidimensional est� vac�o\n");		//Imprime por pantalla
		System.out.println("Las siguientes personas se sentar�n:");
		
		System.out.println("\t-> "+child1.toString() + ". En la posici�n 5,1");		//Imprime por pantalla el toString de las personas y la posici�n en la que est�n
		System.out.println("\t-> "+adult1.toString()+ ". En la posici�n 6,2");
		System.out.println("\t-> "+retired1.toString()+ ". En la posici�n 2,3");
		System.out.println("\t-> "+child2.toString()+ ". En la posici�n 2,0");
		System.out.println("\t-> "+adult2.toString()+ ". En la posici�n 4,1");
		System.out.println("\t-> "+retired2.toString()+ ". En la posici�n 8,2");
		
		seatManager.bookSeat(child1,5,1);		//Sentar a las personas mediante el m�todo bookSeat
		seatManager.bookSeat(adult1,6,2);
		seatManager.bookSeat(retired1,2,3);
		seatManager.bookSeat(child2,2,0);
		seatManager.bookSeat(adult2,4,1);
		seatManager.bookSeat(retired2,8,2);
		
		System.out.println("Una vez sentados los pasajeros, el array tiene el aspecto:\n");		//Imprime por pantalla
		System.out.println(seatManager.toString());		//Imprime el array convertido en String a trav�s del m�todo toString
		
		System.out.println("\nUna lista con los pasajeros entre 7 y 65 a�os ser�a la siguiente: ");		//Imprime por pantalla
		for (int i=0; i<seatManager.findPassengersByAge(7, 65).size();i++) {
			System.out.println("\t-> "+seatManager.findPassengersByAge(7, 65).get(i));		//Imprime por pantalla el array obtenido del m�todo findPassengersByAge
		}
	}	
}
