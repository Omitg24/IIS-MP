package uo.mp.battleship;


import uo.mp.battleship.game.Game;
import uo.mp.battleship.gui.GUIContainer;
import uo.mp.battleship.gui.GUIGamePresenter;
import uo.mp.battleship.interaction.RandomInteractor;
import uo.mp.battleship.player.Player;

/**
 * Titulo: Clase Main
 * 
 * Descripción: Clase que ejecuta el programa
 * 
 * @author Omitg
 * @version 24-03-2021
 */
public class Main {
	/**
	 * Constante por defecto
	 */
	public static final int DEFAULT=10;	
	
	/**
	 * Atributo game
	 */
	private Game game;
	
	/**
	 * Método estatico que lanza el programa
	 * 
	 * @param args, argumento a analizar
	 */
	public static void main(String[] args) {
		new Main()
			.configure()
			.run();
	}

	/**
	 * Método que configura el algoritmo
	 * 
	 * @return this, app configurada
	 */
	private Main configure() {	
		GUIContainer container = new GUIContainer(DEFAULT);				
		GUIGamePresenter ggp = container.getPresenter();
		
		Player computer = new Player("The Machine");
		computer.setInteractor(new RandomInteractor(DEFAULT));

		Player user = new Player("The Person");
		user.setInteractor(container.getInteractor());

		game = new Game( user, computer );
		game.setDebugMode( true );
		game.setPresenter( ggp );
		return this;
	}

	/**
	 * Método que lanza el programa
	 */
	private void run() {
		game.play();
	}


}
