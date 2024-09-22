package uo.mp.s5.dome.ui;

import uo.mp.s5.dome.model.Book;
import uo.mp.s5.dome.model.Cd;
import uo.mp.s5.dome.model.Dvd;
import uo.mp.s5.dome.model.VideoGame;
import uo.mp.s5.dome.model.VideoGame.Platform;
import uo.mp.s5.dome.service.MediaLibrary;

/**
 * Titulo: Clase Application
 * 
 * Descripción: Clase que lanza el programa mediante lo creado en .model y
 * .service
 * 
 * @author Omitg
 * @version 18-02-2021
 */
public class MediaPlayer {

	/**
	 * Método que lanza el programa mediante lo creado en .model y .service
	 */
	public static void run() {
		//Creación de los objetos
		MediaLibrary lib = new MediaLibrary();
		Cd cd1 = new Cd("TIM", "Avicii", 12, 38, 19.99, true);
		Cd cd2 = new Cd("The Dark Knight SoundTrack", "Hans Zimmer & James Newton Howard", 
				28, 146, 39.99);
		Cd cd3 = new Cd("Meteora (Bonus Edition)", "Linkin Park", 16, 46, 14.99, true);
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
		Book book1 = new Book("Percy Jackson & the Lightning Thief","Rick Riordan",
				"Salamandra", "978-8498382365", 14.99, true);
		Book book2 = new Book("Daredevil Born Again","Frank Miller & David Mazzucchelli",
				"Marvel Comics", "978-8498854756", 22.95, true);
		Book book3 = new Book("The Truth about the Harry Quebert Affair","Joël Dicker",
				"DEBOLSILLO", "978-8466332286", 10.95);
		Book book4 = new Book("The Fall of the Giants","Ken Follet", "DEBOLSILLO",
				"978-8499899800", 10.95);
		Book book5 = new Book("Batman The Killing Joke","Alan Moore & Brian Azzarello",
				"DC Comics", "978-0930289454", 19.95);
		
		//Se añaden a la lista
		lib.add(cd1);
		lib.add(cd2);
		lib.add(cd3);
		lib.add(dvd1);
		lib.add(dvd2);
		lib.add(dvd3);
		lib.add(game1);
		lib.add(game2);
		lib.add(game3);
		lib.add(book1);
		lib.add(book2);
		lib.add(book3);
		lib.add(book4);
		lib.add(book5);
		
		//Dar formato a la librería		
		System.out.println("~~~~~~~~~~~~~~~~~~~~~~| Media Library |~~~~~~~~~~~~~~~~~~~~~~~\n");
		
		//Llamada a los métodos de MediaLibrary
			//lib.list(System.out);		//Imprime la lista
		lib.list2(System.out);		//Imprime la lista
		
		System.out.println("--------------------| Number of Items |------------------------\n");
		System.out.println("You own " + lib.getNumberOfItemsOwned() + " of this products\n");		//Numero de productos que se poseen
		System.out.println("-----------------------| Search Item |-------------------------\n");
		
		System.out.println("Possition of the object (" +searched.getTitle()+ "): "
		+ lib.search(searched)+"\n");		//Posición del objeto buscado
		System.out.println("-----------------------| Owned Items |-------------------------\n");
		
		System.out.println("From the products you own, the creators are: \n");		
		lib.printsResponsable(System.out);		//Imprimir los creadores de los Cds, Dvds y VideoGames 
		
		System.out.println("\n-----------------------| Total Value |-------------------------\n");		
		System.out.println("From the list of products, the total value of them is: \n");
		System.out.println("\tValue: " + lib.totalValue() + " $\n");		//Valor total del coste de los objetos
		
		System.out.println("------------------------| Items Code |-------------------------\n");
		System.out.println(lib.generateCode() + "\n");		//Codigo de los objetos
		
		System.out.println("---------------------| Borrowable Items |----------------------\n");
		lib.listBorrowableItems(System.out);		//Lista de los objetos prestables
		System.out.println();
		
		System.out.println("----------------------| Available Items |----------------------\n");
		lib.listAvailableItems(System.out);			//Lista de los objetos prestables disponible
		System.out.println();
		
		System.out.println("----------------------| Items to Borrow |----------------------\n");
		System.out.println(lib.borrow(book1));		//Imprimir objetos prestables
		System.out.println(lib.borrow(cd1));	
		System.out.println(lib.borrow(book2));
		
		System.out.println("---------------------| Items to give Back |---------------------\n");
		if (lib.giveBack(book1)) {		//Imprimir los objetos devueltos
			System.out.println("Se ha devuelto : " + book1.getTitle() + " by: " + book1.getAuthor());
		}
		if (lib.giveBack(cd1)) {
			System.out.println("Se ha devuelto : " + cd1.getTitle() + " by: " + cd1.getArtist());
		}		
	}
}
