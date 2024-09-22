package uo.mp.file;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

/**
 * Titulo: Clase FIleUtil
 * 
 * A utility class to read/write text lines from/to a text file
 * 
 * @author Omitg
 * @version 07-05-2021
 */
public class TxtFileUtil extends FileUtil{
	
	/**
	 * Método que devuelve el flujo donde leer
	 * 
	 * @param inFileName, fichero del que leer
	 * @return fujo
	 * @throws FileNotFoundException
	 */
	@Override
	protected BufferedReader bufferedReaderFor(String inFileName) throws FileNotFoundException {
		return new BufferedReader(new FileReader(inFileName));
	}
	
	/**
	 * Método que devuelve el flujo donde escribir
	 * 
	 * @param outFileName, fichero en el que escribir
	 * @return flujo
	 * @throws IOException
	 */
	@Override
	protected BufferedWriter bufferedWriterFor(String outFileName) throws IOException {		
		return new BufferedWriter(new FileWriter(outFileName));
	}
}
