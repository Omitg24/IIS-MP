package uo.mp.battleship.model.turnselector;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import uo.mp.battleship.game.TurnSelector;
import uo.mp.battleship.player.Player;

/**
 * Titulo: Clase NextTest
 * 
 * @author Omitg
 * @version 16-04-2021
 */
public class NextTest {
	/**
	 * Pruebas del método next de la clase TurnSelector:
	 * 1- Dos llamadas consecutivas devolveran jugadores alternados
	 */
	
	/**
	 * 1- Dos llamadas consecutivas devolveran jugadores alternados
	 * GIVEN Se crean jugadores humano y ordenador, y un selector de turno
	 * WHEN Se llama al método next 2 veces
	 * THEN Se comprueba que devuelve los jugadores creados de forma alternada
	 */
	@Test
	public void testDoubleNext() {
		Player human = new Player("Omitg");
		Player computer = new Player("Computer");
		TurnSelector selector = new TurnSelector(human, computer);
		assertEquals(computer,selector.next());
		assertEquals(human,selector.next());
	}
}
