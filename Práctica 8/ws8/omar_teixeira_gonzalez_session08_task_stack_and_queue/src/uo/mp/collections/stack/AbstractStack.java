package uo.mp.collections.stack;

import uo.mp.collections.List;
import uo.mp.collections.Stack;
import uo.mp2021.util.checks.ArgumentChecks;
import uo.mp2021.util.checks.IllegalStateChecks;

/**
 * Titulo: Clase AbstractStack
 * 
 * @author Omitg
 * @version 30-03-2021
 */
public class AbstractStack implements Stack<Object>{
	/**
	 * Atributo lista
	 */
	protected List list;

	/**
	 * Método que devuelve el tamaño de la cola
	 * 
	 * @return size, tamaño de la cola
	 */
	@Override
	public int size() {
		return list.size();
	}
	
	/**
	 * Método que devuelve si la cola está vacía
	 * 
	 * @return true, si está vacía
	 */
	@Override
	public boolean isEmpty() {
		return list.isEmpty();
	}
	
	/**
	 * Método que añade un elemento en la primera posición de la pila
	 * 
	 * @param element, elemento a añadir a la pila
	 * @return element, elemento a añadir a la pila 
	 */
	@Override
	public Object push(Object element) {
		ArgumentChecks.isTrue(element!=null, "El elemento no cumple los requisitos");
		list.add(0, element);
		return element;
	}

	/**
	 * Método que elimina el elemento de la primera posición de la pila
	 * 
	 * @return element, elemento eliminado
	 */
	@Override
	public Object pop() {
		IllegalStateChecks.isTrue(!isEmpty(), "La pila esta vacía");
		Object element = list.get(0);
		list.remove(0);
		return element;
	}

	/**
	 * Método que devuelve el elemento de la primera posición de la pila
	 * 
	 * @return element, elemento en la primera posición de la pila
	 */
	@Override
	public Object peek() {
		IllegalStateChecks.isTrue(!isEmpty(), "La pila esta vacía");
		return list.get(0);
	}	
}
