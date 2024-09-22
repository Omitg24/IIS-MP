package uo.mp.collections.iterator;

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
@SuiteClasses({ ArrayListIteratorHasNextTest.class, LinkedListIteratorHasNextTest.class,
	ArrayListIteratorNextTest.class, LinkedListIteratorNextTest.class, ArrayListIteratorRemoveTest.class, 
	LinkedListIteratorRemoveTest.class})
public class AllTests {

}
