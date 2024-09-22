package uo.mp.marker;

/**
 * Titulo: Clase StudentMark
 * 
 * @author Omitg
 * @version 22-04-2021
 */
public class StudentMark {
	/**
	 * Atributo student
	 */
	protected String student;
	
	/**
	 * Atributo value
	 */
	protected double value;
	
	/**
	 * Constructor con parametros de StudentMark
	 * 
	 * @param student, estudiante
	 * @param value, valor
	 */
	public StudentMark(String student, double value) {
		this.student = student;
		this.value = value;
	}

	/**
	 * Método que devuelve el estudiante
	 * 
	 * @return student
	 */
	public String getStudent() {				
		return student;
	}

	/**
	 * Método que devuelve el valor
	 * 
	 * @return value
	 */
	public double getValue() {
		return value;
	}
	
	/**
	 * Método que serializa el estudiante y su nota
	 * 
	 * @return String, serializado
	 */
	public String serialize() {		
		return "Student" + getStudent() + ", value" + getValue();
	}
}