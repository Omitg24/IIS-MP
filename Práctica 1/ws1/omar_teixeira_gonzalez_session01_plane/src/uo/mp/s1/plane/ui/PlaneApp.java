/**
 * 
 */
package uo.mp.s1.plane.ui;

import uo.mp.s1.plane.model.Person;
import uo.mp.s1.plane.model.Plane;

/**
 * @author Omitg
 *
 */
public class PlaneApp {

	/**
	 * @param args
	 */
	public void run() {
		Person piloto= new Person ("Pepe", 45);
		Plane myPlane = new Plane(piloto,'X',2000);
		System.out.println(myPlane.toString());

	}

}
