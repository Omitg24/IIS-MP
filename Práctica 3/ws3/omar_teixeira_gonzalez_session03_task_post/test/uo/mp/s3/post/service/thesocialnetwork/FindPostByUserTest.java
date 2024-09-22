package uo.mp.s3.post.service.thesocialnetwork;

import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;

import uo.mp.s3.post.model.Message;
import uo.mp.s3.post.model.Photo;
import uo.mp.s3.post.model.Post;
import uo.mp.s3.post.service.TheSocialNetwork;

/**
 * Titulo: Clase FindPostByUserTest
 * 
 * @author Omitg
 * @version 20-02-2021
 */
public class FindPostByUserTest {
	/**
	 * Atributo pic
	 */
	private Post pic1;
	
	/**
	 * Atributo pic
	 */
	private Post pic2;
	
	/**
	 * Atributo pic
	 */
	private Post pic3;
	
	/**
	 * Atributo pic
	 */	
	private Post pic4;
	
	/**
	 * Atributo pic
	 */
	private Post pic5;
	
	/**
	 * Atributo pic
	 */
	private Post pic6;
	
	/**
	 * Atributo msg
	 */
	private Post msg1;
	
	/**
	 * Atributo msg
	 */
	private Post msg2;
	
	/**
	 * Atributo msg
	 */
	private Post msg3;
	
	/**
	 * Atributo msg
	 */	
	private Post msg4;
	
	/**
	 * Atributo msg
	 */
	private Post msg5;
	
	/**
	 * Atributo network
	 */
	private TheSocialNetwork network;
	
	/**
	 * Creaci�n de atributos para su uso posterior
	 */
	@Before
	public void setUp() {
		network = new TheSocialNetwork();
		msg1 = new Message("Omitg�","Bienvenido a la Red Social");
		msg2 = new Message("ElPlayerHD","Aqui ver�s ejemplos de lo que es posible");
		msg3 = new Message("DaneonX","Y aun queda mucho m�s por venir");
		msg4 = new Message("Omitg�", "Atento a las novedades que se vienen!");
		msg5 = new Message("Diana1806","Esperamos satisfacer vuestras peticiones");
		pic1 =  new Photo ("PeacefulGoon39","AdminFile");
		pic2 = new Photo ("Omitg�", "CreatorFile");
		pic3 = new Photo ("ElPlayerHD", "PartnerFile");
		pic4 = new Photo ("DaneonX", "PartnerFile");
		pic5 = new Photo ("Sky00","AdminFile");
		pic6 = new Photo ("Diana1806","ManagerFile");		
		network.addPost(msg1);
		network.addPost(msg2);
		network.addPost(msg3);
		network.addPost(msg4);
		network.addPost(msg5);
		network.addPost(pic1);
		network.addPost(pic2);
		network.addPost(pic3);
		network.addPost(pic4);
		network.addPost(pic5);
		network.addPost(pic6);
	}
	
	/**
	 * Pruebas del m�todo findPostsByUser de la clase TheSocialNetwork:
	 * Pruebas de funcionalidad:
	 * 1- Se busca un usuario que tiene un unico post -> Devuelve una arrayList con un unico post
	 * 2- Se busca un usuario que tiene varios posts publicados1 -> Devuelve un arrayList con varios post	 * 
	 * 3- Se busca un usuario que no esta -> Devuelve un arrayList vac�o
	 * 
	 * Pruebas de robustez:
	 * 4- Se pasa como par�metro null -> Lanza la excepci�n
	 * 5- Se pasa como par�metro la palabra vac�a -> Lanza la excepci�n 
	 */
	
//Pruebas de funcionalidad:
	/**
	 * 1- Se busca un usuario que tiene un unico post -> Devuelve una arrayList con un unico post
	 * GIVEN Se crea una red social y varios posts
	 * WHEN Se a�aden a la lista y se busca todos los posts que ha hecho una persona
	 * THEN Se comprueba que se devuelve un arrayList con los post de esa persona, 
	 * en este caso, el tana�o de la misma es 1
	 */
	@Test
	public void testFindPostsByUserOne() {
		assertEquals(1,network.findPostsByUser("PeacefulGoon39").size());
	}
	
	/**
	 * 2- Se busca un usuario que tiene varios posts publicados1 -> Devuelve un arrayList con varios post	 *
	 * GIVEN Se crea una red social y varios posts
	 * WHEN Se a�aden a la lista y se busca todos los posts que ha hecho una persona
	 * THEN Se comprueba que se devuelve un arrayList con los post de esa persona, 
	 * en este caso, el tana�o de la misma es 3
	 */
	@Test
	public void testFindPostsByUserMany() {
		assertEquals(3,network.findPostsByUser("Omitg�").size());
	}
	
	/**
	 * 3- Se busca un usuario que no esta -> Devuelve un arrayList vac�o
	 * GIVEN Se crea una red social y varios posts
	 * WHEN Se a�aden a la lista y se busca todos los posts que ha hecho una persona
	 * THEN Se comprueba que se devuelve un arrayList con los post de esa persona, 
	 * en este caso, el usuario no tiene ningun post, por lo que el arrayList est� vac�o
	 */
	@Test
	public void testFindPostsByUserEmpty() {
		assertEquals(0,network.findPostsByUser("Vicatm").size());
	}
	
//Pruebas de robustez:	
	/**
	 * 4- Se pasa como par�metro null -> Lanza la excepci�n
	 * GIVEN Se crea una red social y varios posts
	 * WHEN Se a�aden a la lista y se busca null
	 * THEN Se lanza la excepci�n
	 */
	@Test
	(expected=IllegalArgumentException.class)
	public void testFindPostsByUserNull() {
		network.findPostsByUser(null);
	}
	
	/**
	 * 5- Se pasa como par�metro la palabra vac�a -> Lanza la excepci�n
	 * GIVEN Se crea una red social y varios posts
	 * WHEN Se a�aden a la lista y se busca palabra vac�a
	 * THEN Se lanza la excepci�n
	 */
	@Test
	(expected=IllegalArgumentException.class)
	public void testFindPostsByUserEmptyWord() {
		network.findPostsByUser("");
	}
}