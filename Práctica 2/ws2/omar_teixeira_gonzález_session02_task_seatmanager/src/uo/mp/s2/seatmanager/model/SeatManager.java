package uo.mp.s2.seatmanager.model;

import java.util.ArrayList;

import uo.mp.util.checks.*;

/**
 * <p>
 * Titulo: Clase SeatManager
 * </p>
 * Descripci�n: Clase encargada de sentar a las personas
 *  
 * @author Omitg
 * @version 13/02/2021
 */

public class SeatManager {

//Constantes:
	/**
	 * N�mero m�ximo de filas
	 */
	public static final int MAX_ROWS = 10;
	
	/**
	 * N�mero m�ximo de columnas
	 */
	public static final int MAX_COLUMNS = 4;
	
//Atributos: 
	/**
	 * Personas a sentar
	 */
	private Person[][] seats;
	
	/**
	 * Filas del array bidimensional 	
	 */
	private int rows;
	
	/**
	 * Columnas del array bidimensional
	 */
	private int columns;

	
	/**
	 * Constructor con par�metros rows y columns de la calse SeatManager
	 * 
	 * @param rows, filas del array, de tipo int
	 * @param columns, columnas del array, de tipo int
	 */
	public SeatManager(int rows, int columns) {
		ArgumentsCheck.isTrue(rows<=MAX_ROWS && columns<=MAX_COLUMNS, "El array no cumple los requisitos");
		setRows(rows);
		setColumns(columns);
	    seats =  new Person[rows][columns];	
	}
	
	/**
	 * M�todo que modifica el valor del atributo rows
	 * 
	 * @param rows, filas del array, de tipo int
	 */
	private void setRows(int rows) {
		this.rows=rows;
	}
	
	/**
	 * M�todo que modifica el valor del atributo column
	 *  
	 * @param columns, columnas del array, de tipo int
	 */
	private void setColumns(int columns) {
		this.columns=columns;
	}
	
	/**
	 * M�todo que devuelve el valor del atributo rows
	 * 
	 * @return rows, filas del avi�n
	 */
	public int getRows() {
		return rows;
	}

	/**
	 * M�todo que devuelve el valor del atributo columns
	 * 
	 * @return columns, columnas del avi�n
	 */
	public int getColumns() {
		return columns;
	}
	
	/**
     * M�todo que dado un persona, una fila y una columna, si el asiento en el que se quiere sentar esta vac�o (null),
     * se sienta en dicha posici�n del array; en caso contrario (de estar ocupado), comprueba si la persona es adulta no jubilada,
     * de ser as�, sienta a la persona en dicha posici�n y devuelve true. Si la persona no se puede sentar devuelve false
     * 
     * @param passenger, persona a sentar en el array, de tipo Person
     * @param row, fila del array, de tipo int
     * @param column, columna del array, de tipo int
     * 
     * @return true o false, en funci�n de si se cumple la condicion dada
     */
    public boolean bookSeat(Person passenger, int row, int column){
        ArgumentsCheck.isTrue(passenger != null, "Esperaba pasajero y fue null");
        ArgumentsCheck.isTrue(row >= 0 && row <  seats.length, "Fila fuera de limites");
        ArgumentsCheck.isTrue(column>=0 && column < seats[row].length, "Columna fuera de limites");        
        if (seats[row][column] == null || (seats[row][column].getAge()>=Person.ADULTHOOD_AGE 
        		&& seats[row][column].getAge()<=Person.RETIREMENT_AGE)){
            seats[row][column] =  passenger;
            return true;
        }
        return false;
    }
    
    
   /**
    * M�todo que dado una edad minima y m�xima, devuelve una lista con las personas sentadas en filas pares 
    * y con la edad comprendida entre esas edades introducidas como parametro, es decir: [min_age,max_age].
    * 
    * @param min_age, edad m�nima que deben tener las personas para ser a�adidas a la lista
    * @param max_age, edad m�xima que deben tener las personas para ser a�adidas a la lista
    * 
    * @return listOfPassengers, lista de pasajeros que cumplen los requisitos previamente mencionados
    */
    public ArrayList<Person> findPassengersByAge(int min_age, int max_age){
    	ArgumentsCheck.isTrue(min_age>=Person.MIN_AGE && min_age<=Person.MAX_AGE, 
    			"El l�mite inferior (edad m�nima) no cumple los par�metros");
    	ArgumentsCheck.isTrue(max_age>=Person.MIN_AGE && max_age<=Person.MAX_AGE, 
    			"El l�mite superior (edad m�xima) no cumple los par�metros");
    	ArgumentsCheck.isTrue(min_age<max_age, "El limite m�nimo es mayor que el m�ximo");
    	ArrayList<Person> listOfPassengers = new ArrayList<Person>();    	
    	for (int i=0; i<seats.length;i+=2) {
    		for (int j=0; j<seats[i].length;j++) {
    			if (seats[i][j]!=null) {
    				if (seats[i][j].getAge()>=min_age && seats[i][j].getAge()<=max_age) {
    					listOfPassengers.add(seats[i][j]);
    				}
    			}
    		}
    	}
    	return listOfPassengers;
    }

//M�todo extra
    /**
     * M�todo que convierte el array bidimensional a String con una identificaci�n en funci�n de la edad
     */
    public String toString() {
    	String array = "";
		for (int i=0; i<seats.length;i++) {			
			for (int j=0; j<seats[i].length;j++) {
				if (seats[i][j]==null) {
					array += " 0 ";
				} else if (seats[i][j]!=null && seats[i][j].getAge()<Person.ADULTHOOD_AGE) {
					array+=" C ";
				} else if (seats[i][j]!=null && seats[i][j].getAge()>=Person.ADULTHOOD_AGE && 
						seats[i][j].getAge()<Person.RETIREMENT_AGE) {
					array+=" A ";
				} else {
					array+=" X ";
				}
			}
			array+="\n";
		}
		return array;
	}
}
