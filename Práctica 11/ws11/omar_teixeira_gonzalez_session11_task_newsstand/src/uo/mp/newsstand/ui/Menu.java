package uo.mp.newsstand.ui;

import uo.mp.newsstand.ui.console.Console;

/**
 * Titulo: Clase Menu
 * 
 * Shows the user a menu of options. Each option will be identified by a
 * sequential number.
 * 
 * @author Omitg
 * @version 07-04-2021
 */
public class Menu {
	/**
	 * M�todo que devuelve las distintas opciones del programa
	 * 
	 * @return opciones del programa
	 */
	private String[] options = { "Load a file", "Show publications", "Add publication", "Remove publication",
			"Create orders", "", "Save orders to file", "Import from zip", "Export to zip", "",
			"Sort publications by name", "Sort publications by sales", "Sort orders by quantity & name", };

	/**
	 * M�todo que lee la opci�n a realizar
	 * 
	 * @return opci�n escogida
	 */
	public int readOption() {
		return Console.readInteger("Option");
	}

	/**
	 * M�todo que muestra el programa por pantalla
	 */
	public void show() {
		int i = 1;
		for (String line : options) {
			if ("".equals(line)) {
				Console.println("");
				continue;
			}

			Console.printf("\t%2d- %s\n", i++, line);
		}
		Console.printf("\n\t%2d- %s\n", 0, "Exit");
	}

}
