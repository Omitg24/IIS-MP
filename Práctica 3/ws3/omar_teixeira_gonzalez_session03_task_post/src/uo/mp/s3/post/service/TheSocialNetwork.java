package uo.mp.s3.post.service;

import java.io.PrintStream;
import java.util.ArrayList;

import uo.mp.s3.post.model.Post;
import uo.mp.util.checks.ArgumentsCheck;

/**
 * Titulo: Clase TheSocialNetwork
 * 
 * @author Omitg
 * @version 20-02-2021
 */
public class TheSocialNetwork {
//Atributos:
	/**
	 * Lista de posts
	 */
	private ArrayList<Post> posts = new ArrayList<Post>();
	
	/**
	 * M�todo que a�ade posts a la red social, el post no puede ser null
	 * 
	 * @param post, post a a�adir a la red social
	 */
	public void addPost(Post post) {
		ArgumentsCheck.isTrue(post!=null, "El post no cumple las normas de TheSocialNetwork");
		posts.add(post);
	}
	
	/**
	 * M�todo que imprime la lista de post presentes en la red social con un formato predefinido
	 * 
	 * @param out, lugar donde se imprimira el post, de tipo PrintStream
	 */
	public void print(PrintStream out) {
		for (Post post : posts) {
			post.print(out);
		}
	}
	
	/**
	 * M�todo que pasado un usuario como par�metro devuelve una lista con todos los posts que este 
	 * tiene; en caso de haber publicado al menos uno.
	 * 
	 * @param userId, usuario del que se van a buscar sus posts, de tipo String
	 * @return userPosts, lista con los posts del usuario.
	 */
	public ArrayList<Post> findPostsByUser(String userId){
		ArgumentsCheck.isTrue(userId!=null && !userId.trim().isEmpty(), "El usuario a buscar no cumple los requisitos");
		ArrayList<Post> userPosts = new ArrayList<Post>();
		for (Post post : posts) {
			if (post.getUser()==userId) {
				userPosts.add(post);
			}
		}			
		return userPosts;
	}
	
	/**
	 * M�todo que devuelve el numero de posts que hay en la lista
	 * 
	 * @return count, cuenta del numero de posts que hay en la lista
	 */
	public int getNumberOfPosts() {
		int count=0;
		for (Post post : posts) {
			if (post!=null) {
				count++;
			}
		}
		return count;
	}
}