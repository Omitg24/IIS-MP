package uo.mp.collections.impl;

import java.util.Iterator;

import uo.mp.collections.List;
import uo.mp2021.util.checks.ArgumentChecks;
import uo.mp2021.util.checks.IllegalStateChecks;
import uo.mp2021.util.checks.IndexOutOfBoundsChecks;
import uo.mp2021.util.checks.NoSuchElementChecks;

/**
 * Titulo: Clase ArrayList
 * 
 * @author Omitg
 * @version 18-03-2021
 */
public class ArrayList extends AbstractClass implements List {
	/**
	 * Constante capacidad inicial
	 */
	private final static int INITIAL_CAPACITY = 20;	
	/**
	 * Array de objetos
	 */
	private Object[] elements;
	/**
	 * Constructor sin parámetros de la clase ArrayList
	 */
	public ArrayList() {
		this(INITIAL_CAPACITY);
	}
	
	/**
	 * Constructor con parámetro capacidad de la clase ArrayList
	 * 
	 * @param capacity, capacidad del arrayList
	 */
	public ArrayList(int capacity) {
		ArgumentChecks.isTrue(capacity > 0);
		elements = new Object[capacity];
	}
	
	/**
	 * Método que añade un objeto en la última posición
	 * 
	 * @param obj, objeto
	 */
	@Override
    public void add(Object obj) {
		ArgumentChecks.isTrue(obj!=null);
        if(size()>= elements.length) {
            moreMemory(size()+1);
        }else {
        	elements[this.size()]=obj;
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
		IndexOutOfBoundsChecks.isTrue(index>=0 && index<=this.size());		
		ArgumentChecks.isTrue(element!=null);
		if(memoryFull()) {
			moreMemory(this.size() + 1);
		}
		for(int i = size(); i > index; i--) {
			elements[i] = elements[i-1];
		}
		elements[index] = element;
		numberOfElements++;
	}
	
	/**
	 * Método que analiza si la memoria esta llena
	 * 
	 * @return true si esta llena
	 */
	private boolean memoryFull() {
		return this.size()==elements.length;
	}

	/**
	 * Método que añade un numero de espacios determinados
	 *  
	 * @param numElem, numero de elementos a añadir
	 */
	private void moreMemory(int numElem) {
        if(numElem > elements.length) {
            Object[] aux = new Object[Math.max(numElem, 2*elements.length)];
            System.arraycopy(elements, 0, aux, 0, elements.length);
            elements=aux;
        }
    }
	
	/**
	 * Método que elimina un objeto de la lista, devuelve true si lo ha eliminado
	 * 
	 * @return true o false, si lo elimina
	 */
	@Override
	public boolean remove(Object o) {
		ArgumentChecks.isTrue(o!=null);
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
		elements = new Object[size()];
		numberOfElements = 0;
	}
	
	/**
	 * Método que devuelve un objeto de la lista pasada como parámetro
	 * 
	 * @param index, posición del objeto a devolver
	 * @return object, objeto en la posición
	 */
	@Override
	public Object get(int index) {
		IndexOutOfBoundsChecks.isTrue(index >= 0 && index < this.size());
		IndexOutOfBoundsChecks.isTrue(!isEmpty());
		
		return elements[index];
	}

	/**
	 * Método que setea un objeto en una posición determinada
	 * 
	 * @param index, posición del objeto a setear
	 * @param element, elemento
	 */
	@Override
	public Object set(int index, Object element) {
		IndexOutOfBoundsChecks.isTrue(index >= 0 && index < this.size());
		ArgumentChecks.isTrue(element != null);	
		
		Object aux = elements[index];
		elements[index] = element;
		return aux;
	}

	/**
	 * Método que elimina un objeto pasado la posición que ocupan
	 * 
	 * @param index, posicion del objeto a eliminar
	 */
	@Override
	public Object remove(int index) {
		IndexOutOfBoundsChecks.isTrue(index >= 0 && index < this.size());
		Object aux = elements[index];
		for(int i = index; i < size() -1;  i++)
			elements[i] = elements[i+1];
		numberOfElements--;
		elements[size()] = null;
		return aux;
	}
	
	/**
	 * Método que devuelve la posición en la que está un objeto
	 * 
	 * @return i, posición del objeto o -1 si no esta
	 */
	@Override
	public int indexOf(Object o) {
		if (o==null) {
			return -1;
		}
		if (this.isEmpty()) {
			return -1;
		}
		for (int i=0; i<size();i++) {
			if (o==null && elements[i]==null) {
				return i;
			}
			if (elements[i].equals(o)) {
				return i;
			}
		}
		return -1;
	}
	
	/**
	 * Método que devuelve la lista en formato cadena de caracteres
	 * 
	 * @return cadena de caracteres de la lista
	 */
	public String toString() {
		StringBuilder result = new StringBuilder("[");
		for (int i=0; i<size();i++) {
			result.append(elements[i]);
			if (i<size()-1) {
				result.append(",");
			}
		}
		result.append("]");
		return result.toString();
	}
	
	/**
	 * Método que devuelve el iterador de linkedList
	 * 
	 * @return LinkedListIterator
	 */
	@Override
	public Iterator<Object> iterator() {
		return new ArrayListIterator();
	}
	
	/**
	 * Titulo: Clase LinkedListIterator
	 * 
	 * @author Omitg
	 * @version 30-10-2021
	 */
	private class ArrayListIterator implements Iterator<Object>{
		/**
		 * Atributo siguiente posición
		 */
		private int nextPos = 0;
		/**
		 * Atributo siguiente objeto
		 */
		private Object next = null;
		
		/**
		 * Método que analiza si linkedList tiene un elemento siguiente, devuelve true en ese caso
		 * 
		 * @return true o false si tiene next
		 */
		@Override
		public boolean hasNext() {
			return nextPos < size();
		}
		
		/**
		 * Método que devuelve el siguiente objeto de la lista
		 * 
		 * @return lastReturned.value, valor del siguiente objeto
		 */
		@Override
		public Object next() {
			NoSuchElementChecks.isTrue(hasNext(), "No hay mas elementos");
			next = elements[nextPos];
			nextPos++;
			return next;
		}		
		
		/**
		 * Método que elimina un objeto de la lista
		 */
		public void remove() {
			IllegalStateChecks.isTrue(next!=null, "Estado incorrecto");
			ArrayList.this.remove(nextPos-1);
			nextPos--;
		}
	}
}