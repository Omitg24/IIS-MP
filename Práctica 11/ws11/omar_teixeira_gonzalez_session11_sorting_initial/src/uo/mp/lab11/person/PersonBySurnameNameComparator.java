package uo.mp.lab11.person;

import java.util.Comparator;

/**
 * Titulo: Clase PersonBySurnameNameComparator
 *  
 * @author Omitg
 * @version 22-04-2021
 */
public class PersonBySurnameNameComparator implements Comparator<Person>{
	
	/**
	 * Método que compara dos personas
	 * 
	 * @param o1, persona 1
	 * @param o2, persona 2
	 * @return dif, diferencia
	 */
	@Override
	public int compare(Person o1, Person o2) {
		int dif = o1.getSurname().compareTo(o2.getSurname());
		if (dif==0) {
			return o1.getName().compareTo(o2.getName());
		}
		return dif;
	}	
}
