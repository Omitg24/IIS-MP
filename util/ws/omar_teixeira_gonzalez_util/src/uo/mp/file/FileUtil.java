package uo.mp.file;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.LinkedList;
import java.util.List;

import uo.mp.checks.ArgumentChecks;

/**
 * Titulo: Clase FileUtil
 * 
 * @author Omitg
 * @version 07-05-2021
 */
public abstract class FileUtil {
	/**
	 * Método que devuelve el flujo donde leer
	 * 
	 * @param inFileName, fichero del que leer
	 * @return fujo
	 * @throws FileNotFoundException
	 */
	protected abstract BufferedReader bufferedReaderFor(String inFileName)
		throws FileNotFoundException;
	
	/**
	 * Método que devuelve el flujo donde escribir
	 * 
	 * @param outFileName, fichero en el que escribir
	 * @return flujo
	 * @throws IOException
	 */
	protected abstract BufferedWriter bufferedWriterFor(String outFileName)
		throws IOException;
	
	/**
	 * Método que lee las lineas de un fichero
	 * 
	 * @param inFileName, lineas del fichero
	 * @return lista de strings
	 * @throws FileNotFoundException
	 */
	public List<String> readLines(String inFileName) throws FileNotFoundException {
		ArgumentChecks.isNotEmpty(inFileName);
		
		BufferedReader in = bufferedReaderFor(inFileName);
		try {
			try {
				List<String> res = new LinkedList<>();
				String line;
				while ((line = in.readLine())!=null) {
					res.add(line);
				}
				return res;
			} finally {
				in.close();
			}
		} catch (IOException e) {
			throw new RuntimeException(e);
		}
	}
	
	/**
	 * Método que escribe nuevas lineas en el fichero
	 * 
	 * @param outFileName, nombre del fichero
	 * @param lines,       lista de lineas
	 */
	public void saveToFile(String outFileName, List<String> lines) {
		ArgumentChecks.isNotEmpty(outFileName);
		ArgumentChecks.isNotNull(lines);
		
		try {
			BufferedWriter out = bufferedWriterFor(outFileName);
			try {
				for (String line : lines) {
					out.write(line);
					out.newLine();
				}
			} finally {
				out.close();
			}
		} catch (IOException e) {
			throw new RuntimeException (e);
		}
	}
}