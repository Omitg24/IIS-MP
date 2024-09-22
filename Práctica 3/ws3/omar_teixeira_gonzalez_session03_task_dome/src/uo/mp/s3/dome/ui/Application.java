package uo.mp.s3.dome.ui;

import uo.mp.s3.dome.model.Cd;
import uo.mp.s3.dome.model.Dvd;
import uo.mp.s3.dome.model.VideoGame;
import uo.mp.s3.dome.model.VideoGame.Platform;
import uo.mp.s3.dome.service.MediaLibrary;

/**
 * Titulo: Clase Application
 * 
 * Descripci�n: Clase que lanza el programa mediante lo creado en .model y
 * .service
 * 
 * @author Omitg
 * @version 18-02-2021
 */
public class Application {

	/**
	 * M�todo que lanza el programa mediante lo creado en .model y .service
	 */
	public static void run() {
		//Creaci�n de los objetos
		MediaLibrary lib = new MediaLibrary();
		Cd cd1 = new Cd("TIM", "Avicii", 12, 38);
		Cd cd2 = new Cd("The Dark Knight SoundTrack", "Hans Zimmer & James Newton Howard", 28, 146);
		Dvd dvd1 = new Dvd("Inception","Christopher Nolan", 162);
		Dvd dvd2 = new Dvd("Gladiator","Ridley Scott", 171);
		VideoGame game1 = new VideoGame("God of War (2018)","Cory Barlog", 1, Platform.PLAYSTATION);
		VideoGame game2 = new VideoGame("Batman: Arkham Knight","Sefton Hill", 1, Platform.XBOX);
		VideoGame game3 = new VideoGame("Mario Kart 8","Kosuke Yabuki", 4, Platform.NINTENDO);
		Dvd searched = new Dvd("Gladiator","Ridley Scott", 171);
		
		//Se a�aden a la lista
		lib.add(cd1);
		lib.add(cd2);
		lib.add(dvd1);
		lib.add(dvd2);
		lib.add(game1);
		lib.add(game2);
		lib.add(game3);
		
		//Setear la no posesion del producto
		cd2.setOwn(false);
		game3.setOwn(false);		
		
		//Dar formato a la librer�a
		System.out.println("                  Media Library:                   ");
		System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~\n");
		
		//Llamada a los m�todos de MediaLibrary
		lib.list(System.out);		//Imprime la lista
		System.out.println("------------------------------------------------\n");
		System.out.println("You own " + lib.getNumberOfItemsOwned() + " of this products\n");		//Numero de productos que se poseen
		System.out.println("------------------------------------------------\n");
		System.out.println("Possition of the objet (" +searched.getTitle()+ "): "+ lib.searchItem(searched)+"\n");		//Posici�n del objeto buscado
		System.out.println("------------------------------------------------\n");
		System.out.println("De los anteriores, los creadores son: ");		
		lib.printsResponsable(System.out);		//Imprimir los creadores de los Cds, Dvds y VideoGames 
	}
}
