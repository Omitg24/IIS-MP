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
	 * M�todo que a�ade a la cola un elemento
	 * 
	 * @param element, elemento a a�adir
	 */
	@Override
	public void enqueue(Object element) {
		IllegalStateChecks.isTrue(element!=null, "El elemento no cumple los requisitos");
		list.add(element);
	}

	/**
	 * M�todo que elimina de la cola el primer elemento
	 *
	 * @return elemento eliminado
	 */
	@Override
	public Object dequeue() {
		IllegalStateChecks.isTrue(!isEmpty(), "La cola esta vac�a");
		return list.remove(0);
	}

	/**
	 * M�todo que devuelve el primer elemento de la cola
	 * 
	 * @return primer elemento
	 */
	@Override
	public Object peek() {
		IllegalStateChecks.isTrue(!isEmpty(), "La cola esta vac�a");
		return list.get(0);
	}
}
