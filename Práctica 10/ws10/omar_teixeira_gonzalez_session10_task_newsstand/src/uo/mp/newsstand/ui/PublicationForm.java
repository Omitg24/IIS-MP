package uo.mp.newsstand.ui;

import uo.mp.newsstand.domain.Magazine;
import uo.mp.newsstand.domain.Newspaper;
import uo.mp.newsstand.domain.Publication;
import uo.mp.newsstand.service.exception.NewsStandException;
import uo.mp.newsstand.ui.console.Console;

/**
 * Titulo: Clase PulicationForm
 * 
 * Asks the user all the data for a new publication.
 * 
 * @author Omitg
 * @version 07-04-2021
 */
public class PublicationForm {

	/**
	 * Mehotd that asks for a new publication
	 * 
	 * @return The new Publication object created. It will be be of any 
	 * of the child types of Publication.
	 * @throws NewsStandException
	 */
	public Publication askForPublication() throws NewsStandException {
		String type = Console.readString("Type of publication? (n | m)");
		type = type.toLowerCase();
		switch (type) {
			case "n": return askForNewsPaper();
			case "m": return askForMagazine();
			default:  throw new NewsStandException("Tipo de publicación desconocida");
		}

	}
	
	/**
	 * Method that asks for a new Magazine
	 * 
	 * @return magazine, magazine
	 */
	private Publication askForMagazine() {
		String name = Console.readString("name?");
		int stock = Console.readInteger("stock?");
		int sales = Console.readInteger("sales?");
		int regularity = Console.readInteger("regularity?");

		return new Magazine(name, stock, sales, regularity);
	}

	/**
	 * Method that asks for a new NewsPaper
	 * 
	 * @return newspaper, newspaper
	 */
	private Publication askForNewsPaper() {
		String name = Console.readString("name?");
		int stock = Console.readInteger("stock?");
		int sales = Console.readInteger("sales?");

		return new Newspaper(name, stock, sales);
	}

}
