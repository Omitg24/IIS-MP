package uo.mp.s4.post.model;

import java.io.PrintStream;

import uo.mp.util.checks.ArgumentsCheck;

/**
 * Titulo: Clase Message
 * 
 * @author Omitg
 * @version 20-02-2021
 */
public class Message extends Post {
//Atributos:
	/**
	 * Atributo mensaje
	 */
	private String msg;
	
	
	/**
	 * Constructor con par�metros de la clase Message
	 * 
	 * @param user, usuario que publico el mensaje, de tipo String
	 * @param msg, mensaje, de tipo String
	 */
	public Message(String user, String msg) {
		super(user);
		ArgumentsCheck.isTrue(msg!=null && !msg.trim().isEmpty(), "El mensaje no cumple los requisitos");
		setMessage(msg);		
	}
	
	/**
	 * M�todo que devuelve el valor del atributo msg
	 * 
	 * @return msg, mensaje que public� el usuario
	 */
	public String getMessage() {
		return msg;
	}
	
	/**
	 * M�todo que modifica el valor del atributo msg
	 * 
	 * @param msg, mensaje que public� el usuario, de tipo String
	 */
	private void setMessage(String msg) {
		this.msg = msg;
	}
	
	/**
	 * M�todo que imprime los datos del mensaje, por ejemplo: User, Mensaje, Likes, Comentarios.
	 * 
	 * @param out, lugar donde imprimir los datos, de tipo PrintStream
	 */
	public void print(PrintStream out) {
		out.println(toString());
	}
	
	/**
	 * M�todo que devuelve varios datos del mensaje
	 * 
	 * @return	datos del mensaje
	 */
	public String toString(){
		return "Message --> User: " + getUser() + " | msg: " + getMessage() 
		+ "\n\t | Likes: " + getLikes() + " | Comments: " + getComments();
	}

	/**
	 * M�todo que transforma los mensajes a formato HTML
	 * 
	 * @return HTML format of the message
	 */
	public String toHtmlFormat() {
		return "<p> " + getMessage() + " </p>";
	}
}