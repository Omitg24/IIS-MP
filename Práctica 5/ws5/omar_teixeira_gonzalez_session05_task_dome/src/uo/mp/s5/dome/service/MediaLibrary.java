package uo.mp.s5.dome.service;

import java.io.PrintStream;
import java.util.ArrayList;

import uo.mp.s5.dome.model.Borrowable;
import uo.mp.s5.dome.model.Item;
import uo.mp2021.util.checks.ArgumentChecks;

/**
 * Titulo: Clase MediaLibrary
 * 
 * @author Omitg
 * @version 18-02-2021
 */
public class MediaLibrary {

//Atributos:
	/**
	 * Lista de items
	 */
	private ArrayList<Item> items = new ArrayList<Item>();
	
	private ArrayList<Borrowable> borrowableItems = new ArrayList<>();

	/**
	 * A�ade un cd o dvd a la lista, no se permite a�adir null
	 * 
	 * @param item, el item a a�adir
	 */
	public void add(Item item) {
		ArgumentChecks.isTrue(item != null, "Item debe de ser distinto de null");
		items.add(item);
		if (item instanceof Borrowable) {
			borrowableItems.add((Borrowable) item);
		}
	}

	/**
	 * M�todo que deuvelve el numero de items presentes en la lista.
	 * 
	 * @return count, numero de items de la lista
	 */
	public int getNumberOfItemsOwned() {
		int count = 0;
		for (Item item : items) {
			if (item.getOwn()) {
				count++;
			}
		}
		return count;
	}

	/**
	 * M�todo que imprime el contenido de todos los elementos de la lista
	 * 
	 * @param out, imprime en el lugar indicada, de tipo PrintStream
	 */
	public void list(PrintStream out) {
		ArgumentChecks.isTrue(out!=null, "No puede ser null");
		for (Item item : items) {
			item.print(out);			
		}
	}
	
	/**
	 * M�todo que imprime el contenido de todos los elementos de la lista
	 * 
	 * @param out, imprime en el lugar indicada, de tipo PrintStream
	 */
	public void list2(PrintStream out) {
		ArgumentChecks.isTrue(out!=null, "No puede ser null");
		for (Item item : items) {
			out.println(item.toString());			
		}
	}

	/**
	 * M�todo que devuelve un array copia de la lista de los Items
	 * 
	 * @return copy, copia de la lista de los items
	 */
	public ArrayList<Item> getItems() {
		ArrayList<Item> copy = new ArrayList<Item>();
		for (int i = 0; i < items.size(); i++) {
			copy.add(items.get(i));
		}
		return copy;
	}

	/**
	 * M�todo que introducido un item como parametro comprueba si este est� en la
	 * lista y devuelve la posi�n en la que se encuentra (en caso de ser as�), o -1
	 * en caso de no estar
	 * 
	 * @param theItem, item a comprobar si est� en la lista
	 * @return i, posici�n en la que se encuentra el item; o, -1, si no esta en la
	 *         lista
	 */
	public int searchItem(Item theItem) {
		ArgumentChecks.isTrue(theItem!=null, "El item no cumple los requistios");
		for (int i = 0; i < items.size(); i++) {
			if (items.get(i)==theItem) {
				return i;									
			}
		}
		return -1;
	}
	
	/**
	 * M�todo que introducido un item como parametro comprueba si este est� en la
	 * lista y devuelve la posi�n en la que se encuentra (en caso de ser as�), o -1
	 * en caso de no estar
	 * 
	 * @param theItem, item a comprobar si est� en la lista
	 * @return i, posici�n en la que se encuentra el item; o, -1, si no esta en la
	 *         lista
	 */
	public int search(Item theItem) {
		ArgumentChecks.isTrue(theItem!=null, "El item no cumple los requistios");
		for (int i = 0; i < items.size(); i++) {
			if (items.get(i).equals(theItem)) {
				return i;									
			}
		}
		return -1;
	}
	

	/**
	 * M�todo que imprime el director o artista del item (Cd o Dvd), en funci�n de
	 * si se posee o no
	 *  
	 * @param	out, lugar donde se imprimir� el m�todo, de tipo PrintStream
	 */
	public void printsResponsable(PrintStream out) {
		ArgumentChecks.isTrue(out!=null, "No puede ser null");
		for (Item item : items) {
			item.printResponsible(out);
		}
	}
	
	/**
	 * M�todo que suma todos los precios finales de los objetos y devuelve 
	 * dicho total
	 *  
	 * @return total, total del valor de los items Cd, Dvd o VideoGame 
	 */
	public double totalValue() {
		double total = 0.0;
		for (Item item : items) {
			total=total+item.totalValue();
		}
		return total;
	}
	
	/**
	 * M�todo que genera el codigo de todos los objetos de la lista, siendo el codigo:
	 * (Primeras tres letras)+(Posici�n en la lista) separada por guiones
	 * 
	 * @return result, el codigo de los objetos de la lista
	 */
	public String generateCode() {
		String result = "";
		for(int i=0; i< items.size(); i++) {
			if (i!=items.size()-1) {
			result=result+(String) items.get(i).getTitle().substring(0,3) + i + "-";
			}
			if (i==items.size()-1) {
				result=result+(String) items.get(i).getTitle().substring(0,3) + i;
			}
		}
		return result;
	}
	
	/**
	 * M�todo que imprime la lista de los objetos que se pueden prestar en general
	 * 
	 * @param out, lugar donde imprimir la lista
	 */
	public void listBorrowableItems(PrintStream out) {
		for (Borrowable item : borrowableItems) {
			out.println(item.toString());
		}
	}
	
	/**
	 * M�todo que imprime la lista de los objetos prestables
	 * 
	 * @param out, lugar donde imprimir la lista
	 */
	public void listAvailableItems (PrintStream out) {
		for (Borrowable item : borrowableItems) {
			if (item.isAvailable()) {
				out.println(item);
			}
		}
	}
	
	/**
	 * M�todo que busca el item a prestar, en caso de existir en la lista de los prestables
	 * devuelve el propio item
	 * 
	 * @param item, item a prestar buscado
	 * @return item o null, en funci�n de si est� o no en la lista
	 */
	private Borrowable searchItemToBorrow(Borrowable item) {
		for (Borrowable theItem : borrowableItems) {
			if (theItem.equals(item)) {
				return theItem;
			}
		}
		return null;
	}
	
	/**
	 * M�todo que presta un item buscado si no es null y si esta disponible 
	 * 
	 * @param item, item a prestar
	 * @return null o theItem tras prestarlo
	 */
	public Borrowable borrow (Borrowable item) {
		Borrowable theItem = searchItemToBorrow(item);
		if (theItem==null) {
			return null;
		} 
		if (!theItem.isAvailable()) {
			return null;
		}
		theItem.borrow();
		return theItem;
	}
	
	/**
	 * M�todo que devuelve el item buscado si no es null y si no esta disponible
	 * 
	 * @param item, item a devolver
	 * @return false o true tras devolverlo
	 */
	public boolean giveBack(Borrowable item) {
		Borrowable theItem = searchItemToBorrow(item);
		if (theItem==null) {
			return false;
		} else if (theItem.isAvailable()) {
			return false;
		}
		
		theItem.giveBack();
		return true;
	}
}