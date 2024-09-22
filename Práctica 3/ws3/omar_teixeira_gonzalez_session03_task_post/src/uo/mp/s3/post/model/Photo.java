package uo.mp.s3.post.model;

import java.io.PrintStream;

import uo.mp.util.checks.ArgumentsCheck;

/**
 * Titulo: Clase Photo
 * 
 * @author Omitg
 * @version 20-02-2021
 */
public class Photo extends Post {
	/**
	 * Atributo file, fichero donde se almacena la foto
	 */
	private String file;
	
	/**
	 * Constructor con par�metros de la clase Message
	 * 
	 * @param user, usuario que publico la foto, de tipo String
	 * @param file, fichero donde se almacena la foto, de tipo String
	 */
	public Photo(String user, String file) {
		super(user);
		ArgumentsCheck.isTrue(file!=null && !file.trim().isEmpty(), "El fichero no cumple los requisitos");
		setFile(file);		
	}
	
	/**
	 * M�todo que devuelve el valor del atributo file
	 * 
	 * @return file, fichero donde se almacena la foto, de tipo String
	 */
	public String getFile() {
		return file;
	}
	
	/**
	 * M�todo que modifica el valor del atributo file
	 * 
	 * @param file, fichero donde se almacena la foto, de tipo String
	 */
	private void setFile(String file) {
		this.file = file;
	}
	
	/**
	 * M�todo que imprime los datos de la foto, por ejemplo: User, File, Likes, Comentarios.
	 * 
	 * @param out, lugar donde imprimir los datos, de tipo PrintStream
	 */
	public void print(PrintStream out) {
		out.println(toString());
	}
	
	/**
	 * M�todo que devuelve varios datos de la foto
	 * 
	 * @return	datos de la foto
	 */
	public String toString() {
		return "Photo --> User: " + getUser() + " | File: " + getFile() 
		+ "\n\t | Likes: " + getLikes() + " | Comments: " + getComments();
	}
}
