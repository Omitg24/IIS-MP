package uo.mp.s3.post.model;

import java.io.PrintStream;
import java.util.ArrayList;

import uo.mp.util.checks.ArgumentsCheck;

/**
 * Titulo: Clase Post
 * 
 * @author Omitg
 * @version 20-02-2021
 */
public class Post {
//Atributos:
	/**
	 * Atributo usuario, usuario que publica la foto
	 */
	private String user;
	
	/**
	 * Atributo likes, me gusta de la foto
	 */
	private int likes;
	
	/**
	 * Atributo comments, lista de comentarios
	 */
	private ArrayList<String> comments;
	
	/**
	 * Constructor sin par�metros de la clase Post, crea la superclase
	 */
	public Post() {
		super();
	}
	
	/**
	 * Constructor con par�metro de la clase Post, crea la superclase
	 * 
	 * @param user, usuario que public� la foto o el mensaje
	 */
	public Post(String user) {
		super();
		ArgumentsCheck.isTrue(user!=null && !user.trim().isEmpty(), "El usuario no respeta los requisitos");
		setUser(user);
		setLikes(0);
		setComments(new ArrayList<String>(0));
	}

	/**
	 * M�todo que devuelve el valor del atributo user
	 * 
	 * @return user, usuario que public� la foto o el mensaje
	 */
	public String getUser() {
		return user;
	}

	/**
	 * M�todo que modifica el valor del atributo user
	 * 
	 * @param user, usuario que public� la foto o el mensaje, de tipo String
	 */
	protected void setUser(String user) {
		this.user = user;
	}

	/**
	 * M�todo que devuelve el valor del atributo likes
	 * 
	 * @return likes, likes de la foto o el mensaje
	 */
	public int getLikes() {
		return likes;
	}

	/**
	 * M�todo que modifica el valor del atributo likes
	 * 
	 * @param likes, likes de la foto o el mensaje, de tipo int
	 */
	private void setLikes(int likes) {
		this.likes = likes;
	}

	/**
	 * M�todo que devuelve una lista con los comentarios
	 * 
	 * @return comments, lista de los comentarios de la foto o el mensaje
	 */
	public ArrayList<String> getComments() {
		return comments;
	}

	/**
	 * M�todo que modifica el valor del atributo comments
	 * 
	 * @param comments, lista de los comentarios de la foto o el mensaje, de tipo ArrayList<String>
	 */
	private void setComments(ArrayList<String> comments) {
		if (comments!=null) {
			this.comments = comments;
		}
	}
	
	/**
	 * M�todo que imprime el post introducido
	 * 
	 * @param out, lugar donde se imprimira el post, de tipo PrintStream
	 */
	public void print(PrintStream out) {
		// Vac�o (magia del polimorfismo)
	}
	
	/**
	 * M�todo que imprime todos los comentarios de las fotos o los mensajes
	 * 
	 * @param out, lugar donde se imprimira el post, de tipo PrintStream
	 */
	public void printComments(PrintStream out) {
		for (String comment : comments) {
			out.print(comment);
		}
	}
}