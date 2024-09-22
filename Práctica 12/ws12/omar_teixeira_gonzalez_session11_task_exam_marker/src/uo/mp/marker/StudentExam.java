package uo.mp.marker;

import java.util.ArrayList;
import java.util.List;

import uo.mp.marker.questions.Question;

/**
 * Titulo: Clase StudentExam
 * 
 * @author Omitg
 * @version 29-04-2021
 */
public class StudentExam {
	/**
	 * Atributo code
	 */
	private String code;
	/**
	 * Lista de respuestas
	 */
	List<String> answers = new ArrayList<>();
	
	/**
	 * Constructor con parametros de StudentExam
	 * @param studentCode, codigo del estudiante
	 */
	public StudentExam (String studentCode) {
		this.code = studentCode;
	}
	
	/**
	 * M�todo que devuelve el estudiante
	 * 
	 * @return code
	 */
	public String getStudent() {
		return code;
	}	
	
	/**
	 * M�todo que devuelve la respuesta a una pregunta
	 * 
	 * @param number, numero de la pregunta
	 * @return answer, respuesta
	 */
	public String getAnswerToQuestion(int number) {
		return answers.get(number);
	}
	
	/**
	 * M�todo que devuelve una cadena con las respuestas
	 * 
	 * @return msg 
	 */
	public String toString() {
		String msg = "StudentCode: " + getStudent();		
		for (int i=0; i<answers.size(); i++) {
			msg = msg + " " + answers.get(i);
		}
		return msg;
	}
	
	/**
	 * M�todo que a�ade una respuesta
	 * 
	 * @param string, respuesta
	 */
	public void addAnswer(String string) {
		answers.add(string);
	}
	
	/**
	 * M�todo que devuelve la nota del examen
	 * 
	 * @param questions, preguntas 
	 * @return mark, nota del examen
	 */
	public double mark(List<Question> questions) {
		double mark=0.0;
		for (int i=0; i<questions.size(); i++) {
			mark=mark+(questions.get(i).getMarkForAnswer(answers.get(i)));
		}
		return mark;
	}
}
