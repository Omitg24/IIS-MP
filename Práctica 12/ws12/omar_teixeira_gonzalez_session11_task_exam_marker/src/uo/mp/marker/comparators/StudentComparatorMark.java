package uo.mp.marker.comparators;

import java.util.Comparator;

import uo.mp.marker.StudentMark;

/**
 * Titulo: Clase StudentComparatorMark
 * 
 * @author Omitg
 * @version 29-04-2021
 */
public class StudentComparatorMark implements Comparator<StudentMark>{

	/**
	 * Método que compara dos estudiantes
	 * 
	 * @return dif, diferencia
	 */
	@Override
	public int compare(StudentMark o1, StudentMark o2) {
		int dif = o1.getStudent().compareTo(o2.getStudent()); 
		return dif;
	}	
}
