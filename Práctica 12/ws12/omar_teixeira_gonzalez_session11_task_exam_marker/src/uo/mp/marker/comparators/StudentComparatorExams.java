package uo.mp.marker.comparators;

import java.util.Comparator;

import uo.mp.marker.StudentExam;

/**
 * Titulo: Clase StudentComparatorExams
 * 
 * @author Omitg
 * @version 29-04-2021
 */
public class StudentComparatorExams implements Comparator<StudentExam>{

	/**
	 * Método que compara dos estudiantes
	 * 
	 * @return dif, diferencia
	 */
	@Override
	public int compare(StudentExam o1, StudentExam o2) {
		int dif = o1.getStudent().compareTo(o2.getStudent()); 
		return dif;
	}	
}
