package uo.mp.s4.dome.service;

import java.io.PrintStream;
import java.util.ArrayList;

import uo.mp.s4.dome.model.Item;

import uo.mp.util.checks.ArgumentsCheck;

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

	/**
	 * A�ade un cd o dvd a la lista, no se permite a�adir null
	 * 
	 * @param item, el item a a�adir
	 */
	public void add(Item item) {
		ArgumentsCheck.isTrue(item != null, "Item debe de ser distinto de null");
		items.add(item);
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
		ArgumentsCheck.isTrue(out!=null, "No puede ser null");
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
		ArgumentsCheck.isTrue(out!=null, "No puede ser null");
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
		ArgumentsCheck.isTrue(theItem!=null, "El item no cumple los requistios");
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
		ArgumentsCheck.isTrue(theItem!=null, "El item no cumple los requistios");
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
		ArgumentsCheck.isTrue(out!=null, "No puede ser null");
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
}