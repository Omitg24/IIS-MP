package uo.mp.collections.testcases;

import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;

import uo.mp.collections.List;
import uo.mp.collections.setting.Settings;

/**
 * Titulo: Clase RemoveObjectTests
 * 
 * @author Omitg
 * @version 30-03-2021
 */
public class RemoveObjectTests {
	/**
	 * Atributo lista
	 */
	private List list;
	
	/**
	 * Creación de la lista para su posterior uso
	 */
	@Before
	public void setUp(){
		list = Settings.factory.newList();
	}

	/**
	 * Given:Dada una lista con un elemento
	 * When:se elimina ese objeto
	 * then: la lista queda vacia y devuelve true
	 */
	@Test
	public void oneObject() {	
		String s="hola";
		list.add(s);
		assertEquals(list.remove(s) && list.size()==0,true);
	}
	
	/**
	 * Given:Dada una lista con varios elementos
	 * When:se elimina un objeto
	 * then: se elimina el objeto y devuelve true
	 */
	@Test
	public void someObjects() {	
		String s="hola";
		list.add(s);
		list.add("adios");
		list.add("abcd");
		int size=list.size();
		assertEquals(list.remove(s) && list.size()==size-1,true);
	}
	
	/**
	 * Given:Dada una lista vacia
	 * When:se elimina un objeto no existente
	 * then: devuelve false
	 */
	@Test
	public void noObjects() {	
		String s="hola";
		assertEquals(!list.remove(s) && list.size()==0,true);
	}
	
	/**
	 * Given:Dada una lista con varios elementos
	 * When:se elimina un objeto que no esta en la lista
	 * then: no se elimina el objeto y devuelve false
	 */
	@Test
	public void removeNotExisting() {	
		String s="hola";
		list.add("exacto");
		list.add("adios");
		list.add("abcd");
		int size=list.size();
		assertEquals(!list.remove(s) && list.size()==size,true);
	}
	/**
	 * Given:Dada una lista con varios elementos 
	 * When:se elimina un objeto repetido
	 * then: se elimina el primero y devuelve true
	 */
	@Test
	public void someObjectsRepited() {	
		String s="hola";
		list.add(s);
		list.add("jaja");
		list.add("adios");
		list.add(s);
		list.add("abcd");
		int size=list.size();
		assertEquals(list.remove(s) && list.size()==size-1 && list.get(0)!=s ,
				true);
	}
	/**
	 * Given:Dada una lista
	 * When:se intenta eliminar null
	 * then:lanza una excepcion
	 */
	@Test
	(expected=IllegalArgumentException.class)
	public void nullAdd() {	
		list.add("hola!");
		list.add("jaja");
		list.add("adios");
		list.add("abcd");
		list.remove(null);
	}
	

}
