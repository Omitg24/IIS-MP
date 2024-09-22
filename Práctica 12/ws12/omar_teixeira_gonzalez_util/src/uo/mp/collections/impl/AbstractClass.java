package uo.mp.collections.impl;

import uo.mp.collections.List;

/**
 * Titulo: Clase AbstractClass
 * 
 * @author Omitg
 * @version 07-05-2021
 * @param <T>, parámetro generico
 */
public abstract class AbstractClass<T> implements List<T>{
	/**
	 * Numero de elementos
	 */
	protected int numberOfElements=0;

	/**
	 * Constructor sin parámetros que crea la superclase 
	 */
	public AbstractClass() {
		super();
	}

	/**
	 * Método que devuelve el tamaño del arrayList
	 * 
	 * @return numberOfElements, numero de elementos
	 */
	@Override
	public int size() {
		return numberOfElements;
	}

	/**
	 * Método que devuelve si el ArrayList está vacío
	 * 
	 * @return true o false, en función de si está vacío
	 */
	@Override
	public boolean isEmpty() {
		return size()==0;
	}

	/**
	 * Método que devuelve si el ArrayList contiene a un objeto como parámetro
	 * 
	 * @param o, objeto
	 * @return true o false, en función de si esta
	 */
	@Override
	public boolean contains(T o) {
		return indexOf(o)!=-1;
	}	
	
	/**
	 * Método que comprueba si dos elementos son iguales en una lista y 
	 * devuelve true en ese caso
	 * 
	 * @return true o false si dos elementos son iguales
	 */
	@SuppressWarnings("unchecked")
	@Override
	public boolean equals(Object o) {
		if (o==null) return false;
		if (o==this) return true;
		if (!(o instanceof List)) return false;
		
		List<T> that = (List<T>) o;
		if (this.size() != that.size()) return false;
		
		for (int i=0; i< size();i++) {
			Object e1 = this.get(i);
			Object e2 = that.get(i);
			if (!(e1.equals(e2)))
				return false;
		}
		return true;
	}
	
	/**
	 * Método que devuelve el codigo de la lista
	 * 
	 * @return result, hashCode de la lista
	 */
	public int hashCode() {
		int result = 1;
		for (int i=0; i< size();i++) {
			Object element = this.get(i);
			result = 31*result+(element.hashCode());
		}
		return result;
	}	
}