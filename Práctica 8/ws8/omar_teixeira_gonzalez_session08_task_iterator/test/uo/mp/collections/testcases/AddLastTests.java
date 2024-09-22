package uo.mp.collections.testcases;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;

import org.junit.Before;
import org.junit.Test;

import uo.mp.collections.List;
import uo.mp.collections.setting.Settings;

/**
 * Titulo: Clase AddLastTests
 * 
 * @author Omitg
 * @version 30-03-2021
 */
public class AddLastTests {
	/**
	 * Lista
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
	 * Pruebas del método addLast de la clase List:
	 * 1- Add en una lista vacía añade el elemento y devuelve true
	 * 2- Add en una lista con varios elementos, añade el elemento en la última posición y devuelve true
	 * 3- Add en una lista vacía añade el elemento en la primera posición y devuelve true
	 * 4- Se puede añadir un elemento repetido
	 * 5- Intentar añadir un null, se lanza IllegalArgumentException
	 */
	
	/**
	 * 1- Add en una lista vacía añade el elemento y devuelve true
	 * GIVEN Se crea una lista 
	 * WHEN Se añade un objeto
	 * THEN Se comprueba que no está vacía
	 */
	@Test
    public void addLastTest() {        
        list.add("Objeto1");
        assertFalse(list.isEmpty());
    }
	
	/**
	 * 2- Add en una lista con varios elementos, añade el elemento en la última posición y devuelve true
	 * GIVEN Se crea una lista 
	 * WHEN Se añaden objetos
	 * THEN Se comprueba que no está vacía
	 */
    @Test
    public void addLastTest2() {
        list.add("Objeto1");
        list.add("Objeto2");
        list.add("Objeto3");
        list.add("Objeto4");        
        assertEquals("Objeto4",list.get(list.size()-1));
    }
    
    /**
     * 3- Add en una lista vacía añade el elemento en la primera posición y devuelve true
	 * GIVEN Se crea una lista 
	 * WHEN Se añaden objetos
	 * THEN Se comprueba que no está vacía
	 */
    @Test
    public void addLastTest3() {
        list.add("Objeto1");
        list.add("Objeto2");
        list.add("Objeto3");
        list.add("Objeto4");        
        assertEquals("Objeto4",list.get(list.size()-1));
    }
    
    /**
     * 4- Se puede añadir un elemento repetido
	 * GIVEN Se crea una lista 
	 * WHEN Se añaden objetos, uno repetido
	 * THEN Se comprueba que no está vacía
	 */
    @Test
    public void addLastTest4() {
        Object obj="Objeto1";
        list.add(obj);
        list.add("Objeto1");
        list.add("Objeto2");
        list.add("Objeto3");
        list.add("Objeto4");        
        assertEquals(obj,list.get(0));
    }
    
    /**
     * 5- Intentar añadir un null, se lanza IllegalArgumentException
	 * GIVEN Se crea una lista 
	 * WHEN Se añade un bull
	 * THEN Se lanza la excepción
	 */
    @Test
    (expected=IllegalArgumentException.class)
    public void addLast5() {
        list.add(null);
    }
}
