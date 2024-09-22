package uo.mp.s4.dome.ui;

import uo.mp.s4.dome.model.Cd;
import uo.mp.s4.dome.model.Dvd;
import uo.mp.s4.dome.model.VideoGame;
import uo.mp.s4.dome.model.VideoGame.Platform;
import uo.mp.s4.dome.service.MediaLibrary;

/**
 * Titulo: Clase Application
 * 
 * Descripci�n: Clase que lanza el programa mediante lo creado en .model y
 * .service
 * 
 * @author Omitg
 * @version 18-02-2021
 */
public class MediaPlayer {

	/**
	 * M�todo que lanza el programa mediante lo creado en .model y .service
	 */
	public static void run() {
		//Creaci�n de los objetos
		MediaLibrary lib = new MediaLibrary();
		Cd cd1 = new Cd("TIM", "Avicii", 12, 38, 19.99);
		Cd cd2 = new Cd("The Dark Knight SoundTrack", "Hans Zimmer & James Newton Howard", 
				28, 146, 39.99);
		Cd cd3 = new Cd("Meteora (Bonus Edition)", "Linkin Park", 16, 46, 14.99);
		Dvd dvd1 = new Dvd("Inception","Christopher Nolan", 162, 19.99);
		Dvd dvd2 = new Dvd("Gladiator (Special Edition) ","Ridley Scott", 171, 39.99);
		Dvd dvd3 = new Dvd("Vikings: Full Series", "Michael Hirst", 4005, 119.99);
		VideoGame game1 = new VideoGame("God of War (2018)","Cory Barlog", 1, 
				Platform.PLAYSTATION, 69.99);
		VideoGame game2 = new VideoGame("Batman: Arkham Knight","Sefton Hill", 1, 
				Platform.XBOX, 49.99);
		VideoGame game3 = new VideoGame("Mario Kart 8","Kosuke Yabuki", 4, 
				Platform.NINTENDO, 59.99);
		VideoGame searched = new VideoGame("God of War (2018)","Cory Barlog", 1, 
				Platform.PLAYSTATION, 69.99);
		
		//Se a�aden a la lista
		lib.add(cd1);
		lib.add(cd2);
		lib.add(cd3);
		lib.add(dvd1);
		lib.add(dvd2);
		lib.add(dvd3);
		lib.add(game1);
		lib.add(game2);
		lib.add(game3);
		
		//Setear la no posesion del producto
		cd2.setOwn(false);	
		dvd2.setOwn(false);
		game3.setOwn(false);		
		
		//Dar formato a la librer�a		
		System.out.println("~~~~~~~~~~~~~~~~~~~~~~| Media Library |~~~~~~~~~~~~~~~~~~~~~~~\n");
		
		//Llamada a los m�todos de MediaLibrary
			//lib.list(System.out);		//Imprime la lista
		lib.list2(System.out);		//Imprime la lista
		
		System.out.println("--------------------| Number of Items |------------------------\n");
		System.out.println("You own " + lib.getNumberOfItemsOwned() + " of this products\n");		//Numero de productos que se poseen
		System.out.println("-----------------------| Search Item |-------------------------\n");
		
		System.out.println("Possition of the object (" +searched.getTitle()+ "): "
		+ lib.search(searched)+"\n");		//Posici�n del objeto buscado
		System.out.println("-----------------------| Owned Items |-------------------------\n");
		
		System.out.println("From the products you own, the creators are: \n");		
		lib.printsResponsable(System.out);		//Imprimir los creadores de los Cds, Dvds y VideoGames 
		System.out.println("\n-----------------------| Total Value |-------------------------\n");
		
		System.out.println("From the list of products, the total value of them is: \n");
		System.out.println("\tValue: " + lib.totalValue() + " $\n");
		
		System.out.println("------------------------| Items Code |-------------------------\n");
		System.out.println(lib.generateCode() + "\n");
	}
}
