package uo.mp.collections.impl.stack;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;

/**
 * Titulo: Clase AllTests
 * 
 * @author Omitg
 * @version 30-03-2021
 */
@RunWith(Suite.class)
@SuiteClasses({ ArrayStackIsEmptyTest.class, ArrayStackPeekTest.class, ArrayStackPopTest.class,
		ArrayStackPushTest.class, ArrayStackSizeTest.class, LinkedStackIsEmptyTest.class, LinkedStackPeekTest.class,
		LinkedStackPopTest.class, LinkedStackPushTest.class, LinkedStackSizeTest.class })
public class AllTests {

}
