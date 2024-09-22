package uo.mp.collections.impl.queue;

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
@SuiteClasses({ ArrayQueueDequeueTest.class, ArrayQueueEnqueueTest.class, ArrayQueueIsEmptyTest.class,
		ArrayQueuePeekTest.class, ArrayQueueSizeTest.class, LinkedQueueDequeueTest.class, LinkedQueueEnqueueTest.class,
		LinkedQueueIsEmpty.class, LinkedQueuePeekTest.class, LinkedQueueSizeTest.class })
public class AllTests {

}
