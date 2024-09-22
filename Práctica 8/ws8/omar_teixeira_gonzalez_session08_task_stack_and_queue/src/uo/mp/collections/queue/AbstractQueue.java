package uo.mp.collections.queue;

import uo.mp.collections.List;
import uo.mp.collections.Queue;
import uo.mp2021.util.checks.IllegalStateChecks;

/**
 * Titulo: AbstractQueue
 * 
 * @author Omitg
 * @version 30-03-2021
 */
public class AbstractQueue implements Queue<Object>{	
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
	 * Método que añade a la cola un elemento
	 * 
	 * @param element, elemento a añadir
	 */
	@Override
	public void enqueue(Object element) {
		IllegalStateChecks.isTrue(element!=null, "El elemento no cumple los requisitos");
		list.add(element);
	}

	/**
	 * Método que elimina de la cola el primer elemento
	 *
	 * @return elemento eliminado
	 */
	@Override
	public Object dequeue() {
		IllegalStateChecks.isTrue(!isEmpty(), "La cola esta vacía");
		return list.remove(0);
	}

	/**
	 * Método que devuelve el primer elemento de la cola
	 * 
	 * @return primer elemento
	 */
	@Override
	public Object peek() {
		IllegalStateChecks.isTrue(!isEmpty(), "La cola esta vacía");
		return list.get(0);
	}
}
