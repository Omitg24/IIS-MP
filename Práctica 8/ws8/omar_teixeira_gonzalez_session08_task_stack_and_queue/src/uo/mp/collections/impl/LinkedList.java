package uo.mp.collections.impl;

import java.util.Iterator;

import uo.mp.collections.List;
import uo.mp2021.util.checks.ArgumentChecks;
import uo.mp2021.util.checks.IllegalStateChecks;
import uo.mp2021.util.checks.IndexOutOfBoundsChecks;
import uo.mp2021.util.checks.NoSuchElementChecks;

/**
 * Titulo: Clase LinkedList
 * 
 * @author Omitg
 * @version 30-03-2021
 */
public class LinkedList extends AbstractClass implements List {
	/**
	 * Cabeza del nodo
	 */
	private Node head;	
	
	/**
	 * Método que añade un objeto en la última posición
	 * 
	 * @param element, elemento
	 */
	@Override
	public void add(Object element) {
		ArgumentChecks.isTrue(element!=null);
		if (isEmpty()) {
			addFirst(element);
		} else {
			Node last = getNode(size()-1);
			last.next = new Node(element, null);
			numberOfElements++;
		}
	}
	
	/**
	 * Método que añade un objeto en una posición concreta
	 * 
	 * @param index, indice
	 * @param element, objeto
	 */
	@Override
	public void add(int index, Object element) {
		IndexOutOfBoundsChecks.isTrue(index>=0 && index<=size());		
		ArgumentChecks.isTrue(element!=null);
		if (index==0) {
			addFirst(element);
		} else {
			Node previous = getNode(index-1);
			previous.next = new Node(element, previous.next);
			numberOfElements++;
		}
	}
	
	/**
	 * Método que añade un elemento en la posicion inicial
	 * 
	 * @param element, elemento a añadir
	 */
	public void addFirst(Object element) {
		head = new Node(element, head);
		numberOfElements++;
	}
	
	/**
	 * Método que elimina un objeto de la lista, devuelve true si lo ha eliminado
	 * 
	 * @return true o false, si lo elimina
	 */
	@Override
	public boolean remove(Object o) {
		ArgumentChecks.isTrue(o!=null);
		if (isEmpty()) {
			return false;
		}
		int searched = indexOf(o);
		if (searched!=-1) {
			remove(searched);
			return true;
		}
		return false;
	}
	
	/**
	 * Método que elimina todos los objetos de la lista
	 */
	@Override
	public void clear() {		
		head=null;
		numberOfElements=0;
	}
	
	/**
	 * Método que devuelve un objeto de la lista pasada como parámetro
	 * 
	 * @param index, posición del objeto a devolver
	 * @return object, objeto en la posición
	 */
	@Override
	public Object get(int index) {
		if (isEmpty()) {
			IndexOutOfBoundsChecks.isTrue(index>0 && index<size());
		}
		IndexOutOfBoundsChecks.isTrue(index>=0 && index<size());
		return getNode(index).value;
	}
	
	/**
	 * Método que devuelve el nodo
	 * 
	 * @param index, posición del nodo
	 * @return node, nodo
	 */
	private Node getNode(int index) {
		int position = 0;
		Node node = head;
		while (position < index) {
			node = node.next;
			position++;
		}
		return node;
	}
	
	/**
	 * Método que setea un objeto en una posición determinada
	 * 
	 * @param index, posición del objeto a setear
	 * @param value, valor
	 */
	@Override
	public Object set(int index, Object value) {
		if (isEmpty()) {
			IndexOutOfBoundsChecks.isTrue(index>0 && index<size());
		}
		IndexOutOfBoundsChecks.isTrue(index>=0 && index<size());
		Object aux = getNode(index).value;
		getNode(index).value=value;
		return aux;
	}
	
	/**
	 * Método que elimina un objeto pasado la posición que ocupan
	 * 
	 * @param index, posicion del objeto a eliminar
	 */
	@Override
	public Object remove(int index) {
		if (isEmpty()) {
			IndexOutOfBoundsChecks.isTrue(index>0 && index<size());
		}
		IndexOutOfBoundsChecks.isTrue(index>=0 && index<size());
		if (isEmpty()) {
			return null;
		}
		Object value;
		if (index==0) {
			value = head.value;
			head = head.next;
		} else {
			Node previous = getNode(index-1);
			value = previous.next.value;
			previous.next = previous.next.next;
		}
		numberOfElements--;
		return value;
	}
	
	/**
	 * Método que devuelve la posición en la que está un objeto
	 * 
	 * @return i, posición del objeto o -1 si no esta
	 */
	@Override
	public int indexOf(Object o) {
		Node aux = head;
		int i=0;
		while (aux!=null && !aux.value.equals(o)) {
			aux= aux.next;
			i++;
		}
		return aux==null?-1:i;
	}
	
	/**
	 * Método que devuelve la lista en formato cadena de caracteres
	 * 
	 * @return cadena de caracteres de la lista
	 */
	@Override
	public String toString() {
		String aux = "[";
		for (int i=0; i<size();i++) {
			if (i!= numberOfElements-1) {
				aux = aux + get(i) + ",";
			} else {
				aux = aux + get(i);
			}
		}
		aux = aux + "]";
		return aux;
	}
	
	/**
	 * Método que devuelve el iterador de linkedList
	 * 
	 * @return LinkedListIterator
	 */
	@Override
	public Iterator<Object> iterator() {
		return new LinkedListIterator();
	}
	
	/**
	 * Titulo: Clase Node
	 * 
	 * @author Omitg
	 * @version 30-03-2021
	 */
	private class Node {
		/**
		 * Atributo valor
		 */
		Object value;
		
		/**
		 * Atributo next
		 */
		Node next;
		
		/**
		 * Constructor con parámetros que crea el nodo
		 * 
		 * @param value, valor
		 * @param next, siguiente nodo
		 */
		Node(Object value, Node next){
			this.value=value;
			this.next=next;
		}
		
		/**
		 * Método que devuelve el nodo en formato String
		 * 
		 * @return result.toString, toString del nodo
		 */
		public String toString() {
			StringBuilder result = new StringBuilder();
			result.append(value + " => ");
			if (next==null) {
				result.append("null");
			} else {
				result.append(next.value);
				if (next.next != null) {
					result.append(" ...");
				}
			}
			return result.toString();
		}		
	}
	
	/**
	 * Titulo: Clase LinkedListIterator
	 * 
	 * @author Omitg
	 * @version 30-10-2021
	 */
	private class LinkedListIterator implements Iterator<Object> {
		/**
		 * Atributo nodo que apunta a cabeza
		 */
		private Node next=head;
		/**
		 * Atributo lastReturned
		 */
		private Node lastReturned = null;
		/**
		 * Atributo index siguiente		
		 */
		private int nextIndex = 0;		
		
		/**
		 * Método que analiza si linkedList tiene un elemento siguiente, devuelve true en ese caso
		 * 
		 * @return true o false si tiene next
		 */
		@Override
		public boolean hasNext() {
			return next!=null;
		}
		
		/**
		 * Método que devuelve el siguiente objeto de la lista
		 * 
		 * @return lastReturned.value, valor del siguiente objeto
		 */
		@Override
		public Object next() {	
			NoSuchElementChecks.isTrue(hasNext(), "No hay mas elementos");
			lastReturned = next;
			next = next.next;
			nextIndex++;
			return lastReturned.value;			
		}		
		
		/**
		 * Método que elimina un objeto de la lista
		 */
		public void remove() {
			IllegalStateChecks.isTrue(lastReturned!=null, "Estado incorrecto");
			lastReturned=null;
			LinkedList.this.remove(nextIndex-1);			
			nextIndex--;
		}
	}
}
