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
	 * M�todo que devuelve el tama�o de la cola
	 * 
	 * @return size, tama�o de la cola
	 */
	@Override
	public int size() {
		return list.size();
	}
	
	/**
	 * M�todo que devuelve si la cola est� vac�a
	 * 
	 * @return true, si est� vac�a
	 */
	@Override
	public boolean isEmpty() {
		return list.isEmpty();
	}
	
	/**
	 * M�todo que a�ade un elemento en la primera posici�n de la pila
	 * 
	 * @param element, elemento a a�adir a la pila
	 * @return element, elemento a a�adir a la pila 
	 */
	@Override
	public Object push(Object element) {
		ArgumentChecks.isTrue(element!=null, "El elemento no cumple los requisitos");
		list.add(0, element);
		return element;
	}

	/**
	 * M�todo que elimina el elemento de la primera posici�n de la pila
	 * 
	 * @return element, elemento eliminado
	 */
	@Override
	public Object pop() {
		IllegalStateChecks.isTrue(!isEmpty(), "La pila esta vac�a");
		Object element = list.get(0);
		list.remove(0);
		return element;
	}

	/**
	 * M�todo que devuelve el elemento de la primera posici�n de la pila
	 * 
	 * @return element, elemento en la primera posici�n de la pila
	 */
	@Override
	public Object peek() {
		IllegalStateChecks.isTrue(!isEmpty(), "La pila esta vac�a");
		return list.get(0);
	}	
}
