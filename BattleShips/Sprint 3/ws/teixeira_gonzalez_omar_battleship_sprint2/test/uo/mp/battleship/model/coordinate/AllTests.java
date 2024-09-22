package uo.mp.battleship.model.coordinate;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;

/**
 * Titulo: Clase AllTest
 * 
 * @author Omitg
 * @version 07-03-2021
 */
@RunWith(Suite.class)
@SuiteClasses({ CoordinateWithIntParamsTest.class, toStringTest.class, 
	toUserStringTest.class, GoTest.class })
public class AllTests {

}
