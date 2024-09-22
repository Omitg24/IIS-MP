package uo.mp.file;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.zip.GZIPInputStream;
import java.util.zip.GZIPOutputStream;

/**
 * Titulo: Clase ZipFileUtil
 * 
 * A utility class to read/write text lines from/to a compressed text file
 * (.txt.gz)
 * 
 * @author Omitg
 * @version 07-05-2021
 */
public class ZipFileUtil extends FileUtil{	
	
	/**
	 * Método que devuelve el flujo donde leer
	 * 
	 * @param inFileName, fichero del que leer
	 * @return fujo
	 * @throws FileNotFoundException
	 */
	@Override
	protected BufferedReader bufferedReaderFor(String inFileName) throws FileNotFoundException {
		try {
			return new BufferedReader(
					new InputStreamReader(
							new GZIPInputStream(
									new FileInputStream (inFileName))));
		} catch (FileNotFoundException e) {
			throw e;
		} catch (IOException e) {
			throw new RuntimeException(e);
		}
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
		try {
			return new BufferedWriter(
					new OutputStreamWriter(
							new GZIPOutputStream(
									new FileOutputStream(outFileName))));
		} catch (FileNotFoundException e) {
			throw e;
		} catch (IOException e) {
			throw new RuntimeException(e);
		}
	}

}
