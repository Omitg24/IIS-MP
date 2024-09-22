package uo.mp;

import java.io.IOException;
import java.util.List;

import uo.mp.log.Logger;
import uo.mp.marker.ExamMarker;
import uo.mp.marker.StudentExam;
import uo.mp.marker.StudentMark;
import uo.mp.marker.questions.Question;

/**
 * Titulo: Clase Main
 * 
 * @author Omitg
 * @version 22-04-2021
 */
public class Main {
	/**
	 * Constante modelo de examen
	 */
	private static final String EXAM_MODEL_FILE = "questions.txt";
	/**
	 * Constante respuestas
	 */
	private static final String ANSWERS_FILE = "exams.txt.gz";
	/**
	 * Constante resultados
	 */
	private static final String RESULTS_FILE = "marks.txt";

	/**
	 * Método que lanza el programa
	 * 
	 * @param args, argumento a analizar
	 */
	public static void main(String[] args) {
		new Main().run();
	}

	/**
	 * Método que corre el programa
	 */
	private void run() {
		try {
			simulateScenario();
		} catch (IOException e) {
			Logger.log(e.getMessage());
		}
		// add default exception handlers here
	}

	/**
	 * There is no user interface for this small program. This method
	 * simulates an example scenario of use.
	 * @throws IOException 
	 */
	private void simulateScenario() throws IOException {
		ExamMarker ex = new ExamMarker();
		ex.loadQuestions( EXAM_MODEL_FILE );
		showQuestions(ex.getQuestions());
		ex.loadStudentExams( ANSWERS_FILE );
		showExams(ex.getExams());

		ex.mark();

		showMarks(ex.getMarksByMark());
		showMarks(ex.getMarksByStudent());
		ex.saveResults( RESULTS_FILE );
	}
	
	/**
	 * Método que muestra las preguntas
	 * 
	 * @param questions, preguntas
	 */
	private void showQuestions(List<Question> questions) {
		System.out.println("---------------------------------------------");
		System.out.println("List of questions");
		for(Question q: questions) {
			System.out.println( q.toString() );
		}
	}
	
	/**
	 * Método que muestra los examenes
	 * 
	 * @param exams, examenes
	 */
	private void showExams(List<StudentExam> exams) {
		System.out.println("---------------------------------------------");
		System.out.println("List of exams");
		for(StudentExam se: exams) {
			System.out.println( se.toString() );
		}
	}
	
	/**
	 * Método que muestra las notas
	 * 
	 * @param marks, notas
	 */
	private void showMarks(List<StudentMark> marks) {
		System.out.println("---------------------------------------------");
		System.out.println("List of marks");
		for(StudentMark mark: marks) {
			System.out.println(mark.getStudent() + " " + mark.getValue());
		}
	}

}
