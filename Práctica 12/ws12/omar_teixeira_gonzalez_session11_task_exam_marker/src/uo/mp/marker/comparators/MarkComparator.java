package uo.mp.marker.comparators;

import java.util.Comparator;

import uo.mp.marker.StudentMark;

/**
 * Titulo: Clase MarkComparator
 * 
 * @author Omitg
 * @version 29-04-2021
 */
public class MarkComparator implements Comparator<StudentMark>{
	
	/**
	 * Método que compara la nota de dos estudiantes
	 * 
	 * @return dif, diferencia
	 */
	@Override
	public int compare(StudentMark o1, StudentMark o2) {
		int dif = (int) ((o1.getValue()-o2.getValue())*1000);
		if (dif==0) {
			dif = o1.getStudent().compareTo(o2.getStudent());
		}
		return dif;
	}

}
