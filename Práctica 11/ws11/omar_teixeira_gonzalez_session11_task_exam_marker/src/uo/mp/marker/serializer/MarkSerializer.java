package uo.mp.marker.serializer;

import java.util.LinkedList;
import java.util.List;

import uo.mp.marker.StudentMark;

/**
 * Titulo: Clase MarkSerializer
 * 
 * @author Omitg
 * @version 22-04-2021
 */
public class MarkSerializer {

	/**
	 * Método que serializa las notas
	 * 
	 * @param marks, notas
	 * @return res, lista con las notas serializadas
	 */
	public List<String> serialize(List<StudentMark> marks) {
		List<String> res = new LinkedList<>();
		for (StudentMark mark : marks) {
			res.add(mark.serialize());
		}
		return res;
	}

}
