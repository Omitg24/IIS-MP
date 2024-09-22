package uo.mp.marker.comparators;

import java.util.Comparator;

import uo.mp.marker.StudentMark;

/**
 * Titulo: Clase MarkComparator
 * 
 * @author Omitg
 * @version 22-04-2021
 */
public class MarkComparator implements Comparator<StudentMark>{
	
	/**
	 * Método que compara la nota de dos estudiantes
	 * 
	 * @return dif, diferencia
	 */
	@Override
	public int compare(StudentMark o1, StudentMark o2) {
		int dif = (int) (o1.getValue()-o2.getValue());
		return dif;
	}

}
