package uo.mp.s4.post.ui;

import uo.mp.s4.post.model.Message;
import uo.mp.s4.post.model.Photo;
import uo.mp.s4.post.service.TheSocialNetwork;

/**
 * Titulo: Clase NetworkApp
 * 
 * Descripci�n: Clase que lanza el programa mediante lo creado en .model y
 * .service
 * 
 * @author Omitg
 * @version 26-02-2021
 */
public class NetworkApp {

	/**
	 * M�todo que lanza el programa mediante lo creado en .model y .service
	 */
	public static void run() {
		//Creaci�n de los objetos
		TheSocialNetwork network = new TheSocialNetwork();
		
		Message msg1 = new Message("Omitg�","Welcome to the Social Network");
		Message msg2 = new Message("ElPlayerHD","Here you'll see examples on what's to come!");
		Message msg3 = new Message("DaneonX","And there's a lot more that will follow");
		Message msg4 = new Message("Omitg�", "So pay attention to the news");
		Message msg5 = new Message("Diana1806","We hope to satify your petitions");
		
		Photo pic1 =  new Photo ("PeacefulGoon39","AdminFile");
		Photo pic2 = new Photo ("Omitg�", "CreatorFile");
		Photo pic3 = new Photo ("ElPlayerHD", "PartnerFile");
		Photo pic4 = new Photo ("DaneonX", "PartnerFile");
		Photo pic5 = new Photo ("Sky00","AdminFile");
		Photo pic6 = new Photo ("Diana1806","ManagerFile");
		
		//Se a�aden a la red social (lista):
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
		
		//Dar formato a la red social		
		System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~| The Social Network� |~~~~~~~~~~~~~~~~~~~~~~~~~~~~~\n");
		
		//Llamada a los m�todos de TheSocialNetwork
		network.print(System.out);
		
		System.out.println("\n------------------------------| Posts by user |--------------------------------\n");
		System.out.println("Posts by: " + msg1.getUser() +"\n");
		int count=0;
		for (int i=0; i<network.findPostsByUser(msg1.getUser()).size();i++) {
			System.out.print("\t");
			network.findPostsByUser(msg1.getUser()).get(i).print(System.out);
			count++;
		}
		System.out.println("\nThe total number of posts by: " + msg1.getUser() + " are " + count);
		
		System.out.println("\n-------------------------------| Html Posts |---------------------------------\n");
		System.out.println("Posts in HTML Format:\n");
		for (int i=0; i<network.toHtmlFormat().size();i++) {			
			System.out.println("\t--> " + network.toHtmlFormat().get(i));
		}
	}
}
