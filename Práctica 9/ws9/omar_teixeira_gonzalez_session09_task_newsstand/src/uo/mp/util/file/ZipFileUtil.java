package uo.mp.util.file;

import java.util.List;

import uo.mp.exception.NotYetImplementedException;

/**
 * Titulo: Clase ZipFileUtil
 * 
 * A utility class to read/write text lines 
 * from/to a compressed text file (.txt.gz)
 * 
 * @author Omitg
 * @version 07-04-2021
 */
public class ZipFileUtil {
	
	/**
	 * Método que lee lineas del zip
	 * 
	 * @param inFileName, nombre del zip
	 * @return lista de strings con el contenido del zip
	 */
	public List<String> readLines(String inFileName) {
		throw new NotYetImplementedException();
	}
	
	/**
	 * Método que escribe lineas en el zip
	 * 
	 * @param outZippedFileName, nombre del zip
	 * @param lines, lista de lineas
	 */
	public void writeLines(String outZippedFileName, List<String> lines) {
		throw new NotYetImplementedException();
	}

}
