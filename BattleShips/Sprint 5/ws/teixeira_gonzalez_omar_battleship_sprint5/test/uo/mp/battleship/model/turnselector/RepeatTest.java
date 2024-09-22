package uo.mp.battleship.model.turnselector;

import static org.junit.Assert.assertTrue;

import org.junit.Test;

import uo.mp.battleship.game.TurnSelector;
import uo.mp.battleship.player.Player;

/**
 * Titulo: Clase RepeatTest
 * 
 * @author Omitg
 * @version 07-05-2021
 */
public class RepeatTest {
	/**
	 * Pruebas del método repeat de la clase TurnSelector:
	 * 1- Llamada a repeat debe devolver el mismo jugador
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
		selector.repeat();
		assertTrue(selector.getTurn());
	}
}
