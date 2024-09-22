package uo.mp.s2.game.model.game2048;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;

/**
 * <p>
 * T�tulo: Clase AllTests 
 * <p>
 * 
 * @author Omar Teixeira Gonz�lez
 * @version 11/02/2021
 */

@RunWith(Suite.class)
@SuiteClasses({ CompactDownTest.class, CompactLeftTest.class, CompactRightTest.class, CompactUpTest.class,
		Game2048WithBoardParamTest.class, Game2048WithIntParamTest.class, Game2048WithoutParamsTest.class,
		IsBoardFullTest.class, NextTest.class, RestartTest.class, RotateBoardTest.class, MoveRightTest.class,
		MoveLeftTest.class, MoveUpTest.class, MoveDownTest.class})
public class AllTests {

}
