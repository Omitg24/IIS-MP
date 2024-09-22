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
	 * Creaci�n de la lista para su posterior uso
	 */
	@Before
	public void setUp(){
		list = Settings.factory.newList();
	}
	
	/**
	 * Pruebas del m�todo addLast de la clase List:
	 * 1- Add en una lista vac�a a�ade el elemento y devuelve true
	 * 2- Add en una lista con varios elementos, a�ade el elemento en la �ltima posici�n y devuelve true
	 * 3- Add en una lista vac�a a�ade el elemento en la primera posici�n y devuelve true
	 * 4- Se puede a�adir un elemento repetido
	 * 5- Intentar a�adir un null, se lanza IllegalArgumentException
	 */
	
	/**
	 * 1- Add en una lista vac�a a�ade el elemento y devuelve true
	 * GIVEN Se crea una lista 
	 * WHEN Se a�ade un objeto
	 * THEN Se comprueba que no est� vac�a
	 */
	@Test
    public void addLastTest() {        
        list.add("Objeto1");
        assertFalse(list.isEmpty());
    }
	
	/**
	 * 2- Add en una lista con varios elementos, a�ade el elemento en la �ltima posici�n y devuelve true
	 * GIVEN Se crea una lista 
	 * WHEN Se a�aden objetos
	 * THEN Se comprueba que no est� vac�a
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
     * 3- Add en una lista vac�a a�ade el elemento en la primera posici�n y devuelve true
	 * GIVEN Se crea una lista 
	 * WHEN Se a�aden objetos
	 * THEN Se comprueba que no est� vac�a
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
     * 4- Se puede a�adir un elemento repetido
	 * GIVEN Se crea una lista 
	 * WHEN Se a�aden objetos, uno repetido
	 * THEN Se comprueba que no est� vac�a
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
     * 5- Intentar a�adir un null, se lanza IllegalArgumentException
	 * GIVEN Se crea una lista 
	 * WHEN Se a�ade un bull
	 * THEN Se lanza la excepci�n
	 */
    @Test
    (expected=IllegalArgumentException.class)
    public void addLast5() {
        list.add(null);
    }
}
