package uo.mp.s2.seatmanager.model;

/**
 * Titulo: Clase Person
 * 
 * Descripci�n: personas que se sentar�n mediante la clase SeatManager
 * 
 * @author Omitg
 * @version 13/02/2021
 */

public class Person {

//Constantes:
	/**
	 * M�nimo de edad
	 */
	public final static int MIN_AGE = 0;
	
	/**
	 * M�ximo de edad
	 */
    public final static int MAX_AGE = 120;
    
    /**
     * Mayor�a de edad
     */
    public static final int ADULTHOOD_AGE = 18;
    
    /**
     * Edad de jubilaci�n
     */
    public static final int RETIREMENT_AGE = 65;     // edad de jubilaci�n 

//Atributos:
    /**
     * Nombre de la persona
     */
	private String name;
	
	/**
	 * Edad de la persona
	 */
	private int age; 

	
	/**
	 * Constructor con par�metros name y age de la clase Person
	 * 
	 * @param name, nombre de la persona, de tipo String
	 * @param age, edad de la persona, de tipo int
	 */
	public Person(String name, int age) {
		setName(name);
		setAge(age);
	}

	/**
	 * Modifica el valor del nombre de la persona
	 * 
	 * @param name, el nuevo nombre que se le da a la persona, de tipo String
	 */
	private void setName(String name) {
		this.name = name;
	}

	/**
	 * Modifica el valor de la edad de la persona
	 * 
	 * @param age, el nuevo valor que se le da a la edad, de tipo int
	 */
	private void setAge(int age) {
		if (age >= MIN_AGE && age < MAX_AGE)
			this.age = age;
	}

	/**
	 * Devuelve el nombre de la persona
	 * 
	 * @return	name, nombre de la persona, de tipo String
	 */	
	public String getName() {
		return name;
	}

	/**
	 * Devuelve la edad de la persona
	 * 
	 * @return age, edad de la persona, de tipo int
	 */	
	public int getAge() {
		return age;
	}

	/**
	 * Devuelve una cadena con los datos de la persona
	 *
	 * @return cadena con todos los propiedades de la persona
	 */
	public String toString() {
	  return "Nombre: " + getName().toUpperCase() + " Edad: " + getAge();				
	}

	/**
	 * Devuelve : 
	 *   Si la persona es menor de edad, los a�os que le
	 *     faltan hasta la mayor�a. 
	 *   Si la persona es mayor de edad pero menor de 65
	 *     los a�os que le faltan hasta 65 
	 *   Si la persona es mayor de 65 
	 *     los a�os que pasa de 65
	 *
	 * @return double cantidad de años
	 */
	public double getCriticalAge() {
		if (this.getAge() < ADULTHOOD_AGE)
			return ADULTHOOD_AGE - getAge();
		if (getAge() >= ADULTHOOD_AGE && getAge() < RETIREMENT_AGE)
			return RETIREMENT_AGE - getAge();
		else
			return getAge() - RETIREMENT_AGE;
	}	
}