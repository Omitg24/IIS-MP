package uo.mp.util.file;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.LinkedList;
import java.util.List;


/**
 * Titulo: Clase FIleUtil
 * 
 * A utility class to read/write text lines from/to a text file
 * 
 * @author Omitg
 * @version 07-04-2021
 */
public class FileUtil {
	
	/**
	 * M�todo que lee las lineas de un fichero
	 * 
	 * @param inFileName, lineas del fichero 
	 * @return lista de strings
	 * @throws FileNotFoundException
	 */
	public List<String> readLines(String inFileName) throws FileNotFoundException {
		List<String> res = new LinkedList<>();
		
		BufferedReader in = new BufferedReader(new FileReader(inFileName));
		
		try {
			try {
				while(in.ready()) {
					String line = in.readLine();
					res.add(line);
				}
			} finally {
				in.close();
			}
		} catch (IOException e) {
			throw new RuntimeException("Error en lectura de datos");
		}
		
		return res;
	}
	
	/**
	 * M�todo que escribe nuevas lineas en el fichero
	 * 
	 * @param outFileName, nombre del fichero
	 * @param lines, lista de lineas
	 */
	public void writeLines(String outFileName, List<String> lines) {		
		try {
			BufferedWriter out = new BufferedWriter(new FileWriter(outFileName));
			try {
				for (String line : lines) {
					out.write(line);
					out.newLine();
				}
			} finally {
				out.close();
			}
		} catch (IOException e) {
			throw new RuntimeException("Error en escritura de datos");
		}
	}

}
