package uo.mp.newsstand.ui;

import java.util.List;

import uo.mp.newsstand.domain.Publication;
import uo.mp.newsstand.service.Newsstand;
import uo.mp.newsstand.ui.console.Console;

/**
 * Titulo: Clase UserInterface
 * 
 * It is in charge of interacting with the user:
 * 	- Shows the menu of options
 *  - Process the option chosen by the user
 *  	- For that it asks the user the necessary data to fulfill the request
 *  	- Shows the result of the request
 *  - In case of error shows an explaining message
 *  
 *  Note: This is the unique class allowed to show information to the user
 *  
 *  @author Omitg
 *  @version 07-04-2021
 */
public class UserInterface {
//Constantes:
	/**
	 * Constante salida
	 */
	private static final int EXIT = 0;
//Atributos:
	/**
	 * Atributo menu
	 */
	private Menu menu = new Menu();
	/**
	 * Atributo newsStand 
	 */
	private Newsstand newsStand = new Newsstand();
	
	/**
	 * M�todo que muestra por pantalla el programa
	 */
	public void show()  {
		int option = EXIT;
		do {
			menu.show();
			option = menu.readOption();
			processOption(option);
		} while (option != EXIT);
	}

	/**
	 * M�todo que procesa las opciones del program
	 * 
	 * @param option, opcion a procesar
	 */
	private void processOption(int option) {
		switch( option ) {
			case EXIT: return;
			case 1: loadFile(); break;
			case 2: showPublications(); break;				
			case 3: addPublication(); break;
			case 4: removePublication(); break;				
			case 5: createOrders(); break; 				
			case 6: saveOrdersToFile(); break;
			case 7: importFromZip(); break;
			case 8: exportToZip(); break;
		}
	}

	/**
	 * M�todo que carga un fichero
	 */
	private void loadFile() {
		String fileName = Console.readString("File name?");
		newsStand.loadFile( fileName );
	}
	
	/**
	 * M�todo que a�ade una publicaci�n
	 */
	private void addPublication() {
		Publication p = new PublicationForm().askForPublication();
		newsStand.addPublication( p );
	}
	
	/**
	 * M�todo que elimina una publicaci�n
	 */
	private void removePublication() {
		String name = Console.readString("publication name?");
		newsStand.removePublication( name );
	}
	
	/**
	 * M�todo que muestra una publicaci�n
	 */
	private void showPublications() {
		List<Publication> publications = newsStand.getPublications();
		listPublications( publications );
	}
	
	/**
	 * M�todo que crea pedidos
	 */
	private void createOrders() {
		newsStand.createOrders();
	}

	/**
	 * M�todo que muestra la lista de publicaciones
	 */
	private void listPublications(List<Publication> publications) {
		Console.println("\nList of publications");
		Console.println("------------------");
		for (Publication p: publications) {
			System.out.println( p );
		}
	
		Console.println("------------------");
    }	
	
	/**
	 * M�todo que guarda los pedidos en un fichero
	 */
	private void saveOrdersToFile() {
		String fileName = Console.readString("output file name?");
		newsStand.saveOrdersToFile( fileName );
	}
	
	/**
	 * M�todo que importa un zip
	 */
	private void importFromZip() {
		String fileName = Console.readString("input zip file name?");
		newsStand.importPublicationsFromZipFile( fileName );
	}
	
	/**
	 * M�todo que exporta a un zip
	 */
	private void exportToZip() {
		String fileName = Console.readString("output file name?");
		newsStand.exportPublicationsToZipFile( fileName );
	}
}
