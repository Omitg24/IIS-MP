package uo.mp.newsstand.ui;

import java.io.IOException;
import java.util.List;

import uo.mp.newsstand.domain.Publication;
import uo.mp.newsstand.service.Newsstand;
import uo.mp.newsstand.service.exception.InvalidFileNameException;
import uo.mp.newsstand.service.exception.NewsStandException;
import uo.mp.newsstand.ui.console.Console;
import uo.mp.util.log.Logger;

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
	 * Método que muestra por pantalla el programa
	 */
	public void show()  {
		int option = EXIT;
		do {
			menu.show();
			option = menu.readOption();
			try {
				processOption(option);
			} catch (RuntimeException e) {
				handleSystemError(e);
				return;
			} catch (Exception e) {
				handleUserError(e);
			}
		} while (option != EXIT);
	}

	private void handleSystemError(RuntimeException e) {
		String str = "Ha habido un error\n"
				+ e.getMessage()
				+ " por favor, contacte con el administrador";
		Console.printf(str);
		Logger.log(str);
	}

	private void handleUserError(Exception e) {
		String str = "Ha habido un error\n"
				+ e.getMessage()
				+ " por favor, intentelo de nuevo";
		Console.printf(str);
	}
	
	/**
	 * Método que procesa las opciones del program
	 * 
	 * @param option, opcion a procesar
	 * @throws NewsStandException 
	 * @throws IOException 
	 */
	private void processOption(int option) throws NewsStandException, IOException {
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
	 * Método que carga un fichero
	 * @throws InvalidFileNameException 
	 */
	private void loadFile() throws InvalidFileNameException {
		String fileName = Console.readString("File name?");
		newsStand.loadFile( fileName );
	}
	
	/**
	 * Método que añade una publicación
	 * @throws NewsStandException 
	 */
	private void addPublication() throws NewsStandException {
		Publication p = new PublicationForm().askForPublication();
		newsStand.addPublication( p );
	}
	
	/**
	 * Método que elimina una publicación
	 */
	private void removePublication() {
		String name = Console.readString("publication name?");
		newsStand.removePublication( name );
	}
	
	/**
	 * Método que muestra una publicación
	 */
	private void showPublications() {
		List<Publication> publications = newsStand.getPublications();
		listPublications( publications );
	}
	
	/**
	 * Método que crea pedidos
	 */
	private void createOrders() {
		newsStand.createOrders();
	}

	/**
	 * Método que muestra la lista de publicaciones
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
	 * Método que guarda los pedidos en un fichero
	 */
	private void saveOrdersToFile() {
		String fileName = Console.readString("output file name?");
		newsStand.saveOrdersToFile( fileName );
	}
	
	/**
	 * Método que importa un zip
	 * @throws InvalidFileNameException 
	 * @throws IOException 
	 */
	private void importFromZip() throws InvalidFileNameException, IOException {
		String fileName = Console.readString("input zip file name?");
		newsStand.importPublicationsFromZipFile( fileName );
	}
	
	/**
	 * Método que exporta a un zip
	 */
	private void exportToZip() {
		String fileName = Console.readString("output file name?");
		newsStand.exportPublicationsToZipFile( fileName );
	}
}
