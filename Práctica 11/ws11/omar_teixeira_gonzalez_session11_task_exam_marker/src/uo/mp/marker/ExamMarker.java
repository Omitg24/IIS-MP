package uo.mp.marker;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import luo.mp.lab11.sorting.Collections;
import uo.mp.marker.comparators.MarkComparator;
import uo.mp.marker.comparators.StudentComparator;
import uo.mp.marker.parser.QuestionParser;
import uo.mp.marker.parser.StudentParser;
import uo.mp.marker.questions.Question;
import uo.mp.marker.serializer.MarkSerializer;
import uo.mp.file.FileUtil;
import uo.mp.file.ZipFileUtil;

/**
 * Titulo: Clase ExamMarker
 * 
 * @author Omitg
 * @version 22-04-2021
 */
public class ExamMarker{
	/**
	 * Lista de preguntas
	 */
	private List<Question> questions = new ArrayList<>();
	/**
	 * Lista de respuestas
	 */
	private List<StudentExam> studentExams = new ArrayList<>();
	/**
	 * Lista de notas
	 */
	private List<StudentMark> marks = new ArrayList<>();

	/**
	 * M�todo que carga las preguntas
	 * 
	 * @param examModelFileName, fichero con las preguntas
	 * @throws FileNotFoundException
	 */
	public void loadQuestions(String examModelFileName) throws FileNotFoundException {
		List<String> lines = new FileUtil().readLines(examModelFileName);
		List<Question> questions = new QuestionParser().parse( lines );
		addQuestions(questions);
	}

	/**
	 * M�todo que a�ade preguntas
	 * 
	 * @param questions, preguntas a a�adir
	 */
	private void addQuestions(List<Question> questionsToAdd) {
		for (int i=0; i<questionsToAdd.size(); i++) {
			questions.add(questionsToAdd.get(i));
		}
	}

	/**
	 * M�todo que carga las respuestas
	 * 
	 * @param answersFileName, fichero con las respuestas
	 * @throws FileNotFoundException
	 * @throws IOException
	 */
	public void loadStudentExams(String answersFileName) throws FileNotFoundException, IOException {
		List<String> lines = new ZipFileUtil().readLines( answersFileName );
		List<StudentExam> exams = new StudentParser().parse( lines );
		addExams( exams );
	}

	/**
	 * M�todo que a�ade examenes
	 * 
	 * @param exams, examenes a a�adir
	 */
	private void addExams(List<StudentExam> exams) {
		for (int i=0; i<exams.size(); i++) {
			studentExams.add(exams.get(i));
		}
	}

	/**
	 * M�todo que ordena las notas por estudiante
	 * 
	 * @return mark, lista ordenada
	 */
	public List<StudentMark> getMarksByStudent() {
		Collections.sort(marks, new StudentComparator());		
		return marks;
	}

	/**
	 * M�todo que ordena las notas por nota
	 * 
	 * @return mark, lista ordenada
	 */
	public List<StudentMark> getMarksByMark() {
		Collections.sort(marks, new MarkComparator());
		return marks;
	}

	/**
	 * M�todo que devuelve la nota de cada alumno en una lista
	 */
	public void mark() {
		for (int i=0;i<studentExams.size();i++) {			
			for (Question quest : questions) {
				marks.add(new StudentMark(studentExams.get(i).getStudent(), 
						quest.getMarkForAnswer(studentExams.get(i).getStudent())));
			}			 
		}
	}
	
	/**
	 * M�todo que guarda los resultados en un fichero
	 * 
	 * @param resultsFileName, fichero donde escribir
	 */
	public void saveResults(String resultsFileName) {
		List<StudentMark> marks = getMarks();
		List<String> lines = new MarkSerializer().serialize(marks);
		new FileUtil().writeLines(resultsFileName, lines);
	}

	/**
	 * M�todo que devuelve las notas
	 * 
	 * @return marks
	 */
	private List<StudentMark> getMarks() {
		return new ArrayList<>(marks);
	}

	/**
	 * M�todo que devuelve los examenes
	 * 
	 * @return studentExams
	 */
	public List<StudentExam> getExams() {
		return new ArrayList<>(studentExams);
	}
	
	/**
	 * M�todo que devuelve las preguntas
	 * 
	 * @return questions
	 */
	public List<Question> getQuestions() {
		return new ArrayList<>(questions);
	}

}
