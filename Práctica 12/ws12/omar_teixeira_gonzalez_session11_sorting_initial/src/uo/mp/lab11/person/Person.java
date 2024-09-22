package uo.mp.lab11.person;

/**
 * Titulo: Clase Person
 * 
 * @author Omitg
 * @version 22-04-2021
 */
public class Person implements Comparable<Person> {
	/**
	 * Atributo name
	 */
	private String name;
	/**
	 * Atributo surname
	 */
	private String surname;
	/**
	 * Atributo age
	 */
	private int age;

	/**
	 * Constructor con parametros que crea la persona
	 * 
	 * @param name, nombre
	 * @param surname, apellido
	 * @param age, edad
	 */
	public Person(String name, String surname, int age) {
		this.name = name;
		this.surname = surname;
		this.age = age;
	}

	/**
	 * Método que devuelve la edad
	 * 
	 * @return age, edad
	 */
	public int getAge() {
		return age;
	}
	
	/**
	 * Método que devuelve el nombre
	 * 
	 * @return name , nombre
	 */
	public String getName() {
		return name;
	}
	
	/**
	 * Método que devuelve el apellido
	 * 
	 * @return surname, apellido
	 */
	public String getSurname() {
		return surname;
	}
	
	/**
	 * Método que devuelve una cadena con los datos
	 * 
	 * @return cadena con los datos
	 */
	@Override
	public String toString() {
		return name + " " + surname;
	}
	
//	/**
//	 * Método que compara dos personas
//	 * 
//	 * @param that, la otra persona
//	 * @return dif, diferencia entre las dos
//	 */
//	@Override
//	public int compareTo(Person that) {
//		int dif = this.getAge() - that.getAge();
//		return dif;
//	}
	
	
	/**
	 * Método que compara dos personas
	 * 
	 * @param that, la otra persona
	 * @return dif, diferencia entre las dos
	 */
	@Override
	public int compareTo(Person that) {
		//comparar por edad
		int dif = this.getAge() - that.getAge();
		//comparar por apellido
		dif = dif == 0 ? this.getSurname().compareTo( that.getSurname() ) : dif;
		//comparar por nombre
		dif = dif == 0 ? this.getName().compareTo( that.getName() ): dif;
	
		return dif;
	}
	
}