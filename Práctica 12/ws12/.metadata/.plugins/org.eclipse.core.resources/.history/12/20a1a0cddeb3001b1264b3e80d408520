package uo.mp;

import java.io.IOException;
import java.util.List;

import uo.mp.marker.ExamMarker;
import uo.mp.marker.StudentExam;
import uo.mp.marker.StudentMark;
import uo.mp.marker.questions.Question;

/**
 * Titulo: Clase Main
 * 
 * @author Omitg
 * @version 29-04-2021
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
	private static final String RESULTS_FILE = "results.txt";

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
		} catch (RuntimeException e) {
			handleSystemError(e);
		} catch (Exception e) {
			handleUserError(e);
		}
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
		
		showExams(ex.getExamsByUO());
		
		ex.mark();
		
		showMarks(ex.getMarksByMark());
		showMarks(ex.getMarksByStudent());
		
		ex.saveResults( RESULTS_FILE );
	}
	
	/**
	 * Método que maneja el error de usuario
	 * 
	 * @param e, excepcion
	 */
	private void handleUserError(Exception e) {
		String msg = "There has been an error processing you request. "
					+ e.getMessage() 
					+ "\nPlease review the input data and try it again";
		System.out.println(msg);
	}

	/**
	 * Método que maneja el error del sistema
	 * 
	 * @param e, excepcion
	 */
	private void handleSystemError(RuntimeException e) {
		String msg = "There has been a system processing you request. " 
				+ e.getMessage() 
				+ "\nThe program must finish. " 
				+ "Please contact your system administrator";
		System.out.println(msg);
		e.printStackTrace();
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
