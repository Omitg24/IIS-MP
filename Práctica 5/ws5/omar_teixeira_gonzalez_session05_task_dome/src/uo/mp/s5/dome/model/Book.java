package uo.mp.s5.dome.model;

import java.io.PrintStream;

import uo.mp2021.util.checks.ArgumentChecks;

/**
 * Titulo: Clase Book
 * 
 * @author Omitg
 * @version 04-03-2021
 */
public class Book extends Item implements Borrowable{
//Constantes:
	/**
	 * Tasa
	 */
	public static final double TAX = 0.4;
//Atributos:
	/**
	 * Atributo autor
	 */
	private String author;
	
	/**
	 * Atributo editorial
	 */
	private String editorial;
	
	/**
	 * Atributo isbn
	 */
	private String isbn;
	
	/**
	 * Atributo de si esta disponible
	 */
	private boolean isAvailable;
	
	/**
	 * Constructor con parámetros de la clase Book
	 * 	
	 * @param title, titulo del libro
	 * @param basePrice, precio base del libro
	 * @param author, autor del libro
	 * @param editorial, editorial del libro
	 * @param isbn, isbn del libro
	 */
	public Book(String title, String author, String editorial, 
			String isbn, double basePrice) {
		super(title, basePrice);
		ArgumentChecks.isTrue(author!=null && !author.trim().isEmpty(), 
				"El author no cumple los requisitos");
		ArgumentChecks.isTrue(editorial!=null && !editorial.trim().isEmpty(), 
				"La editorial no cumple los requisitos");
		ArgumentChecks.isTrue(isbn!=null && !isbn.trim().isEmpty(), 
				"El ISBN no cumple los requisitos");
		setAuthor(author);
		setEditorial(editorial);
		setIsbn(isbn);
		this.isAvailable=true;
	}
	
	/**
	 * Constructor con parámetros de la clase Book
	 * 	
	 * @param title, titulo del libro
	 * @param basePrice, precio base del libro
	 * @param author, autor del libro
	 * @param editorial, editorial del libro
	 * @param isbn, isbn del libro
	 * @param gotIt, si es propietario o no
	 */
	public Book(String title, String author, String editorial, 
			String isbn, double basePrice, boolean gotIt) {
		super(title, basePrice);
		ArgumentChecks.isTrue(author!=null && !author.trim().isEmpty(), 
				"El author no cumple los requisitos");
		ArgumentChecks.isTrue(editorial!=null && !editorial.trim().isEmpty(), 
				"La editorial no cumple los requisitos");
		ArgumentChecks.isTrue(isbn!=null && !isbn.trim().isEmpty(), 
				"El ISBN no cumple los requisitos");
		setAuthor(author);
		setEditorial(editorial);
		setIsbn(isbn);
		setOwn(gotIt);
		this.isAvailable = true;
	}
	
	/**
	 * Método que devuelve el valor del atributo author
	 * 
	 * @return author, autor del libro
	 */
	public String getAuthor() {
		return author;
	}
	
	/**
	 * Método que modifica el valor del atributo author
	 * 
	 * @param author, autor del libro
	 */
	private void setAuthor(String author) {
		this.author = author;
	}
	
	/**
	 * Método que devuelve el valor del atributo editorial
	 * 
	 * @return editorial, editorial del libro
	 */
	public String getEditorial() {
		return editorial;
	}
	
	/**
	 * Método que modifica el valor del atributo editorial
	 * 
	 * @param editorial, editorial del libro
	 */
	private void setEditorial(String editorial) {
		this.editorial = editorial;
	}
	
	/**
	 * Método que devuelve el valor del atributo isbn
	 * 
	 * @return isbn, isbn del libro
	 */
	public String getIsbn() {
		return isbn;
	}
	
	/**
	 * Método que modifica el valor del atributo isbn
	 * 
	 * @return isbn, isbn del libro
	 */
	private void setIsbn(String isbn) {
		this.isbn = isbn;
	}
	
	/**
	 * Método que imprime por pantalla los datos correspondientes del Book, por
	 * ejemplo: Titulo, autor, editorial, isbn, etc...
	 * 
	 * @param out, lugar donde imprimir los datos, de tipo PrintStream
	 */
	public void print(PrintStream out) {
		out.println("Book: " + getTitle());
		out.println("Author: " + getAuthor());
		if (getOwn()) {
			out.println("You own it");
		} else {
			out.println("You do not own it");
		}
		out.println("Comment: " + getComment());
		out.println("Editorial: " + getEditorial());
		out.println("ISBN: " + getIsbn()+ "\n");
	}
	
	/**
	 * Nétodo que devuelve las caracteristicas del Item
	 * 
	 * @return result, caracteristicas del Item
	 */
	public String toString() {		
		String result = super.toString();
		result = result + "Author: " + getAuthor() + "\n";
		result = result + "Editorial: " + getEditorial() + "\n";
		result = result + "ISBN: " + getIsbn() + "\n";
		return result;
	}
	
	/**
	 * Método que imprime los responsables de entre los objetos poseidos
	 * 
	 * @param out, lugar de impresion del método
	 */
	public void printResponsible(PrintStream out) {
		ArgumentChecks.isTrue(out != null, "La impresión no debe ser null");
		if (getOwn()) {
			out.println("\t--> " + getAuthor());
		}
		
	}

	/**
	 * Método que compara dos items mediante su titulo y arista/director/autor
	 * 
	 * @param item, item a compara, de tip Item
	 * @return true o false, en función de si son iguales o no
	 */
	public boolean isLike(Item item) {
		ArgumentChecks.isTrue(item!=null, "El item no puede ser null");
		if (item instanceof Book) {
			if (this.getTitle().equals(item.getTitle()) 
				&& this.getAuthor().equals(((Book) item).getAuthor()) &&
				this.getIsbn().equals(((Book) item).getIsbn())) {
				return true;
			} else {
				return false;
			}
		}
		return false;
	}	

	/**
	 * Método que devuelve el precio final del book
	 * 
	 * @return precio final del book
	 */
	public double totalValue() {
		return getBasePrice() + (getBasePrice()*TAX);
	}
	
	/**
	 * Método que devuelve true o false si un libro esta disponible
	 * 
	 * @return true o false
	 */
	public boolean isAvailable() {
		return this.getOwn() && this.isAvailable;
	}
	
	/**
	 * Método que presta un libro y cambia el estado del atributo isAvailable a 
	 * false tras prestarlo
	 */
	public void borrow() {
		this.isAvailable=false;
	}
	
	/**
	 * Método que devuelve un libro y cambia el estado del atributo isAvailable a 
	 * true tras devolverlo
	 */
	public void giveBack() {
		this.isAvailable=true;
	}
	
	/**
	 * Método hashCode, devuelve caracteristicas del objeto
	 * 
	 * @return result, las caracteristicas del objeto
	 */
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = super.hashCode();
		result = prime * result + ((author == null) ? 0 : author.hashCode());
		result = prime * result + ((editorial == null) ? 0 : editorial.hashCode());
		result = prime * result + ((isbn == null) ? 0 : isbn.hashCode());
		return result;
	}
	
	/**
	 * Métodoo equals, que compara objetos 
	 * 
	 * @param obj, objeto a comparar
	 * @return true o false, en función de si son iguales
	 */
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (!super.equals(obj))
			return false;
		if (getClass() != obj.getClass())
			return false;
		Book other = (Book) obj;
		if (author == null) {
			if (other.author != null)
				return false;
		} else if (!author.equals(other.author))
			return false;
		if (editorial == null) {
			if (other.editorial != null)
				return false;
		} else if (!editorial.equals(other.editorial))
			return false;
		if (isbn == null) {
			if (other.isbn != null)
				return false;
		} else if (!isbn.equals(other.isbn))
			return false;
		return true;
	}
}
