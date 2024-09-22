package uo.mp.s3.post.model.photo;

import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;

import uo.mp.s3.post.model.Photo;

/**
 * Titulo: Clase PhotoTest
 * 
 * @author Omitg
 * @version 20-02-2021
 */
public class PhotoTest {
//Atributos
	/**
	 * Usuario que public� la foto
	 */
	private String userName;
	
	/**
	 * Fichero donde se almacen� la foto
	 */
	private String file;
		
	/**
	 * Creaci�n de atributos para su uso posterior
	 */
	@Before
	public void setUp() {
		userName = "Omitg";
		file = "CreatorFile";
	}
		
	/**
	 * Pruebas del constructor con par�metros de la clase Message:
	 * Pruebas de funcionalidad:
	 * 1- Par�metros validos -> Se crea el objeto
	 * 
	 * Pruebas de robustez:
	 * 2- Usuario invalido -> Lanza la excepci�n
	 * 3- Fichero invalido -> Lanza la excepci�n
	 */
//Pruebas de funcionalidad:
	/**
	 * 1- Par�metros validos -> Se crea el objeto
	 * GIVEN
	 * WHEN Se pasa un usuario y fichero validos
	 * THEN Se crea el objeto
	 */
	@Test
	public void testConstructorValidParams() {
		Photo pic = new Photo (userName, file);
		assertEquals(userName,pic.getUser());
		assertEquals(file, pic.getFile());
	}
		
//Pruebas de robustez:
	/**
	 * 2- Usuario invalido -> Lanza la excepci�n
	 * GIVEN
	 * WHEN Se pasa un usuario invalido
	 * THEN Se lanza la excepci�n
	 */
	@Test
	(expected = IllegalArgumentException.class)
		public void testConstructorInvalidUser() {
		new Photo (null,file);
	}
		
	/**
	 * 3- Fichero invalido -> Lanza la excepci�n
	 * GIVEN
	 * WHEN Se pasa un fichero invalido
	 * THEN Se lanza la excepci�n
	 */
	@Test
	(expected = IllegalArgumentException.class)
	public void testConstructorInvalidAFile() {
		new Photo (userName,null);
	}
}
