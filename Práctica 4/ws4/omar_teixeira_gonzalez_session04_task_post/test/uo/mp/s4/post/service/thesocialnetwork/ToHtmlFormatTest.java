package uo.mp.s4.post.service.thesocialnetwork;

import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;

import uo.mp.s4.post.model.Message;
import uo.mp.s4.post.model.Photo;
import uo.mp.s4.post.service.TheSocialNetwork;

/**
 * Titulo: Clase ToHtmlFormatTest
 * 
 * @author Omitg
 * @version 26-02-2021
 */
public class ToHtmlFormatTest {
	
	/**
	 * Atributos message
	 */
	private Message msg1, msg2, msg3, msg4, msg5;
	
	/**
	 * Atributos photo
	 */
	private Photo pic1, pic2, pic3, pic4, pic5, pic6;
	
	/**
	 * Atributo network
	 */
	private TheSocialNetwork network;
	
	/**
	 * Creaci�n de objetos para su uso posterior
	 */
	@Before
	public void setUp() {
		network = new TheSocialNetwork();
		msg1 = new Message("Omitg�","Welcome to the Social Network");
		msg2 = new Message("ElPlayerHD","Here you'll see examples on what's to come!");
		msg3 = new Message("DaneonX","And there's a lot more that will follow");
		msg4 = new Message("Omitg�", "So pay attention to the news");
		msg5 = new Message("Diana1806","We hope to satify your petitions");
		pic1 =  new Photo ("PeacefulGoon39","AdminFile");
		pic2 = new Photo ("Omitg�", "CreatorFile");
		pic3 = new Photo ("ElPlayerHD", "PartnerFile");
		pic4 = new Photo ("DaneonX", "PartnerFile");
		pic5 = new Photo ("Sky00","AdminFile");
		pic6 = new Photo ("Diana1806","ManagerFile");
	}
	
	/**
	 * Pruebas del m�todo toHtmlFormat de la clase TheSocialNetwork:
	 * 1- Un mensaje
	 * 2- Una foto
	 * 3- Varios mensajes
	 * 4- Varias fotos
	 * 5- Muchos mensajes y fotos 
	 */
	
	/**
	 * 1- Un mensaje
	 * GIVEN Se crean varios post y la red social
	 * WHEN Se a�ade un post y se convierte a HTML
	 * THEN Se comprueba que el formato resultante es correcto
	 */
	@Test
	public void testHTMLMessage() {
		network.addPost(msg1);
		assertEquals(1,network.toHtmlFormat().size());
		assertEquals("<p> Welcome to the Social Network </p>", 
				network.toHtmlFormat().get(0));
	}
	
	/**
	 * 2- Una foto
	 * GIVEN Se crean varios post y la red social
	 * WHEN Se a�ade un post y se convierte a HTML
	 * THEN Se comprueba que el formato resultante es correcto
	 */
	@Test
	public void testHTMLPhoto() {
		network.addPost(pic1);
		assertEquals(1,network.toHtmlFormat().size());
		assertEquals("<img src= AdminFile> </img>", network.toHtmlFormat().get(0));
	}
	
	/**
	 * 3- Varios mensaje
	 * GIVEN Se crean varios post y la red social
	 * WHEN Se a�aden varios post y se convierten a HTML
	 * THEN Se comprueba que el formato resultante es correcto
	 */
	@Test
	public void testHTMLVariousMessage() {
		network.addPost(msg1);
		network.addPost(msg2);
		network.addPost(msg3);
		assertEquals(3,network.toHtmlFormat().size());
		assertEquals("<p> Welcome to the Social Network </p>", 
				network.toHtmlFormat().get(0));
		assertEquals("<p> Here you'll see examples on what's to come! </p>", 
				network.toHtmlFormat().get(1));
		assertEquals("<p> And there's a lot more that will follow </p>", 
				network.toHtmlFormat().get(2));
		
	}
	
	/**
	 * 4- Varias fotos
	 * GIVEN Se crean varios post y la red social
	 * WHEN Se a�aden varios post y se convierten a HTML
	 * THEN Se comprueba que el formato resultante es correcto
	 */
	@Test
	public void testHTMLVariousPhoto() {
		network.addPost(pic1);
		network.addPost(pic2);
		network.addPost(pic3);
		assertEquals(3,network.toHtmlFormat().size());
		assertEquals("<img src= AdminFile> </img>", 
				network.toHtmlFormat().get(0));
		assertEquals("<img src= CreatorFile> </img>", 
				network.toHtmlFormat().get(1));
		assertEquals("<img src= PartnerFile> </img>", 
				network.toHtmlFormat().get(2));
		
	}
	
	/**
	 * 5- Muchos mensajes y fotos 
	 * GIVEN Se crean varios post y la red social
	 * WHEN Se a�aden todos los post y se convierten a HTML
	 * THEN Se comprueba que el formato resultante es correcto
	 */
	@Test
	public void testHTMLAllPosts() {
		network.addPost(msg1);
		network.addPost(pic1);
		network.addPost(msg2);
		network.addPost(pic2);
		network.addPost(msg3);
		network.addPost(pic3);
		network.addPost(msg4);
		network.addPost(pic4);
		network.addPost(msg5);
		network.addPost(pic5);
		network.addPost(pic6);
		assertEquals(11,network.toHtmlFormat().size());
		assertEquals("<p> Welcome to the Social Network </p>", 
				network.toHtmlFormat().get(0));
		assertEquals("<img src= AdminFile> </img>", 
				network.toHtmlFormat().get(1));
		assertEquals("<p> Here you'll see examples on what's to come! </p>", 
				network.toHtmlFormat().get(2));
		assertEquals("<img src= CreatorFile> </img>", 
				network.toHtmlFormat().get(3));
		assertEquals("<p> And there's a lot more that will follow </p>", 
				network.toHtmlFormat().get(4));
		assertEquals("<img src= PartnerFile> </img>", 
				network.toHtmlFormat().get(5));
		assertEquals("<p> So pay attention to the news </p>", 
				network.toHtmlFormat().get(6));
		assertEquals("<img src= PartnerFile> </img>", 
				network.toHtmlFormat().get(7));
		assertEquals("<p> We hope to satify your petitions </p>", 
				network.toHtmlFormat().get(8));
		assertEquals("<img src= AdminFile> </img>", 
				network.toHtmlFormat().get(9));
		assertEquals("<img src= ManagerFile> </img>", 
				network.toHtmlFormat().get(10));
		
		
	}
}
