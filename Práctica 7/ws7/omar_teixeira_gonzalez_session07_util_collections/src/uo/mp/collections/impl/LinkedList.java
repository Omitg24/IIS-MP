package uo.mp.collections.impl;

import uo.mp.check.ArgumentChecks;
import uo.mp.collections.List;

/**
 * Titulo: Clase LinkedList
 * 
 * @author Omitg
 * @version 18-03-2021
 */
public class LinkedList implements List {
	/**
	 * Cabeza del nodo
	 */
	private Node head;
	/**
	 * Numero de elementos
	 */
	private int numberOfElements;
	
	/**
	 * M�todo que devuelve el tama�o del arrayList
	 * 
	 * @return numberOfElements, numero de elementos
	 */
	@Override
	public int size() {
		return numberOfElements;
	}

	/**
	 * M�todo que devuelve si el ArrayList est� vac�o
	 * 
	 * @return true o false, en funci�n de si est� vac�o
	 */
	@Override
	public boolean isEmpty() {
		return size()==0;
	}

	/**
	 * M�todo que devuelve si el ArrayList contiene a un objeto como par�metro
	 * 
	 * @param o, objeto
	 * @return true o false, en funci�n de si esta
	 */
	@Override
	public boolean contains(Object o) {
		return indexOf(o)!=-1;
	}
	
	/**
	 * M�todo que a�ade un objeto en la �ltima posici�n
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
	 * M�todo que a�ade un objeto en una posici�n concreta
	 * 
	 * @param index, indice
	 * @param element, objeto
	 */
	@Override
	public void add(int index, Object element) {
		ArgumentChecks.bounds(index>=0 && index<=size());		
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
	 * M�todo que a�ade un elemento en la posicion inicial
	 * 
	 * @param element, elemento a a�adir
	 */
	public void addFirst(Object element) {
		head = new Node(element, head);
		numberOfElements++;
	}
	
	/**
	 * M�todo que elimina un objeto de la lista, devuelve true si lo ha eliminado
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
	 * M�todo que elimina todos los objetos de la lista
	 */
	@Override
	public void clear() {		
		head=null;
		numberOfElements=0;
	}
	
	/**
	 * M�todo que devuelve un objeto de la lista pasada como par�metro
	 * 
	 * @param index, posici�n del objeto a devolver
	 * @return object, objeto en la posici�n
	 */
	@Override
	public Object get(int index) {
		if (isEmpty()) {
			ArgumentChecks.bounds(index>0 && index<size());
		}
		ArgumentChecks.bounds(index>=0 && index<size());
		return getNode(index).value;
	}
	
	/**
	 * M�todo que devuelve el nodo
	 * 
	 * @param index, posici�n del nodo
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
	 * M�todo que setea un objeto en una posici�n determinada
	 * 
	 * @param index, posici�n del objeto a setear
	 * @param value, valor
	 */
	@Override
	public Object set(int index, Object value) {
		if (isEmpty()) {
			ArgumentChecks.bounds(index>0 && index<size());
		}
		ArgumentChecks.bounds(index>=0 && index<size());
		Object aux = getNode(index).value;
		getNode(index).value=value;
		return aux;
	}
	
	/**
	 * M�todo que elimina un objeto pasado la posici�n que ocupan
	 * 
	 * @param index, posicion del objeto a eliminar
	 */
	@Override
	public Object remove(int index) {
		if (isEmpty()) {
			ArgumentChecks.bounds(index>0 && index<size());
		}
		ArgumentChecks.bounds(index>=0 && index<size());
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
	 * M�todo que devuelve la posici�n en la que est� un objeto
	 * 
	 * @return i, posici�n del objeto o -1 si no esta
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
	 * M�todo que devuelve la lista en formato cadena de caracteres
	 * 
	 * @return cadena de caracteres de la lista
	 */
	@Override
	public String toString() {
		String aux = "[";
		for (int i=0; i<size();i++) {
			if (i!= numberOfElements-1) {
				aux = aux + get(i) + ", ";
			} else {
				aux = aux + get(i);
			}
		}
		aux = aux + "]";
		return aux;
	}
	
	/**
	 * M�todo que devuelve el codigo de la lista
	 * 
	 * @return hashCode, codigo de la lista
	 */
	@Override
	public int hashCode() {
		int hashCode=0;
		if (isEmpty()) {
			hashCode=1;
			return hashCode;
		} else {
			Node aux = head;			
			while (aux!=null) {
				hashCode = 31 * hashCode + (aux == null ? 0 : aux.hashCode());
				aux= aux.next;								
			}				  
			return hashCode;
		}
	}	
}
