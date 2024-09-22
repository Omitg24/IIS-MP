package uo.mp.collections.impl;

import java.util.Arrays;
import java.util.Iterator;

import uo.mp.checks.ArgumentChecks;
import uo.mp.checks.StateChecks;
import uo.mp.checks.IndexOutOfBoundsChecks;
import uo.mp.checks.NoSuchElementChecks;
import uo.mp.collections.Collection;
import uo.mp.collections.List;

/**
 * Titulo: Clase ArrayList
 * 
 * @author Omitg
 * @version 07-05-2021
 * @param <T>, parámetro generico
 */
public class ArrayList<T> extends AbstractClass<T> implements List<T> {
	/**
	 * Constante capacidad inicial
	 */
	private final static int INITIAL_CAPACITY = 20;	
	/**
     * Shared empty array instance used for empty instances.
     */
    private static final Object[] EMPTY_ELEMENTDATA = {};

	/**
	 * Array de objetos
	 */
	private T[] elements;
	
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
	@SuppressWarnings("unchecked")
	public ArrayList(int capacity) {
		ArgumentChecks.isTrue(capacity > 0);
		elements = (T[]) new Object[capacity];
	}
	
	/**
	 * Constructor que devuelve una copia del arrayList
	 * 
	 * @param c, arrayList copia
	 */
	@SuppressWarnings({ "unchecked", "rawtypes" })
	public ArrayList(Collection<? extends T> c) {
        Object[] a = ((ArrayList) c).toArray();
        if ((numberOfElements = a.length) != 0) {
            if (c.getClass() == ArrayList.class) {
            	elements = (T[]) a;
            } else {
            	elements = (T[]) Arrays.copyOf(a, numberOfElements, Object[].class);
            }
        } else {
        	elements = (T[]) EMPTY_ELEMENTDATA;
        }
    }
	
	public Object[] toArray() {
        return Arrays.copyOf(elements, numberOfElements);
    }
	
	/**
	 * Método que añade un objeto en la última posición
	 * 
	 * @param obj, objeto
	 */
	@Override
    public void add(T obj) {
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
	public void add(int index, T element) {
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
	@SuppressWarnings("unchecked")
	private void moreMemory(int numElem) {
        if(numElem > elements.length) {
            T[] aux = (T[]) new Object[Math.max(numElem, 2*elements.length)];
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
	@SuppressWarnings("unchecked")
	@Override
	public void clear() {
		elements = (T[]) new Object[size()];
		numberOfElements = 0;
	}
	
	/**
	 * Método que devuelve un objeto de la lista pasada como parámetro
	 * 
	 * @param index, posición del objeto a devolver
	 * @return object, objeto en la posición
	 */
	@Override
	public T get(int index) {
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
	public T set(int index, T element) {
		IndexOutOfBoundsChecks.isTrue(index >= 0 && index < this.size());
		ArgumentChecks.isTrue(element != null);	
		
		T aux = elements[index];
		elements[index] = element;
		return aux;
	}

	/**
	 * Método que elimina un objeto pasado la posición que ocupan
	 * 
	 * @param index, posicion del objeto a eliminar
	 */
	@Override
	public T remove(int index) {
		IndexOutOfBoundsChecks.isTrue(index >= 0 && index < this.size());
		T aux = elements[index];
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
	public Iterator<T> iterator() {
		return (Iterator<T>) new ArrayListIterator();
	}
	
	/**
	 * Titulo: Clase LinkedListIterator
	 * 
	 * @author Omitg
	 * @version 30-10-2021
	 */
	private class ArrayListIterator implements Iterator<T>{
		/**
		 * Atributo siguiente posición
		 */
		private int nextPos = 0;
		/**
		 * Atributo siguiente objeto
		 */
		private T next = null;
		
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
		public T next() {
			NoSuchElementChecks.isTrue(hasNext(), "No hay mas elementos");
			next = elements[nextPos];
			nextPos++;
			return next;
		}		
		
		/**
		 * Método que elimina un objeto de la lista
		 */
		public void remove() {
			StateChecks.isTrue(next!=null, "Estado incorrecto");
			ArrayList.this.remove(nextPos-1);
			nextPos--;
		}
	}
}